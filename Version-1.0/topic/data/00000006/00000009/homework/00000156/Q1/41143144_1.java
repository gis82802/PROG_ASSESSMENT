/*
 SID:41143144 黃楷華
 Date:03/07
 Question:設計井字棋遊戲(TicTacToe)中的類別，例如：ChessBoard, Player, Piece 等，思考每個類別應具備的成員函式，以及互動方式.
 Example:
 Please select mode.
 1. Player vs Computer.
 2. Player vs Player.
 (輸入1 or 2)
 1
 P1 first.
 Chessboard state.



 P1, Please enter the position:
 5
 Chessboard state.

  O

 P2, Please enter the position:
 P2's position:2
 Chessboard state.
  X
  O
 
 .....以此類推
 */
import java.util.Random;
import java.util.Scanner;
class TicTacToe extends ChessBoard {
    Scanner sc = new Scanner(System.in);
    int gamestate;
    int winner;
    int firstseq;
    int count = 0;
    int seq;
    int flag = 0;
    public TicTacToe(){
        gamestate = 0;
        winner = 0;
    }
    int cprandompos(){
        int pos = (int)(Math.random() * 9) + 1;
        return pos;
    }
    void start(Player P1, Player P2){
        if(P1.sequence == 1){
            firstseq = 1;
            seq = 2;
            System.out.printf("P1, ");
        } else if(P2.sequence == 1){
            firstseq = 2;
            seq = 1;
            System.out.printf("P2, ");
        }
        gamecontinue(P2);
    }
    void gamecontinue(Player P2){
        int pos = 0;
        System.out.println("Please enter the position:");
        while(count < 9){
            if (P2.character == 1 && seq == 1){
                if(firstseq == 2 && flag == 0){
                    pos = cprandompos();
                    System.out.println("P2's position:"+pos);
                } else {
                    pos = cprandompos();
                    while(bdstate[pos-1] > 0){
                        if(bdstate[pos-1] == 0){
                            break;
                        } else {
                            pos = cprandompos();
                        }
                    }
                    System.out.println("P2's position:"+pos);
                }
            }
            
            else {
                pos = sc.nextInt();
            }

            if (bdstate[pos-1] != 0 ){
                System.out.println("This position has already been used.\nPlease enter another position");
                while(bdstate[pos-1] > 0){
                    pos = sc.nextInt();
                    if(bdstate[pos-1] == 0){
                        break;
                    } else {
                        System.out.println("This position has already been used.\nPlease enter another position:");
                        continue;
                    }
                }
            }
            if(firstseq == 2 && flag == 0){
                board[(pos-1)/3][(pos-1)%3] = "X";
                bdstate[pos-1] = 1;
                seq = 2;
                count++;
                flag++;
            } else {
                if(seq == 1 && bdstate[pos-1] == 0){
                    board[(pos-1)/3][(pos-1)%3] = "X";
                    bdstate[pos-1] = 1;
                    seq = 2;
                    count++;
                } else if (seq == 2 && bdstate[pos-1] == 0){
                    board[(pos-1)/3][(pos-1)%3] = "O";
                    bdstate[pos-1] = 2;
                    seq = 1;
                    count++;
                }
            }
            show();
            if (checkGameOver() > 0){
                checkwinner(seq);
                break;
            } else {
                if(seq == 2){
                    System.out.printf("P1, ");
                } else if(seq == 1){
                    System.out.printf("P2, ");
                }
                System.out.println("Please enter the position:");
                continue;
            }
        }
    }
    int checkGameOver(){
        if(bdstate[0] == bdstate[1] && bdstate[1] == bdstate[2] && bdstate[0] > 0){
            gamestate = bdstate[0];
        }
        else if(bdstate[3] == bdstate[4] && bdstate[4] == bdstate[5] && bdstate[3] > 0){
            gamestate = bdstate[3];
        }
        else if(bdstate[6] == bdstate[7] && bdstate[7] == bdstate[8] && bdstate[6] > 0){
            gamestate = bdstate[6];
        }
        else if(bdstate[0] == bdstate[3] && bdstate[3] == bdstate[6] && bdstate[0] > 0){
            gamestate = bdstate[0];
        }
        else if(bdstate[1] == bdstate[4] && bdstate[4] == bdstate[7] && bdstate[1] > 0){
            gamestate = bdstate[1];
        }
        else if(bdstate[2] == bdstate[5] && bdstate[5] == bdstate[8] && bdstate[2] > 0){
            gamestate = bdstate[2];
        }
        else if(bdstate[0] == bdstate[4] && bdstate[4] == bdstate[8] && bdstate[0] > 0){
            gamestate = bdstate[0];
        }
        else if(bdstate[2] == bdstate[4] && bdstate[4] == bdstate[6] && bdstate[2] > 0){
            gamestate = bdstate[2];
        }
        else if(count == 9){
            gamestate = 9;
        } else {
            gamestate = 0;
        }
        return gamestate;
    }
    void checkwinner(int seq){
        if(checkGameOver() == 9){
            System.out.println("Draw.");
        } 
        else if(checkGameOver() > 0 && firstseq == 2){
                System.out.println("P2 Win.");
        }
        else if(checkGameOver() > 0 && firstseq == 1){
                System.out.println("P1 Win.");
        }
    }
}

class ChessBoard{
    String board[][] = new String[3][3];
    int bdstate [] = new int[9];
    public ChessBoard(){
        for(int i = 0; i < 9; i++){
            bdstate[i] = 0;
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = " ";
            }
        }
    }
    void show(){
        System.out.println("Chessboard state.");
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.printf("%s",board[i][j]);
            }
            System.out.println();
        }
    }
}
class Player{
    int character;
    int sequence;
    Player(){

    }
    Player(int ch, int seq){
        character = ch;
        sequence = seq;
    }
}
public class java0307 {
    public static void main(String[] args){
        ChessBoard cb = new ChessBoard();
        TicTacToe game = new TicTacToe();
        Player Player1, Player2;
        int Computer = 1;
        int Human = 2;

        System.out.printf("Please select mode.\n");
        System.out.printf("1. Player vs Computer.\n");
        System.out.printf("2. Player vs Player.\n");
        Scanner sc = new Scanner(System.in);
        int mode = sc.nextInt();
        int seq = (int)(Math.random() * 50) + 1;
        int seq2 = (int)(Math.random() * 50) + 1;
        if(seq > seq2){
            seq = 1;
            seq2 = 2;
            System.out.println("P1 first.");
        } else {
            seq = 2;
            seq2 = 1;
            System.out.println("P2 first.");
        }
        while(true){
            if(mode == 1){
                Player1 = new Player(Human, seq);
                Player2 = new Player(Computer, seq2);
                break;
            } else if (mode == 2){
                Player1 = new Player(Human, seq);
                Player2 = new Player(Human, seq2);
                break;
            } else {
                System.out.println("Have not this selection. Please select again.");
                mode = sc.nextInt();
            }
        }
        cb.show();
        game.start(Player1, Player2);
    }
}
