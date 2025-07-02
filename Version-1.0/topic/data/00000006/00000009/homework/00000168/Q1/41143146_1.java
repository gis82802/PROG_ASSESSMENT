//41143146
import java.util.Scanner;
import java.lang.Math;

class board{
    char theBoard[][];
    boolean gameOver;
    private int totalPieces;

    board(){
        theBoard = new char[3][3];
        gameOver=false;
        totalPieces = 0;
    }

    void display(){
        for(int i=0; i<theBoard.length; i++){
            for(int j=0; j<theBoard[i].length; j++){
                if(theBoard[i][j]=='\0'){
                    System.out.print('-');
                }else{
                    System.out.print(theBoard[i][j]);
                }
            }
            System.out.println();
        }
    }

    void checkGameOver(player p1, player p2){
        //starting from the center, determine winning line by comparing every piece that's nearby the center
        //then compare the sides
        char det = theBoard[1][1];
        if(det!='\0' && gameOver==false){
            for(int i=0; i<theBoard.length; i++){
                for(int j=0; j<theBoard[i].length; j++){
                    if(i==1&&j==1){
                        continue; //skip the center
                    }else if(theBoard[i][j]==det&&theBoard[2-i][2-j]==det){
                        gameOver=true;
                        if(det==p1.thePiece){
                            p1.winner = true;
                        }else{
                            p2.winner = true;
                        }
                        break;
                    }
                }
            }
        }
        if(gameOver==false){
            for(int k=0; k<theBoard.length; k++){
                if(k==1){ continue; }
                else{
                    det=theBoard[k][k];
                    if(det!='\0'){
                        if(theBoard[1][k]==det&&theBoard[2-k][k]==det){
                            gameOver=true;
                            if(det==p1.thePiece){
                                p1.winner = true;
                            }else{
                                p2.winner = true;
                            }
                            break;
                        }
                        if(theBoard[k][1]==det&&theBoard[k][2-k]==det){
                            gameOver=true;
                            if(det==p1.thePiece){
                                p1.winner = true;
                            }else{
                                p2.winner = true;
                            }
                            break;
                        }
                    }
                }
            }
        }
        totalPieces++;
        if(totalPieces>=9){
            gameOver=true;
            if(!p1.winner==true && !p2.winner==true){
                System.out.println("DRAW");
            }
        }
    }
}

class player{
    boolean winner;
    char thePiece;

    void place(board b, piece p){
        b.theBoard[p.xpos-1][p.ypos-1] = thePiece;
    }

    void setPiece(int index){
        if(index==1){
            thePiece='O';
        }else if(index==2){
            thePiece='X';
        }
    }
}

class piece{
    int xpos,ypos;

    piece(int ix, int iy){
        xpos=ix; ypos=iy;
    }
}

public class TicTackToe {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int plrPiece= 0;
        board ticTacToe = new board();
        player plr = new player(); //player
        player cpu = new player(); //computer player
        //pick O or X
        while(plrPiece!=1 || plrPiece!=2){
            System.out.print("Choose your piece O(1) or X(2): ");
            plrPiece = scan.nextInt();
            if(plrPiece==1 || plrPiece==2){
                break;
            }else{
                System.out.println("You're supposed to input 1 or 2");
            }
        }
        plr.setPiece(plrPiece);
        cpu.setPiece(3-plrPiece); //if the player chooses X(2), then cpu will choose O(1)
        //play the game until game is over
        System.out.println("To place a piece, input two numbers(x,y) between 1 to 3.");
        ticTacToe.display();
        while(ticTacToe.gameOver==false){
            int x=scan.nextInt(),y=scan.nextInt();
            int cx=x, cy=y; //initialize cpu's x and y position
            if(x>=1 && x<=3 && y>=1 && y<=3 && ticTacToe.theBoard[x-1][y-1] == '\0'){
                plr.place(ticTacToe, new piece(x,y)); //player's turn
                ticTacToe.checkGameOver(plr, cpu);
                //cpu (opponent)'s turn
                //if cpu chose the occupied places, reroll until it choose an empty space
                while(ticTacToe.theBoard[cx-1][cy-1]!='\0' && ticTacToe.gameOver==false){
                    cx = (int)(Math.random()*3)+1;
                    cy = (int)(Math.random()*3)+1;
                    if(ticTacToe.theBoard[cx-1][cy-1]=='\0'){
                        cpu.place(ticTacToe, new piece(cx,cy));
                        ticTacToe.checkGameOver(plr, cpu);
                        break;
                    }
                }
            }else if(ticTacToe.theBoard[x-1][y-1] != '\0'){
                System.out.println("You cannot place here!");
            }else{
                System.out.println("You're supposed to input both numbers between 1~3");
            }
            ticTacToe.display();
        }
        scan.close();
        //print game result
        if(plr.winner==true){
            System.out.println("You win!");
        }else if(cpu.winner==true){
            System.out.println("You lose!");
        }
    }
}
