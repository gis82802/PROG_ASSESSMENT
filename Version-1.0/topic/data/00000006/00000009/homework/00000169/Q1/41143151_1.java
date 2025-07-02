import java.io.PrintWriter;
import java.util.Vector;
import java.util.Scanner;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Java_2024_3_13 {
    public static void main(String[] args) {
        Gomoku gomoku = new Gomoku(new ChessBoard(15, 15));
        gomoku.showRules();
        Player[] players = gomoku.initialize();
        gomoku.startGame(players);
    }
}

class Gomoku {
    public ChessBoard chessBoard;

    public Gomoku(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public Player[] initialize() {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        String playerAName;
        String playerBName;
        while (true) {
            printer.println("Please input name of PlayerA:");
            playerAName = scanner.nextLine().trim();
            printer.println("Please input name of PlayerB:");
            playerBName = scanner.nextLine().trim();
            if (playerAName.equals(playerBName))
                printer.println("Duplicate player name.");
            else
                break;
        }
        Optional<Boolean> playerAGoFirst = Optional.empty();
        while (playerAGoFirst.isEmpty()) {
            printer.println("Who go first？(Takes black piece)");
            String input = scanner.nextLine().trim();
            if (input.equals(playerAName))
                playerAGoFirst = Optional.of(true);
            else if (input.equals(playerBName))
                playerAGoFirst = Optional.of(false);
            else
                printer.println("Invalid input.\nPlease enter again.");
        }
        final Player playerA = new Player(playerAName, playerAGoFirst.get());
        final Player playerB = new Player(playerBName, !playerAGoFirst.get());
        return new Player[]{playerA, playerB};
    }

    public void startGame(Player[] players) {
        Player playerA = players[0];
        Player playerB = players[1];
        boolean playerATurn = playerA.pieceType == Piece.Black;
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        printer.println("Game start.");
        while (true) {
            chessBoard.showChessBoard();
            Player currentPlayer = playerATurn ? playerA : playerB;
            printer.println(currentPlayer.name + "'s turn. Please enter your move:");
            String moveInput = scanner.nextLine().trim();
            Optional<Position> movePosition = Position.parse(moveInput);
            if (movePosition.isPresent()) {
                try {
                    Position position = movePosition.get();
                    chessBoard.putPiece(position, currentPlayer.pieceType);
                    if (checkWin(position, currentPlayer.pieceType)) {
                        chessBoard.showChessBoard();
                        printer.println("Player " + currentPlayer.name + " (" + currentPlayer.pieceType + ") wins!");
                        break;
                    }
                    playerATurn = !playerATurn;
                } catch (IllegalArgumentException e) {
                    printer.println(e.getMessage() + " Please enter your move again.");
                }
            } else
                printer.println("Invalid input. Please enter your move in the format: (x, y).");
            printer.clearScreen();
            if (chessBoard.isFull()) {
                printer.println("The game is a draw.");
                break;
            }
        }
    }

    public boolean checkWin(Position position, Piece piece) {
        int[][] displacement = {{1, 0}, {0, 1}, {1, 1}, {-1, 1}};
        for (int[] d : displacement)
            if (chessBoard.countPieces(position, piece, d[0], d[1]) + chessBoard.countPieces(position, piece, -d[0], -d[1]) - 1 == 5)
                return true;
        return false;
    }

    public void showRules() {
        Printer printer = new Printer();
        printer.println("Players alternate turns placing a stone of their color on an empty intersection.");
        printer.println("Black plays first.");
        printer.println("The winner is the first player to form an unbroken line of five stones of their color horizontally, vertically, or diagonally.");
        printer.println("This line must be exactly five stones long; six or more stones in a x does not count as a win and is called an overline.");
        printer.println("If the board is completely filled and no one can make a line of 5 stones, then the game ends in a draw.");
        printer.println("Input is output in this format: (x, y)");
        printer.println("Ex: (4, 12)");
    }
}

class ChessBoard {
    final int length;
    final int width;
    private final Vector<Vector<Optional<Piece>>> data = new Vector<>();

    public ChessBoard(int length, int width) {
        this.length = length;
        this.width = width;
        for (int i = 0; i < length; i++) {
            Vector<Optional<Piece>> row = new Vector<>(width);
            for (int j = 0; j < width; j++)
                row.add(Optional.empty());
            data.add(row);
        }
    }

    public void putPiece(Position position, Piece piece) {
        final int x = position.x();
        final int y = position.y();
        if (x < 0 || x >= length || y < 0 || y >= width) {
            throw new IllegalArgumentException("Position out of bounds.");
        }
        if (data.get(x).get(y).isEmpty())
            data.get(x).set(y, Optional.of(piece));
        else
            throw new IllegalArgumentException("There are already chess pieces.");
    }

    public int countPieces(Position position, Piece piece, int dx, int dy) {
        int count = 0;
        int x = position.x();
        int y = position.y();
        while (x >= 0 && x < length && y >= 0 && y < width && data.get(x).get(y).isPresent() && data.get(x).get(y).get() == piece) {
            count++;
            x += dx;
            y += dy;
        }
        return count;
    }

    public boolean isFull() {
        for (Vector<Optional<Piece>> row : data)
            for (Optional<Piece> cell : row)
                if (cell.isEmpty())
                    return false;
        return true;
    }

    public void showChessBoard() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                Optional<Piece> piece = data.get(i).get(j);
                System.out.print(piece.isPresent() ? piece.get() : "➕");
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

enum Piece {
    White {
        @Override
        public String toString() {
            return "⚪";
        }
    },
    Black {
        @Override
        public String toString() {
            return "⚫";
        }
    },
}

class Player {
    public final String name;
    public Piece pieceType;

    Player(String name, boolean goFirst) {
        this.name = name;
        pieceType = (goFirst ? Piece.Black : Piece.White);
    }
}

record Position(int x, int y) {
    public static Optional<Position> parse(String input) {
        Pattern pattern = Pattern.compile("\\((\\d+),\\s*(\\d+)\\)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            return Optional.of(new Position(x, y));
        } else
            return Optional.empty();
    }
}

class Printer {
    private final PrintWriter printWriter = new PrintWriter(System.out, true);

    public void println(String string) {
        printWriter.println(string);
    }

    //ANSI escape sequences
    public void clearScreen() {
        printWriter.print("\033[H\033[2J");
    }
}
