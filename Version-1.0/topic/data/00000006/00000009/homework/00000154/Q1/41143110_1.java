class gameing{
    public void start(){
        System.out.println("game starting!");
    }
    public boolean checkgameover(tictactoe_chessboard a){
        for (int i = 0; i < 3; i++) {
            if (a.tictactoe_map[i][0] == a.tictactoe_map[i][1] && 
                a.tictactoe_map[i][1] == a.tictactoe_map[i][2] && 
                a.tictactoe_map[i][0] != '\u0000') {
                System.out.println("player "+a.tictactoe_map[i][0]+" win");
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (a.tictactoe_map[0][i] == a.tictactoe_map[1][i] && 
                a.tictactoe_map[1][i] == a.tictactoe_map[2][i] && 
                a.tictactoe_map[0][i] != '\u0000') {
                System.out.println("player "+a.tictactoe_map[0][i]+" win");
                return true;
            }
        }

        // Check diagonals
        if (a.tictactoe_map[0][0] == a.tictactoe_map[1][1] && 
            a.tictactoe_map[1][1] == a.tictactoe_map[2][2] && 
            a.tictactoe_map[0][0] != '\u0000') {
                System.out.println("player "+a.tictactoe_map[0][0]+" win");
            return true;
        }
        if (a.tictactoe_map[0][2] == a.tictactoe_map[1][1] && 
            a.tictactoe_map[1][1] == a.tictactoe_map[2][0] && 
            a.tictactoe_map[0][2] != '\u0000') {
                System.out.println("player "+a.tictactoe_map[0][2]+" win");
            return true;
        }
        
        return false;
    }
}


class tictactoe_chessboard{
    char [][] tictactoe_map;
    tictactoe_chessboard(){
        tictactoe_map=new char [3][3];
    }
    public void show(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(tictactoe_map[i][j]+"|");
            }
            System.out.println();
        }
    }
}

class player{
    public void setpieces(tictactoe_chessboard a,int set_x,int set_y,char statment){
        a.tictactoe_map[set_x][set_y]=statment;
    }
}

public class game1{
    public static void main(String [] args){
        gameing newgame=new gameing();
        tictactoe_chessboard cb=new tictactoe_chessboard();
        newgame.start();
        player playerx = new player();
        player playero = new player();

        while(!newgame.checkgameover(cb)){
            playerx.setpieces(cb,1,2,'x');
            playero.setpieces(cb,2,2,'o');
            playerx.setpieces(cb,1,1,'x');
            playerx.setpieces(cb,1,0,'x');
            playerx.setpieces(cb,0,2,'o');
            playerx.setpieces(cb,0,0,'x');
            playero.setpieces(cb,0,1,'o');
            playero.setpieces(cb,2,0,'o');
            playero.setpieces(cb,2,1,'x');
        }
        cb.show();    
    }
}