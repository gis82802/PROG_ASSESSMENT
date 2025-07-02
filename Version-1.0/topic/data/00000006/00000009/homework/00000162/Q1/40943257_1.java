class Piece {
    private int x, y;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

class ChessBoard {
    private char[][] board;
    private int size = 3;
    private char playerRound = ' ';
    private boolean isEnd;
    private char winner;

    public ChessBoard () {
        board = new char[size][size];
        isEnd = false;
        winner = ' ';

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
               board[i][j] = ' ';
            }
        }
    }

    public void show() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                System.out.print(board[i][j]);

                if(j < size - 1) {
                    System.out.print('|');
                }
            }
            System.out.println();
            
            if(i < size - 1) {
                System.out.println("-----");
            }
        }

        System.out.println("-------------------------------------------");
    }

    public boolean areaCanSet(Piece piece) {//判斷此位置是否可以下
        return piece.getX() < size && piece.getX() >= 0 && piece.getY() < size && piece.getY() >= 0 && board[piece.getX()][piece.getY()] == ' ';
    }

    public boolean setPiece(Piece piece, char ch) {
        if(playerRound != ' ' && playerRound != ch) return false;//判斷玩家是否在回合內

        board[piece.getX()][piece.getY()] = ch;

        playerRound = Player.nextRound(ch);

        return true;
    }

    public boolean checkEnd() {
        if(isEnd) return true;

        int setNum = 0;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
               if(board[i][j] != ' ') {
                setNum++;
               }
            }
        }
        if(setNum >= size * size) {
            isEnd = true;
        }

        for(int i = 0; i < size; i++) {
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                isEnd = true;
                winner = board[i][0];
            }

            if(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                isEnd = true;
                winner = board[0][i];
            }
        }

        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') || (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')) {
            isEnd = true;
            winner = board[1][1];
        }

        return isEnd;
    }

    public void checkGameOver() {
        checkEnd();

        if(isEnd) {
            if(winner == ' ') {
                System.out.println("沒有贏家");
            }
            else {
                System.out.println("贏家為:" + winner);
            }
        }
        else {
            System.out.println("還沒結束");
        }
        System.out.println("-------------------------------------------");
    }
}

class Player {
    public static final char HUMAN_BK = 'A';
    public static final char COMPUTER = 'B';

    private char playerType;

    public Player(char playerType) {
        this.playerType = playerType;
    }

    public void setPieces(ChessBoard cb, Piece piece) {//下子
        if (cb.checkEnd()) {
            System.out.println("已結束");
        }
        else {
            System.out.println("player " + playerType + " 下在:" + piece);
            if(cb.areaCanSet(piece)) {
                boolean result = cb.setPiece(piece, playerType);
                if(result == false) {
                    System.out.println("現在不是" + playerType + "的回合");
                }
            }
            else {
                System.out.println(piece + "此位置有被下了或是超出格子範圍");
            }
        }

        cb.show();
    }

    public static char nextRound(char ch) {//回傳下一個下子的人
        if(ch == HUMAN_BK) return COMPUTER;
        else return HUMAN_BK;
    }
}

class TicTacToe  {
    private ChessBoard cb;
    Player playerA, playerB;

    public void start() {
        // ChessBoard 類別可能的使用方式
        cb = new ChessBoard();  // 建立一個棋盤

        // Player 類別可能的使用方式
        playerA = new Player(Player.HUMAN_BK); // 建立一個玩家 playerA 執黑棋
        playerB = new Player(Player.COMPUTER);  // 建立一個電腦玩家

        //下子
        playerA.setPieces(cb, new Piece(1,2));  
        playerB.setPieces(cb, new Piece(2,2));   
        playerA.setPieces(cb, new Piece(2,2)); 
        playerB.setPieces(cb, new Piece(-1,2));  
        playerB.setPieces(cb, new Piece(3,2));    
        playerB.setPieces(cb, new Piece(0,2));
        playerA.setPieces(cb, new Piece(1,1));
        playerB.setPieces(cb, new Piece(0,2));
        playerA.setPieces(cb, new Piece(1,0));
        playerB.setPieces(cb, new Piece(2,0));
    }

    public void checkGameOver () {
        System.out.print("判斷是否結束:");
        cb.checkGameOver();
    }
}

public class hw_40943257_3_7 {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
        game.checkGameOver();
    }
}