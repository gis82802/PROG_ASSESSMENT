// 41143263 黃柏菻 棋類遊戲 2024/03/07

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        // 建立一個 3x3 的棋盤（井字遊戲棋盤）
        ChessBoard cb = new ChessBoard(3, 3);
        Game ttt = new Game(cb);
        
        // 建立兩個玩家
        Player p1 = new Player(Player.FIRST);
        Player p2 = new Player(Player.SECND);
        
        // 建立 “遊戲是否結束” 的標記
        boolean gameOver = false;

        // 開始遊戲
        while (!gameOver) {
            // 玩家進行操作
            if (Game.playerTurner == Player.FIRST) {
                ttt.playerOperate(p1);
            } else {
                ttt.playerOperate(p2);
            }
            
            // 顯示棋盤
            cb.show();
            
            // 輪轉到下一個玩家
            ttt.rotate();
            
            // 檢查遊戲是否結束
            // gameOver = ttt.checkGameOver();
            gameOver = ttt.isPlayerWin();
        }

        // 如果玩家贏了，則輸出贏的訊息，否則輸出輸的訊息
        if (ttt.isPlayerWin()) {
            System.out.println("恭喜你贏了! 🥳");
        } else {
            System.out.println("真可惜，下次再努力! 💪");
        }
    }
}

class Game {
    static int playerTurner = 1;
    static ChessBoard gameBoard;

    Game(ChessBoard cb) {
        gameBoard = cb;
    }

    boolean checkGameOver() {
        return false;
    }

    void rotate() {
        playerTurner = (playerTurner % 2) + 1;
    }

    void playerOperate(Player player) {
        boolean flag = true;
        while (flag) {
            System.out.print("請輸入座標({x|[0,2]}, {y|[0, 2]}): ");
            Scanner scanner = new Scanner(System.in);
            int xValue = scanner.nextInt();
            int yValue = scanner.nextInt();
            flag = player.putPiece(gameBoard, xValue, yValue);
        }
    }

    boolean isPlayerWin() {
        for (int i = 0; i < gameBoard.height; i++) {
            for (int j = 0; j < gameBoard.width; j++) {
                if (gameBoard.boardGrid[i][j] != 0) {
                    // 檢查水平線
                    if (j + 2 < gameBoard.width && gameBoard.boardGrid[i][j] == gameBoard.boardGrid[i][j + 1] && gameBoard.boardGrid[i][j] == gameBoard.boardGrid[i][j + 2]) {
                        return true;
                    }
                    // 檢查垂直線
                    if (i + 2 < gameBoard.height && gameBoard.boardGrid[i][j] == gameBoard.boardGrid[i + 1][j] && gameBoard.boardGrid[i][j] == gameBoard.boardGrid[i + 2][j]) {
                        return true;
                    }
                    // 檢查對角線
                    if (i + 2 < gameBoard.height && j + 2 < gameBoard.width && gameBoard.boardGrid[i][j] == gameBoard.boardGrid[i + 1][j + 1] && gameBoard.boardGrid[i][j] == gameBoard.boardGrid[i + 2][j + 2]) {
                        return true;
                    }
                    if (i - 2 >= 0 && j + 2 < gameBoard.width && gameBoard.boardGrid[i][j] == gameBoard.boardGrid[i - 1][j + 1] && gameBoard.boardGrid[i][j] == gameBoard.boardGrid[i - 2][j + 2]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class ChessBoard {
    int height, width;
    int boardGrid[][];

    ChessBoard(int xValue, int yValue) {
        height = xValue;
        width = yValue;
        boardGrid = new int[xValue][yValue];
    }

    void setPiece(int xValue, int yValue, int code) {
        boardGrid[yValue][xValue] = code;
    }

    void show() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j ++) {
                System.out.print(boardGrid[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

class Player {
    protected final static int FIRST = 1;
    protected final static int SECND = 2;
    int priority;

    Player(int code) {
        priority = code;
    }

    boolean putPiece(ChessBoard cb, int xValue, int yValue) {
        if (cb.boardGrid[yValue][xValue] != 0) {
            return true;
        }
        cb.setPiece(xValue, yValue, priority);
        return false;
    }
}
