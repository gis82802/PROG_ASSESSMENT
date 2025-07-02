/*
 * filename:Tic_Tac_Toe
 * function:井字棋
 * date:3/8
 * author:黃子峻
 * version:1.1
 */
import java.util.Scanner;

class ChessBroad{
    Scanner sc=new Scanner(System.in);
    int[][] chessbroad=new int [3][3];//棋盤
    boolean gameover=false;
    
    class Player{//玩家
        int n=0;
        void set(int number){//1.玩家1 2.玩家2
            n=number;
        }
        void Input(){//輸入
            int x=0,y=0;
            System.out.printf("輸入位置:\n");
            x=sc.nextInt();y=sc.nextInt();
            if(chessbroad[x][y]>0){
                System.out.printf("位置重複，請再輸入一次!!\n");
                Input();
            }
            chessbroad[x][y]=n;
        }
        void Pshow(){
            System.out.printf("n=%d\n",n);
        }  
        
    }
    void show(){
        System.out.printf("ChessBroad.show()\n");
        System.out.printf("-------------\n");
        for(int i=0;i<3;i++){
            System.out.printf("| ");
            for(int j=0;j<3;j++){
                if(chessbroad[i][j]==0)
                    System.out.printf("   | ");
                if(chessbroad[i][j]==1)
                    System.out.printf("白 | ");
                if(chessbroad[i][j]==2)
                    System.out.printf("黑 | ");
            }
            
            System.out.printf("\n");
        }
        
        System.out.printf("-------------\n");
    }
    void judge(){
        String win="0";
        if(chessbroad[0][0]==1&&chessbroad[0][1]==1&&chessbroad[0][2]==1)win="A";
        if(chessbroad[1][0]==1&&chessbroad[1][1]==1&&chessbroad[1][2]==1)win="A";
        if(chessbroad[2][0]==1&&chessbroad[2][1]==1&&chessbroad[2][2]==1)win="A";
        if(chessbroad[0][0]==1&&chessbroad[1][0]==1&&chessbroad[2][0]==1)win="A";
        if(chessbroad[0][1]==1&&chessbroad[1][1]==1&&chessbroad[2][1]==1)win="A";
        if(chessbroad[0][2]==1&&chessbroad[1][2]==1&&chessbroad[2][2]==1)win="A";
        if(chessbroad[0][0]==1&&chessbroad[1][1]==1&&chessbroad[2][2]==1)win="A";
        if(chessbroad[0][2]==1&&chessbroad[1][1]==1&&chessbroad[2][0]==1)win="A";

        if(chessbroad[0][0]==2&&chessbroad[0][1]==2&&chessbroad[0][2]==2)win="B";
        if(chessbroad[1][0]==2&&chessbroad[1][1]==2&&chessbroad[1][2]==2)win="B";
        if(chessbroad[2][0]==2&&chessbroad[2][1]==2&&chessbroad[2][2]==2)win="B";
        if(chessbroad[0][0]==2&&chessbroad[1][0]==2&&chessbroad[2][0]==2)win="B";
        if(chessbroad[0][1]==2&&chessbroad[1][1]==2&&chessbroad[2][1]==2)win="B";
        if(chessbroad[0][2]==2&&chessbroad[1][2]==2&&chessbroad[2][2]==2)win="B";
        if(chessbroad[0][0]==2&&chessbroad[1][1]==2&&chessbroad[2][2]==2)win="B";
        if(chessbroad[0][2]==2&&chessbroad[1][1]==2&&chessbroad[2][0]==2)win="B";

        if(win=="A"||win=="B"){
            System.out.printf("%s獲勝，",win);
            gameover=true;
        }
    }
    void GameStar(){
        gameover=false;
        ChessBroad.Player playerA=new Player();
        ChessBroad.Player playerB=new Player();
        playerA.set(1);
        playerB.set(2);
        while(true){
            show();
            System.out.printf("PlayerA的回合:\n");
            playerA.Input();
            judge();
            if(gameover==true){
                System.out.printf("遊戲結束\n");
                break;
            }
            show();
            System.out.printf("PlayerB的回合:\n");
            playerB.Input();
            judge();
            if(gameover==true){
                System.out.printf("遊戲結束\n");
                break;
            }
        }
        

        
    }
    
}

public class Tic_Tac_Toe{
    public static void main(String[] args){
        ChessBroad broad=new ChessBroad();
        broad.GameStar();

        
    }
}