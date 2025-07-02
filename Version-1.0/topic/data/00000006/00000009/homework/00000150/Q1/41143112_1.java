import java.util.*;
class ChessBoard{
    int player=1;//玩家順序
    int size; //棋盤大小
    int x,y;//x,y最大範圍
    char CB[][];
    
    ChessBoard(int x,int y){
        CB =new char[x][y];
        for(int i=0;i<x;i++){
            CB[i] =new char[y];
        }
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
               CB[i][j]='0';
            }
        }
        this.x=x;
        this.y=y;
        size=x*y;
    }
    void show(){
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                System.out.print(CB[i][j]+"|");
            }
            System.out.print("\n");
        }
        
    }
    int checkGameOver(int x,int y){
        int win =3;
        char ch;
        int left=0,right=0;
        int Lx=x,Ly=y,Rx=x,Ry=y;
        if(player == 1) ch='B';
        else ch='A';
        //-45度
        while(Lx-1>=0&&Ly-1>=0&&CB[--Lx][--Ly]==ch){
            left++;
        }
        while(Rx+1<this.x&&Ry+1<this.y&&CB[++Rx][++Ry]==ch){  
            right++;
        }
        
        if((right+left)>=(win-1)){
            if(ch=='A') return 1;
            else return 2;
        }  
        Lx=x;Ly=y;Rx=x;Ry=y;
        right=0;
        left=0;
        //垂直
        while(Ly-1>=0&&CB[Lx][--Ly]==ch){
        
            left++;
        }
        while(Ry+1<this.y&&CB[Rx][++Ry]==ch){
        
            right++;
        }
        if((right+left)>=(win-1)){
            if(ch=='A') return 1;
            else return 2;
        }
        Lx=x;Ly=y;Rx=x;Ry=y;
        right=0;
        left=0;
        //45度
        while(Lx-1>=0&&Ly+1<this.y&&CB[--Lx][++Ly]==ch){
            left++;
        }
        while(Rx+1<this.x&&Ry-1>=0&&CB[++Rx][--Ry]==ch){
            right++;
            
        }
        if((right+left)>=(win-1)){
            if(ch=='A') return 1;
            else return 2;
        }
        Lx=x;Ly=y;Rx=x;Ry=y;
        right=0;
        left=0;
        //水平
        while(Lx-1>=0&&CB[--Lx][Ly]==ch){
            left++;
        }
        while(Rx+1<this.x&&CB[++Rx][Ry]==ch){
            right++;
        }
        if((right+left)>=(win-1)){
            if(ch=='A') return 1;
            else return 2;
        }
        return 0;
    }
    int GetLocation(int x,int y){
        if (CB[x][y]!='0'){
            return 1;
        }
        return 0;
    }
    void InLocation(int tx,int ty){
        if(player==1){
            CB[tx][ty]='A';
            player=2;
        }
        else {
            CB[tx][ty]='B';
            player=1;
        }
    }
   
}

public class game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ChessBoard CB = new ChessBoard(3,3);//建立棋盤大小
        CB.show();//顯示棋盤
        for(int i=0;i<CB.size;i++){
            System.out.println("輸入座標");
            int x= input.nextInt();
            int y= input.nextInt();
            while ((x<CB.x&&y<CB.y)&&CB.GetLocation(x,y)==1) {//是否輸入成功
                System.out.println("輸入失敗，重新輸入座標");
                x= input.nextInt();
                y= input.nextInt();
            }
            CB.InLocation(x,y);//輸入位置  
            CB.show();//顯示棋盤
            if (CB.checkGameOver(x,y)==1){
                System.out.println("A獲勝");
                return;
            }
            if (CB.checkGameOver(x,y)==2){
                System.out.println("B獲勝");
                return;
            }
                
        }
        System.out.println("平手");
    }
        
}
    

