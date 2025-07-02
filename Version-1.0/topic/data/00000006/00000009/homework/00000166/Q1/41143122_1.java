//package hw.hw2;
/*
    filename: OOXX.java
    function: 井字遊戲
      author: 林柏儒 資工二甲 41143122
    datetime: 2024/3/12
     version: 1.0
*/
import java.util.Scanner;

class Chessboard{                                   //棋類遊戲類別
    int[][] array=new int[3][3];
    int turn=0;
    public Chessboard(){
        System.out.println("GameStart");
        for(int i=0;i<3;i++){//陣列值默認為-1
            for(int j=0;j<3;j++){
                array[i][j]=-1;
            }
        }
    }
    public void cin(String xy){
        String[] inxy=xy.split(",");
        if(array[Integer.parseInt(inxy[0])-1][Integer.parseInt(inxy[1])-1]==-1){//若陣列為-1,輸出 O 或 X
            array[Integer.parseInt(inxy[0])-1][Integer.parseInt(inxy[1])-1]=turn%2;
        }
        else{
            System.out.println("**輸入有誤**");
            turn--;
        }
    }
    public void player(){
        turn++;
        System.out.print("第"+turn+"回合  ");
        if(turn%2==1){
            System.out.println(" O 方回合");
        }
        else if(turn%2==0){
            System.out.println(" X 方回合");
        }
    }
    public void OX(int num){//代碼轉O X
        System.out.print(num==1? " O ":num==0? " X ":"   ");
    }
}
class TicTacToe extends Chessboard{                 //井字遊戲類別
    public void cout(){//棋盤列印
        System.out.println("-------------");
        for(int[] out:array){
            System.out.print("|");
            for(int in:out){
                OX(in);
                System.out.print("|");
            }System.out.println("\n-------------");
        }
    }
    public int rule(){
        for(int i=0;i<array.length;i++){
            if(array[0][i]==array[1][i]&&array[1][i]==array[2][i]&&array[2][i]==turn%2){//橫成一線
                return 0;
            }
            else if(array[i][0]==array[i][1]&&array[i][1]==array[i][2]&&array[i][2]==turn%2){//縱成一線
                return 0;
            }
        }
        if(array[0][0]==array[1][1]&&array[1][1]==array[2][2]&&array[2][2]==turn%2){//左上至右下斜
            return 0;
        }
        else if(array[0][2]==array[1][1]&&array[2][1]==array[2][0]&&array[2][0]==turn%2){//右上至左下斜
            return 0;
        }
        else if(turn==9){//平手
            return -1;
        }
        else 
            return 1;
    }
    public void gameover(){
        if(rule()==0){
            OX(turn%2);
            System.out.print("方獲勝");
        }
        else if (rule()==-1){
            System.out.print("雙方平手");
        }
    }
}
public class OOXX{                                  //主程式
    public static void main(String[] args){
        TicTacToe t=new TicTacToe();
        Scanner scn = new Scanner(System.in);
        while(t.rule()==1){
            t.player();
            System.out.print("請輸入橫向位與縱向位(格式：3,3)：");
            String in= scn.nextLine();
            t.cin(in);  
            t.cout();
            t.gameover();
        }scn.close();
    }
}