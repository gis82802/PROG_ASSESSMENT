/*
 * 資工二乙41143238陳峻宇
 * 檔案名稱:hw1
 * 功能: 設計井字棋遊戲(TicTacToe)中的類別，例如：ChessBoard, Player, Piece 等，思考每個類別應具備的成員函式，以及互動方式
 * 在選擇位置的格式為 0 0 到 2 2
 * B讓他以亂數產生位置來與玩家遊玩
 * 版本: 1.0
 * 日期: 03/11
 */
import java.util.Scanner;

class TicTacToc{
    private char[][] board;
    public TicTacToc(){
        board = new char[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            board[i][j]=' ';//預設空格
        }
    }
    public void start(){
        displayboard();
    }
    public boolean checkgameover(){//判斷是否結束
        return(checkwin('X')||checkwin('O')||full());
    }

    public boolean checkwin(char symbol)//判斷是否連線
    {
        for (int i=0;i<3;i++) {
            if (board[i][0]==symbol && board[i][1]==symbol && board[i][2]==symbol) 
                return true;
        }
        for (int j=0;j<3;j++) {
            if (board[0][j]==symbol && board[1][j]==symbol && board[2][j]==symbol)
                return true;
        }
        if ((board[0][0]==symbol && board[1][1]==symbol && board[2][2]==symbol)) 
            return true;
        if ((board[0][2]==symbol && board[1][1]==symbol && board[2][0]==symbol))
            return true;
        return false;
    }
    private boolean full(){
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]==' ')
                return false;
            }
            
        }
        return true;
    }
    public void displayboard(){//列出遊戲畫面
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(board[i][j]);
                if(j<2)
                    System.out.print(" | ");
            }
            System.out.println();
            if(i<2)
            System.out.println("----------");
        }
       
    }
    public boolean isvalidmove(int row,int col)//檢查原本位置是否為空且在範圍內
    {
        return (row>=0 && row<3 && col>=0 && col<3 && board[row][col]==' ');
    }
    
    public void placepiece(int row,int col,char symbol)
    {
        board[row][col]=symbol;
    }
}

class Player{
    private char symbol;
    public Player(char symbol){
        this.symbol=symbol;
    }
    public char getsymbol(){
        return symbol;
    }
}
public class hw1{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        TicTacToc game=new TicTacToc();
        game.start();
        char symbola,symbolb;

        do{
            System.out.print("請玩家A選擇要使用的符號 (O 或 X):");
            symbola=scn.next().charAt(0);
        }while( symbola!='O'&& symbola!='X');

        if(symbola=='O')
            symbolb='X';
        else
            symbolb='O';

        Player playerA=new Player(symbola);
        Player playerB=new Player(symbolb);

        int row,col;
        while(!game.checkgameover()){
            System.out.print("請玩家A輸入要下的位置 (row col):");
            row=scn.nextInt();
            col=scn.nextInt();

            while(!game.isvalidmove(row,col))
            {
                System.out.print("輸入錯誤，請重新輸入:");
                row=scn.nextInt();
                col=scn.nextInt();
            }
            game.placepiece(row,col,playerA.getsymbol());
            game.displayboard();

            if(game.checkgameover())
                break;

            int randomrow,randomcol;
            do{
                randomrow=(int)(Math.random()*3);//生成0~2的亂數(row,col)
                randomcol=(int)(Math.random()*3);
            }while(!game.isvalidmove(randomrow,randomcol));

            game.placepiece(randomrow, randomcol, playerB.getsymbol());
            System.out.println("電腦B下的位置 " + (randomrow ) + " " + (randomcol ) + " :");
            game.displayboard();
        }
        if(game.checkwin(playerA.getsymbol()))
            System.out.println("玩家A獲勝");
        else if(game.checkwin(playerB.getsymbol()))
            System.out.println("玩家B獲勝");
        else
            System.out.println("平手");
        scn.close();

    }
}
