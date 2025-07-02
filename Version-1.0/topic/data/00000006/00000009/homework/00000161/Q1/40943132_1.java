import java.util.Scanner;
public class TicTacToeMain{
    static class TicTacToe{
        public int checkGameOver(ChessBoard cb){
            int wincamp=2;
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(cb.map[i][j]==-1)
                    {
                        wincamp=-1;
                    }
                }
            }
            for(int i=0;i<3;i++)
            {
                if(cb.map[i][0]==cb.map[i][1] && cb.map[i][1]==cb.map[i][2] && cb.map[i][0]!=-1)//|
                {
                    wincamp=cb.map[i][0];
                }
                if(cb.map[0][i]==cb.map[1][i] && cb.map[1][i]==cb.map[2][i] && cb.map[0][i]!=-1)//-
                {
                    wincamp=cb.map[0][i];
                }
            }
            if(cb.map[0][0]==cb.map[1][1] && cb.map[1][1]==cb.map[2][2] && cb.map[1][1]!=-1)//\
                {
                    wincamp=cb.map[1][1];
                }
            if(cb.map[2][0]==cb.map[1][1] && cb.map[1][1]==cb.map[0][2] && cb.map[1][1]!=-1)///
                {
                    wincamp=cb.map[1][1];
                }    
            if(wincamp == 2)
            {
                System.out.println("No wins");
            }
            if(wincamp == 1)
            {
                System.out.println("Black wins");
            }
            if(wincamp == 0)
            {
                System.out.println("White wins");
            }
            return wincamp;
        }
    }
    static class Player{
        int camp;
        Player(int HUMAN_camp){
            camp = HUMAN_camp;
        }

    }
    static class ChessBoard{
        int[][] map;
        int w,h;
        ChessBoard(){
            w=3;
            h=3;
            map = new int[w+1][h+1];
             for(int i=0;i<w;i++)
            {
                for(int j=0;j<h;j++)
                {
                    map[i][j] = -1;
                }
            }
        }
        public void show(){
            String allPts="";
            for(int i=0;i<w;i++)
            {
                for(int j=0;j<h;j++)
                {
                    allPts+=map[i][j]+" ";
                    if(map[i][j]!=-1)
                        allPts+=" ";
                }
                allPts+="\n";
            }
            System.out.println(allPts);
        }
        public boolean setflag(Player player,int x,int y){
            if(map[x][y]==-1)
            {
                map[x][y]=player.camp;
                return true;
            }
            else
                return false;
        }
    }
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Player playerA = new Player(1); 
        Player playerB = new Player(0);  
        ChessBoard  cb = new ChessBoard();  
        cb.show(); 
        Scanner s=new Scanner(System.in);
        int x,y;
        while(true)
        {
            System.out.println("Please enter the position under Black");
            y =s.nextInt();
            x =s.nextInt();
            while(!cb.setflag(playerA,x,y))
            {
                System.out.println("Please re-enter the position under Black");
                y =s.nextInt();
                x =s.nextInt();
            }
            System.out.println("-------------------------------------");
            cb.show(); 
            if(game.checkGameOver(cb)!=-1)
                break;
            System.out.println("Please enter the position under White");
            y =s.nextInt();
            x =s.nextInt();
            while(!cb.setflag(playerB,x,y))
            {
                System.out.println("Please re-enter the position under White");
                y =s.nextInt();
                x =s.nextInt();
            }
            System.out.println("-------------------------------------");
            cb.show();
            if(game.checkGameOver(cb)!=-1)
                break;
        }
        s.close(); 

    }
}