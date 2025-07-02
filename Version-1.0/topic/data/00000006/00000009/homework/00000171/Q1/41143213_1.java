
// 41143213 吳哲瑋
// 2024.3.7
// 五子棋（Gomoku）
import java.util.Scanner;

public class Gomoku {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard(15, 15);
        Player player1 = new Player("playerA", 'A');
        Player player2 = new Player("playerB", 'B');
        Game game = new Game(board, player1, player2);
        
        game.start();
        while (!game.isGameOver()) {
            player1.putPiece(board);
            if (!game.isGameOver())
                player2.putPiece(board);
        }
        if (!board.isNotFull())
            System.out.println("和局");
        else{
            System.out.println("--------------------------------");
            System.out.println(board);
            System.out.println(game.winner() + " 贏了!!");
        }
    }
}

class Game {
    ChessBoard board;
    Player player1;
    Player player2;

    Game(ChessBoard board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }
    void start() {

    }

    boolean isGameOver() {
        int len = 5;
        if (!board.isNotFull())
            return true;
        else if(board.playerMaxLine(player1) >= len)
            return true;
        else if(board.playerMaxLine(player2) >= len)
            return true;
        return false;
    }

    Player winner() {
        if(board.playerMaxLine(player1) > board.playerMaxLine(player2))
            return player1;
        else
            return player2;
    }
}

class ChessBoard {
    int width, height;
    Piece board[][];
    Boolean use[][];

    ChessBoard(int width, int height) {
        this.width = width;
        this.height = height;
        board = new Piece[width][height];
        use = new Boolean[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = new Piece(i, j, '□');
                use[i][j] = false;
            }
        }
    }

    public String toString() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
                System.out.print(board[j][i] + " ");
            System.out.println();
        }
        return "";
    }

    void addPiece(Piece piece) {
        use[piece.getX()][piece.getY()] = true;
        board[piece.getX()][piece.getY()] = piece;
    }

    boolean isBoardLocNULL(int x, int y) {
        return !use[x][y];
    }

    boolean isNotFull() {
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                if (use[i][j] == false)
                    return true;
        return false;
    }

    int playerMaxLine(Player player){
        int len = 0;
        int loc[][] = {{-1,0},{0,-1},{-1,-1},{1,-1}};
        
        for(int k = 0; k < 4; k++){
            int map[][] = new int[width][height];
            for(int i=0;i<width;i++){
                for(int j=0;j<height;j++){
                    if(board[i][j].cnt != player.token)
                        map[i][j] = 0;
                    else if(!isInRange(i+loc[k][0], width) || !isInRange(j+loc[k][1], height))
                        map[i][j] = 1;
                    else 
                        map[i][j] = map[i+loc[k][0]][j+loc[k][1]] + 1;
                    
                    if(map[i][j] > len) len = map[i][j];   
                }
            }
        }
        
        return len;
    }

    boolean isInRange(int x, int max) {
        return !(x < 0 || x >= max);
    }
}

class Piece {
    int x, y;
    char cnt;

    Piece(int x, int y, char cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    public String toString() {
        return this.cnt + "";
    }
}

class Player {
    char token;
    String Name;

    Player(String Name, char token) {
        this.Name = Name;
        this.token = token;
    }

    void putPiece(ChessBoard board) {
        Scanner srn = new Scanner(System.in);
        System.out.println(board);
        while(true){
            System.out.print(this.Name + " 請輸入座標（X, Y）：");
            int x = srn.nextInt()-1;
            int y = srn.nextInt()-1;
            if(!isInRange(x, board.width) || !isInRange(y, board.height)) continue;
            else if(!board.isBoardLocNULL(x, y)) continue;
            else board.addPiece(new Piece(x, y, token));
            break;
        }
    }
    boolean isInRange(int x, int max) {
        return !(x < 0 || x >= max);
    }
    public String toString() {
        return Name;
    }
}
