//41143248 劉向宏
import java.util.Scanner;
// 主程式
public class HW_Gomoku {
    private ChessBoard cb; // 棋盤物件
    private Player playerA; // 玩家 A
    private Player playerB; // 玩家 B
    private boolean gameover; // 遊戲是否結束的標誌
    public HW_Gomoku() {
        cb = new ChessBoard(); // 創建一個新的棋盤
        playerA = new Player(Player.BLACK); // 創建玩家 A，黑棋
        playerB = new Player(Player.WHITE); // 創建玩家 B，白棋
        gameover = false; // 初始時遊戲未結束
    }
    // 遊戲開始
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("歡迎來到五子棋遊戲！");
        while (!gameover) {
            // 玩家 A 下棋
            System.out.println("輪到玩家 A 下棋 (黑棋)");
            int[] moveA = playerA.getMove(scanner); // 玩家 A 選擇下棋位置
            while (!MoveValidator.isValidMove(moveA[0], moveA[1], cb.getBoard())) { // 檢查是否合法位置
                System.out.println("該位置已有棋子或超出棋盤範圍，請重新輸入：");
                moveA = playerA.getMove(scanner); // 重新輸入位置
            }
            cb.placePiece(moveA[0], moveA[1], playerA.getSymbol()); // 在棋盤上放置玩家 A 的棋子
            cb.show(); // 顯示更新後的棋盤
            // 檢查遊戲是否結束
            if (cb.checkGameOver()) {
                System.out.println("玩家 A (黑棋) 獲勝！");
                gameover = true; // 設置遊戲結束標誌
                break; // 跳出遊戲循環
            }
            // 玩家 B 下棋
            System.out.println("輪到玩家 B 下棋 (白棋)");
            int[] moveB = playerB.getMove(scanner); // 玩家 B 選擇下棋位置
            while (!MoveValidator.isValidMove(moveB[0], moveB[1], cb.getBoard())) { // 檢查是否合法位置
                System.out.println("該位置已有棋子或超出棋盤範圍，請重新輸入：");
                moveB = playerB.getMove(scanner); // 重新輸入位置
            }
            cb.placePiece(moveB[0], moveB[1], playerB.getSymbol()); // 在棋盤上放置玩家 B 的棋子
            cb.show(); // 顯示更新後的棋盤

            // 檢查遊戲是否結束
            if (cb.checkGameOver()) {
                System.out.println("玩家 B (白棋) 獲勝！");
                gameover = true; // 設置遊戲結束標誌
                break; // 跳出遊戲循環
            }
        }
        scanner.close(); // 關閉掃描器
    }
    public static void main(String[] args) {
        HW_Gomoku game = new HW_Gomoku(); // 創建遊戲物件
        game.start(); // 開始遊戲
    }
}
// 棋盤類別
class ChessBoard {
    private char[][] board; // 棋盤矩陣
    public ChessBoard() {
        board = new char[15][15]; // 初始化棋盤大小為 15x15
        // 初始化棋盤，將每個位置設置為空格
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                board[i][j] = '-';
            }
        }
    }
    // 顯示棋盤
    public void show() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    // 檢查遊戲是否結束
    public boolean checkGameOver() {
        // 檢查橫向
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 11; j++) {
                if (board[i][j] != '-' && board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2] &&
                        board[i][j] == board[i][j + 3] && board[i][j] == board[i][j + 4]) {
                    return true;
                }
            }
        }
        // 檢查縱向
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 15; j++) {
                if (board[i][j] != '-' && board[i][j] == board[i + 1][j] && board[i][j] == board[i + 2][j] &&
                        board[i][j] == board[i + 3][j] && board[i][j] == board[i + 4][j]) {
                    return true;
                }
            }
        }
        // 檢查右下斜線
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (board[i][j] != '-' && board[i][j] == board[i + 1][j + 1] && board[i][j] == board[i + 2][j + 2] &&
                        board[i][j] == board[i + 3][j + 3] && board[i][j] == board[i + 4][j + 4]) {
                    return true;
                }
            }
        }
        // 檢查右上斜線
        for (int i = 4; i < 15; i++) {
            for (int j = 0; j < 11; j++) {
                if (board[i][j] != '-' && board[i][j] == board[i - 1][j + 1] && board[i][j] == board[i - 2][j + 2] &&
                        board[i][j] == board[i - 3][j + 3] && board[i][j] == board[i - 4][j + 4]) {
                    return true;
                }
            }
        }
        return false;
    }
    // 放置棋子
    public void placePiece(int row, int col, char piece) {
        board[row][col] = piece; // 放置棋子
    }
    // 取得棋盤矩陣
    public char[][] getBoard() {
        return board;
    }
}
// 玩家類別
class Player {
    public static final char BLACK = '●'; // 黑棋符號
    public static final char WHITE = '○'; // 白棋符號
    private char symbol; // 玩家棋子符號
    public Player(char symbol) {
        this.symbol = symbol; // 初始化玩家棋子符號
    }
    // 取得玩家下棋位置
    public int[] getMove(Scanner scanner) {
        System.out.println("請輸入下棋位置（行 列）：");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[]{row, col};
    }
    // 取得玩家下棋符號
    public char getSymbol() {
        return symbol;
    }
}
// 重複下棋檢查器類別
class MoveValidator {
    // 檢查玩家下棋位置是否合法
    public static boolean isValidMove(int row, int col, char[][] board) {
        if (row >= 0 && row < 15 && col >= 0 && col < 15) { // 檢查是否在棋盤範圍內
            return board[row][col] == '-'; // 檢查該位置是否為空格，即沒有棋子
        }
        return false;
    }
}
