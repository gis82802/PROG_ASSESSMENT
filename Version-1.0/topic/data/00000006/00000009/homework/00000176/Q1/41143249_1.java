import java.util.Scanner;
import java.util.Random;
class TTTgame {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    public TTTgame(Player player1, Player player2) {
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        player1.setBoard(board);
        player2.setBoard(board);
    }
    public void startGame() {
        while (!board.isGameOver()) {
            System.out.println(board);
            int[] move = currentPlayer.getMove();
            if (!board.isMoveValid(move)) {
                System.out.println("無效移動 請重新輸入!");
                continue;
            }
            board.makeMove(currentPlayer.getPiece(), move);
            if (board.checkWinner(currentPlayer.getPiece())) {
                System.out.println(currentPlayer.getName() + "勝利!!");
                break;
            }
            if (board.isBoardFull()) {
                System.out.println("此局平手");
                break;
            }
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }
}

class Board {
    private static final int SIZE = 3;
    private Piece[][] board;
    public Board() {
        board = new Piece[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Piece.E;
            }
        }
    }
    public boolean isMoveValid(int[] move) {
        int row = move[0];
        int col = move[1];
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == Piece.E;
    }
    public void makeMove(Piece piece, int[] move) {
        int row = move[0];
        int col = move[1];
        board[row][col] = piece;
    }
    public boolean isGameOver() {return checkWinner(Piece.X) || checkWinner(Piece.O) || isBoardFull();}
    public boolean checkWinner(Piece piece) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == piece && board[i][1] == piece && board[i][2] == piece) {return true;}
            if (board[0][i] == piece && board[1][i] == piece && board[2][i] == piece) {return true;}
        }
        if (board[0][0] == piece && board[1][1] == piece && board[2][2] == piece) {return true;}
        if (board[0][2] == piece && board[1][1] == piece && board[2][0] == piece) {return true;}
        return false;
    }
    public boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == Piece.E) {
                    return false;
                }
            }
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

class Player {
    private String name;
    private Piece piece;
    private Scanner scanner;
    private Board board;

    public Player(String name, Piece piece, Scanner scanner) {
        this.name = name;
        this.piece = piece;
        this.scanner = scanner;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public Board getBoard() {return board;}
    public String getName() {return name;}
    public Piece getPiece() {return piece;}

    public int[] getMove() {
        System.out.print(name + "玩家輸入以空格分隔的行和列(0-2){左上角為(0,0)，右下角為(2,2)}：");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[]{row, col};
    }
}
class AI extends Player {
    private Random random;

    public AI(String name, Piece piece) {
        super(name, piece, null);
        this.random = new Random();
    }

    @Override
    public int[] getMove() {
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!getBoard().isMoveValid(new int[]{row, col}));
        System.out.println(getName() + " 選擇的行 " + row + "和列" + col);
        return new int[]{row, col};
    }
}

enum Piece {
    X,
    O,
    E
}


public class HW20240307{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.玩家對玩家");
        System.out.println("2.玩家對電腦");
        System.out.print("選擇遊戲模式：");
        int choice = scanner.nextInt();
        Player player1, player2;
        switch (choice) {
            case 1:
                System.out.print("輸入玩家 1 的姓名：");
                String player1Name = scanner.next();
                player1 = new Player(player1Name, Piece.X, scanner);
                System.out.print("輸入玩家 2 的姓名：");
                String player2Name = scanner.next();
                player2 = new Player(player2Name, Piece.O, scanner);
                break;
            case 2:
                System.out.print("輸入玩家 1 的姓名： ");
                player1Name = scanner.next();
                player1 = new Player(player1Name, Piece.X, scanner);
                player2 = new AI("電腦", Piece.O);
                break;
            default:
                System.out.println("選擇無效，預設為玩家對玩家模式。");
                System.out.print("輸入玩家 1 的姓名：");
                player1Name = scanner.next();
                player1 = new Player(player1Name, Piece.X, scanner);
                System.out.print("輸入玩家 2 的姓名：");
                player2Name = scanner.next();
                player2 = new Player(player2Name, Piece.O, scanner);
                break;
        }
        TTTgame game = new TTTgame(player1, player2);
        game.startGame();
    }
}