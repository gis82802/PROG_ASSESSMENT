/*
    資工二甲 41143145 楊柏文
    0307 上課練習
    井字遊戲
    玩家1為圈 玩家2為叉 每回合需要輸入座標下棋
    ex : Player1's time
        input : 0 0
        output : |O  |   |
                 -----------
                 |   |   |
                 -----------
                 |   |   |
    (0,0)位置處會打圈 接著換玩家2輸入
    直到有人連成一線或是全部都填滿了遊戲才會結束
    
    date: 03/10

 */
import java.util.Scanner ;
class ChessBoard
{   
    Piece [][] size ;
    ChessBoard(){
        size = new Piece[3][3] ;                         //預設為井字遊戲
    }
    ChessBoard(int length , int width){
        size = new Piece [length][width] ;               //可以更動棋盤的長跟寬 以加入其他遊戲
    }
    public void show() {
        for(int i = 0 ; i < size.length ; i++)
        {
            System.out.printf("|");
            for(int j = 0 ; j < size[0].length ; j++)
            {
                System.out.printf("%s  ",size[i][j].shape);
                if(j != size[0].length-1 )System.out.printf("|");
            }
            System.out.println() ;
            if(i != size.length -1 )System.out.println("-----------");
        }
        System.out.println();
    }
}
class Player
{
    int mode ;
    String shape ;
    Player(int mode) {
        this.mode = mode ;
        if(mode == 1 ) shape = "O";
        if(mode == 2 ) shape = "X";
    }
    public void setPiece (ChessBoard board , int x , int y)
    {
        if(check(board , x , y))board.size[x][y] = new Piece(shape) ;
    }
    boolean check (ChessBoard board , int x , int y){

        if(x > 2 || y > 2 || x < 0 || y < 0){
            System.out.println("The x or y out of range!!");
            return false ;
        }
        else if (board.size[x][y].shape != " ")
        {
            System.out.println("This place has already use !");
            return false ;

        }
        return true ;
    }
}
class Piece{
    String shape ;
    Piece(){
        shape = " " ;
    }
    Piece(String shape)
    {
        this.shape = shape ;
    }
    
}
class Game{
    ChessBoard newGame ; 
    Game(){
         newGame = new ChessBoard();
    }
    public void start(){  
        System.out.println("The TicTacToeGame Start!") ;
        for(int i = 0 ; i < newGame.size.length; i++)               //對棋盤初始化
        {
            for(int j = 0 ; j < newGame.size[0].length ; j++)
            {
         
                newGame.size[i][j] = new Piece() ;
            }
        }
        newGame.show();
    }
    boolean checkWin(String shape){
        for(int i = 0 ; i < newGame.size.length ; i++){
            if(newGame.size[i][0].shape == shape && newGame.size[i][1].shape == shape && newGame.size[i][2].shape == shape)
                return true ;
        }
        for(int i = 0 ; i < newGame.size.length ; i++){
            if(newGame.size[0][i].shape == shape && newGame.size[1][i].shape == shape && newGame.size[2][i].shape == shape)
                return true ;
        }
        if(newGame.size[0][0].shape == shape && newGame.size[1][1].shape == shape && newGame.size[2][2].shape == shape) return true ;
        if(newGame.size[0][2].shape == shape && newGame.size[1][1].shape == shape && newGame.size[2][0].shape == shape) return true ;
        return false ;
    }
    public void checkGameOver(){
        boolean allFull = true ;
        for(int i = 0 ; i < newGame.size.length ; i++)
        {
            for(int j = 0 ; j < newGame.size[0].length ; j++)
            {
                if(newGame.size[i][j].shape == " ")
                {
                    allFull = false ;
                    break ;
                }
            }
        }

        if(checkWin("O")){
            System.out.println("The game is over . Cross Win!") ;
            System.exit(0);
        }
        else if(checkWin("X")){
            System.out.println("The game is over . Nought Win!");
            System.exit(0);
        }
        else if(!checkWin("O") && !checkWin("X") && allFull){
            System.out.println("The game is over . Tie! No one win the game") ;
            System.exit(0);
        }
        else{
            System.out.println("The game is not over . Please continue!");
        }
    }
}
public class TicTacToeDesign_Full {
    public static void main(String[] args)
    {
        final int HUMAN_CRO = 1 ;
        final int HUMAN_NOU = 2 ; 
        Game TTTGame = new Game() ;
        TTTGame.start();
        Player playerA = new Player(HUMAN_CRO);  // 建立一個玩家 playerA 當圈 
        Player playerB = new Player(HUMAN_NOU);  // 建立一個玩家 playerB 當叉
        System.out.println("Player1 is Cross(O) , Player2 is Nought(X)");
        while (true)
        {
            int x = 0, y = 0 ;
            System.out.println("Player1's time");
            Scanner scn = new Scanner(System.in) ;
            x = scn.nextInt() ;
            y = scn.nextInt() ;
            playerA.setPiece(TTTGame.newGame, x , y);
            TTTGame.newGame.show();
            TTTGame.checkGameOver();
            System.out.println("Player2's time");
            x = scn.nextInt() ;
            y = scn.nextInt() ;
            playerB.setPiece(TTTGame.newGame, x , y );
            TTTGame.newGame.show();
            TTTGame.checkGameOver();
        }
        

    }
}
