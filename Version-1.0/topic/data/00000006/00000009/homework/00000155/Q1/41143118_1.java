/*
  題目：設計井字棋遊戲(TicTacToe)中的類別，例如：ChessBoard, Player, Piece 等，思考每個類別應具備的成員函式，以及互動方式，例如：
      :
      // TicTacToe 類別可能的使cb, new Piece(5,6));   // 玩家 A 將棋子放在棋盤 cb的五子棋遊戲
      game.start();   // 開始遊戲
      game.checkGameOver();  //檢查是否有玩家勝利
      :
      // ChessBoard 類別可能的使用方式
      ChessBoard  cb = new ChessBoard();  // 建立一個棋盤
      cb.show(); // 印出目前棋盤內容
      :
      // Player 類別可能的使用方式
      Player playerA = new Player(Player.HUMAN_BK); // 建立一個玩家 playerA 執黑棋
      Player playerB = new Player(Player.COMPUTER);  // 建立一個電腦玩家

      playerA.setPieces(cb, new Piece(1,2));   // 玩家 A 將棋子放在棋盤 cb 的位置 (1,2)
  測資範例：
      - - - 
      - - - 
      - - - 
      輪到玩家 X
      輸入行 列 (0-2): 0 0
      X - -
      - - -
      - - -
      輪到玩家 O
      輸入行 列 (0-2): 0 1
      X O -
      - - -
      - - -
      輪到玩家 X
      輸入行 列 (0-2): 1 1
      X O -
      - X -
      - - -
      輪到玩家 O
      輸入行 列 (0-2): 2 0
      X O -
      - X -
      O - -
      輪到玩家 X
      輸入行 列 (0-2): 2 2
      X O -
      - X -
      O - X
      玩家 X 勝利
*/
import java.util.Scanner;

public class TicTacToe_1 {
  private static char[][] location;  // 位置
  private static char currentPlayer;

  public static void main(String[] args) {
    location = new char[3][3];  // 9宮格
    currentPlayer = 'X';
    typesetting();  // 9宮格排版

    Scanner scanner = new Scanner(System.in);
    boolean gameOver = false;

    while (!gameOver) {
      ending();  // 結局
      int[] move = getLocation(scanner);
      recordLocation(move[0], move[1]);//紀錄位置

      if (checkWin()) {
        ending();
        System.out.println("玩家 " + currentPlayer + " 勝利");
        gameOver = true;
      }
      else if (checkFull()) {
        ending();
        System.out.println("平局");
        gameOver = true;
      } 
      else
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
    scanner.close();
  }
  // 9宮格排版(讓玩家清楚分辨哪個位置可以放入)
  private static void typesetting() {
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        location[i][j] = '-';
  }
  // 結局
  private static void ending() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++)
        System.out.print(location[i][j] + " ");
      System.out.println();
    }
  }
  // 輪到目前玩家放入位置
  private static int[] getLocation(Scanner scanner) {
    int[] move = new int[2];
    boolean validInput = false;
    while (!validInput) {
      System.out.println("輪到玩家 " + currentPlayer);
      System.out.print("輸入行 列 (0-2): ");

      move[0] = scanner.nextInt();
      move[1] = scanner.nextInt();

      if (moveValid(move[0], move[1]))
        validInput = true;
      else
        System.out.println("請重新輸入");
    }
    return move;
  }

  private static boolean moveValid(int row, int col) {
    return row >= 0 && row < 3 && col >= 0 && col < 3 && location[row][col] == '-';
  }
  //記錄屬於玩家 O or X 得位置
  private static void recordLocation(int row, int col) {
    location[row][col] = currentPlayer;
  }
  // 檢查直字、橫字、對角線是否連成一線
  private static boolean checkWin() {
    return checkCols() || checkRows() || checkDiagonals();
  }

  private static boolean checkCols() {
    for (int i = 0; i < 3; i++) {
      if (location[0][i] == currentPlayer && location[1][i] == currentPlayer && location[2][i] == currentPlayer)
        return true;
    }
    return false;
  }

  private static boolean checkRows() {
    for (int i = 0; i < 3; i++) {
      if (location[i][0] == currentPlayer && location[i][1] == currentPlayer && location[i][2] == currentPlayer)
        return true;
    }
    return false;
  }
    
  private static boolean checkDiagonals() {
    return (location[0][0] == currentPlayer && location[1][1] == currentPlayer && location[2][2] == currentPlayer) ||
           (location[0][2] == currentPlayer && location[1][1] == currentPlayer && location[2][0] == currentPlayer);
  }

  private static boolean checkFull() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++)
        if (location[i][j] == '-')
          return false;
    }
    return true;
  }
}