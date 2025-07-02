/*
 * Filename: TicTacToe
 * Function: Making TicTacToe Game
 * Author ID: 41143209
 * Author: Chung Jen, Wang(王忠仁) 
 * Datetime: March 06, 2024
 * Version: 1.0
 */
import java.util.Scanner;

// 棋子
class Piece {
    private int row;
    private int col;
    private char symbol;

    // constructor
    public Piece(int row, int col, char symbol) {
        this.row = row;
        this.col = col;
        this.symbol = symbol;
    }

    //取得橫行的位置
    public int getRow() {
        return row;
    }

    //取得直行的位置
    public int getCol() {
        return col;
    }

    // 取得O或X
    public char getSymbol() {
        return symbol;
    }
}

// 棋盤
class ChessBoard {
    // 使用二維陣列儲存
    private char[][] board;

    public ChessBoard() {
        board = new char[3][3];
        initializeBoard();
    }

    // 初始化棋盤
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // print棋盤
    public void show() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean placePiece(Piece piece) {
        int row = piece.getRow();
        int col = piece.getCol();
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '-') {
            return false;
        }
        board[row][col] = piece.getSymbol();
        return true;
    }

    // 檢查是否結束遊戲
    public boolean checkGameOver() {
        // 檢查橫行
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true;
            }
        }
        // 檢查直行
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '-' && board[0][j] == board[1][j] && board[0][j] == board[2][j]) {
                return true;
            }
        }
        // 檢查對角線
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return true;
        }
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return true;
        }
        return false;
    }
}
// 玩家
class Player {
    private char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChessBoard board = new ChessBoard();
        Player playerA = new Player('X');
        Player playerB = new Player('O');
        // 玩家A優先出手
        Player currentPlayer = playerA;

        board.show();

        while (!board.checkGameOver()) {
            System.out.println("玩家 " + currentPlayer.getSymbol() + " 回合");
            System.out.print("輸入位置(橫, 直): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            Piece piece = new Piece(row, col, currentPlayer.getSymbol());
            if (board.placePiece(piece)) {
                board.show();
                currentPlayer = (currentPlayer == playerA) ? playerB : playerA;
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        currentPlayer = (currentPlayer == playerA) ? playerB : playerA;
        System.out.println("玩家 " + currentPlayer.getSymbol() + " 獲勝!");
        scanner.close();
    }
}
