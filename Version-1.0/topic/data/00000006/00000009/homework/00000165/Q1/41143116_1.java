import java.nio.channels.Pipe;
import java.util.Scanner;

class game_player
{
    int score=0;
    String name;
    Scanner scn=new Scanner(System.in);
    piece chessPIECE;
    game_player()
    {
        System.out.println("請輸入玩家名稱:");
        name=scn.next();
        chessPIECE=new piece();
    }
}
class chessman
{
    chessboard game;
    int chose;
    Scanner scn;
    chessman()
    {
        chose=0;
        scn =new Scanner(System.in);
    }
    int start()
    {
        //跳出選擇遊戲
        System.out.println("1:井字遊戲 2:五子棋 3:巫師棋 4:跳棋");
        chose=scn.nextInt();
        if(chose==1)
        {
            game=new chessboard();
            return chose;  
        }
        else if(chose>=2 && chose<=4){
            game=new chessboard(chose);
            return chose;
        }
        return chose;
    }
    int gameover()//遊戲結束
    {
        return 1;
    }
}
class chessboard
{
    piece [][]PIECE_AREA;
    chessboard() //for 3*3
    {
        PIECE_AREA=new piece[3][3];
        for(int i=0;i<3;i++)//初始化
            for(int j=0;j<3;j++)
                PIECE_AREA[i][j]=new piece();
    }
    chessboard(int a)//for any chessboard
    {

    }
    boolean game_winner(int area_x,int area_y)//勝敗條件點
    {
        for(int i=0;i<11;i++)
            System.out.println();
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(PIECE_AREA[i][j].chessmanPiece!=' ')
                    System.out.print(PIECE_AREA[i][j].chessmanPiece);
                else
                    System.out.print(" ");
                
            }
            System.out.println();
        }
        //判斷是否獲勝
        if((area_x-1)==0)
        {
            if((area_y-1)==0)
            {
                if(this.PIECE_AREA[area_x-1][area_y-1].chessmanPiece==this.PIECE_AREA[area_x][area_y-1].chessmanPiece)//行
                {
                    if(this.PIECE_AREA[area_x-1][area_y-1].chessmanPiece==this.PIECE_AREA[area_x+1][area_y-1].chessmanPiece)
                        return true;
                }
                else if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x-1][area_y].chessmanPiece)//列
                {
                    if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x-1][area_y+1].chessmanPiece)
                        return true;
                }
                else if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x][area_y].chessmanPiece)//斜
                {
                    if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x+1][area_y+1].chessmanPiece)
                    return true;
                }
                else
                    return false;
            }
            if((area_y-1)==1)
            {
                if(this.PIECE_AREA[area_x-1][area_y-1].chessmanPiece==this.PIECE_AREA[area_x-1][area_y-2].chessmanPiece)//列
                {
                    if(this.PIECE_AREA[area_x-1][area_y-1].chessmanPiece==this.PIECE_AREA[area_x-1][area_y].chessmanPiece)
                        return true;
                }
                else if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x][area_y-1].chessmanPiece)
                {
                    if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x+1][area_y-1].chessmanPiece)
                        return true;
                }
                else
                    return false;
            }
            if((area_y-1)==2)
            {
                if(this.PIECE_AREA[area_x-1][area_y-1].chessmanPiece==this.PIECE_AREA[area_x-1][area_y-2].chessmanPiece)//列
                {
                    if(this.PIECE_AREA[area_x-1][area_y-1].chessmanPiece==this.PIECE_AREA[area_x-1][area_y-3].chessmanPiece)
                        return true;
                }
                else if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x][area_y-1].chessmanPiece)//行
                {
                    if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x+1][area_y-1].chessmanPiece)
                        return true;
                }
                else if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x][area_y-2].chessmanPiece)//斜
                {
                    if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x+1][area_y-3].chessmanPiece)
                    return true;
                }
                else
                    return false;
            }
        }
        else if((area_x-1)==1)
        {
            if((area_y-1)==0)
            {
                if(this.PIECE_AREA[area_x-1][area_y-1].chessmanPiece==this.PIECE_AREA[area_x][area_y-1].chessmanPiece)//行
                {
                    if(this.PIECE_AREA[area_x-1][area_y-1].chessmanPiece==this.PIECE_AREA[area_x-1][area_y-1].chessmanPiece)
                        return true;
                }
                else if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x-1][area_y].chessmanPiece)//列
                {
                    if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x-1][area_y+1].chessmanPiece)
                        return true;
                }
                else
                    return false;
            }
            if((area_y-1)==1)
            {
                if(this.PIECE_AREA[area_x-1][area_y-1].chessmanPiece==this.PIECE_AREA[area_x-1][area_y-2].chessmanPiece)//列
                {
                    if(this.PIECE_AREA[area_x-1][area_y-1].chessmanPiece==this.PIECE_AREA[area_x-1][area_y].chessmanPiece)
                        return true;
                }
                else if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x][area_y-1].chessmanPiece)
                {
                    if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x-2][area_y-1].chessmanPiece)
                        return true;
                }
                else if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x-2][area_y-2].chessmanPiece)
                {
                    if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x][area_y].chessmanPiece)
                        return true;
                }
                else if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x-2][area_y].chessmanPiece)
                {
                    if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x][area_y-2].chessmanPiece)
                        return true;
                }
                else
                    return false;
            }
            if((area_y-1)==2)
            {
                if(this.PIECE_AREA[area_x-1][area_y-1].chessmanPiece==this.PIECE_AREA[area_x-2][area_y-1].chessmanPiece)//列
                {
                    if(this.PIECE_AREA[area_x-1][area_y-1].chessmanPiece==this.PIECE_AREA[area_x][area_y-1].chessmanPiece)
                        return true;
                }
                else if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x-1][area_y-2].chessmanPiece)//行
                {
                    if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x-1][area_y-3].chessmanPiece)
                        return true;
                }
                else
                    return false;
            }
        }
        else if((area_x-1)==2)
        {
            if((area_y-1)==0)
            {
                if(this.PIECE_AREA[area_x-1][area_y-1].chessmanPiece==this.PIECE_AREA[area_x-1][area_y].chessmanPiece)//列
                {
                    if(this.PIECE_AREA[area_x-1][area_y-1].chessmanPiece==this.PIECE_AREA[area_x-1][area_y+1].chessmanPiece)
                        return true;
                }
                else if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x-2][area_y-1].chessmanPiece)//行
                {
                    if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x-3][area_y-1].chessmanPiece)
                        return true;
                }
                else if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x-2][area_y].chessmanPiece)//斜
                {
                    if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x-3][area_y+1].chessmanPiece)
                    return true;
                }
                else
                    return false;
            }
            if((area_y-1)==1)
            {
                if(this.PIECE_AREA[area_x-1][area_y-1].chessmanPiece==this.PIECE_AREA[area_x-1][area_y-2].chessmanPiece)//列
                {
                    if(this.PIECE_AREA[area_x-1][area_y-1].chessmanPiece==this.PIECE_AREA[area_x-1][area_y].chessmanPiece)
                        return true;
                }
                else if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x-2][area_y-1].chessmanPiece)
                {
                    if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x-3][area_y-1].chessmanPiece)
                        return true;
                }
                else
                    return false;
            }
            if((area_y-1)==2)
            {
                if(this.PIECE_AREA[area_x-1][area_y-1].chessmanPiece==this.PIECE_AREA[area_x-1][area_y-2].chessmanPiece)//列
                {
                    if(this.PIECE_AREA[area_x-1][area_y-1].chessmanPiece==this.PIECE_AREA[area_x-1][area_y-3].chessmanPiece)
                        return true;
                }
                else if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x-2][area_y-1].chessmanPiece)//行
                {
                    if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x-3][area_y-1].chessmanPiece)
                        return true;
                }
                else if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x-2][area_y-2].chessmanPiece)//斜
                {
                    if(PIECE_AREA[area_x-1][area_y-1].chessmanPiece==PIECE_AREA[area_x-3][area_y-3].chessmanPiece)
                    return true;
                }
                else
                    return false;
            }
        }
        return false;
    }
}
class piece
{
    char chessmanPiece;
    piece()
    {
        chessmanPiece=' ';
        //System.out.println("你建立了一個棋子");
    }
    piece(int value)
    {

    }
}

public class chesssman {
    public static void main(String[] args)
    {
        int game_player_set=0;
        Scanner scn=new Scanner(System.in);
        int player=1;//預設單機
        System.out.println("請選擇 1:單機 or 2:連機");
        player=scn.nextInt();
        if(player==2)
        {
            //網路連接程式區塊
        }

        game_player player_one;
        System.out.println("player1:");//player1初始值
        player_one=new game_player();
        game_player player_two;
        System.out.println("player2:");//player2初始值
        player_two=new game_player();

        while(true)
        {
            chessman gameing;
            gameing=new chessman();
            game_player_set=gameing.start();
            System.out.println("請選擇你想要的棋子 井字遊戲=> 0:o 1:x / 五子棋=> 0:黑棋 1:白棋 / 巫師棋=> 0:哈利波特 1:佛地魔 / 跳棋=> 0:黑棋 1:白旗 2:綠棋 3:紅棋 4:藍棋 5:黃棋");
            switch (game_player_set) {
                case 1:
                    player_one.chessPIECE.chessmanPiece='o';

                    player_two.chessPIECE.chessmanPiece='x';

                    int game_start_number= (int)Math.random()*2+1;
                    int game_piece_total=0;
                    boolean winner=false;

                    while(true)//下棋 亂數開始
                    {
                        int area_x,area_y;
                        area_x=area_y=0;
                        if(game_start_number%2==0) //player1先
                        {
                            System.out.println("目前是player1,請輸入座標 x,y範圍1~3");
                            area_x=scn.nextInt();
                            area_y=scn.nextInt();
                            while(gameing.game.PIECE_AREA[area_x-1][area_y-1].chessmanPiece!=' ')
                            {
                                System.out.println("請重新輸入座標,這已經有被記號過了");
                                area_x=scn.nextInt();
                                area_y=scn.nextInt();
                            }
                            gameing.game.PIECE_AREA[area_x-1][area_y-1]=player_one.chessPIECE;
                            game_start_number++;
                            game_piece_total++;

                            winner=gameing.game.game_winner(area_x,area_y);
                            if(winner==true)
                            {
                                System.out.println(player_one.name+"獲勝");
                                player_one.score+=10;
                                break;
                            }
                        }
                        else
                        {
                            System.out.println("目前是player2,請輸入座標 x,y範圍1~3");
                            area_x=scn.nextInt();
                            area_y=scn.nextInt();
                            while(gameing.game.PIECE_AREA[area_x-1][area_y-1].chessmanPiece!=' ')
                            {
                                System.out.println("請重新輸入座標,這已經有被記號過了");
                                area_x=scn.nextInt();
                                area_y=scn.nextInt();
                            }
                            gameing.game.PIECE_AREA[area_x-1][area_y-1]=player_two.chessPIECE;
                            game_start_number++;
                            game_piece_total++;

                            winner=gameing.game.game_winner(area_x,area_y);
                            if(winner==true)
                            {
                                System.out.println(player_two.name+"獲勝");
                            player_two.score+=10;
                                break;
                            }
                        }
                        //檢查勝敗
                        if(game_piece_total==9)
                        {
                            System.out.println("雙方平手 各加5分");
                            player_one.score+=5;
                            player_two.score+=5;
                            break;
                        }

                        if(game_start_number%2==1) //player2先
                        {
                            System.out.println("目前是player2,請輸入座標 x,y範圍1~3");
                            area_x=scn.nextInt();
                            area_y=scn.nextInt();
                            while(gameing.game.PIECE_AREA[area_x-1][area_y-1].chessmanPiece!=' ')
                            {
                                System.out.println("請重新輸入座標,這已經有被記號過了");
                                area_x=scn.nextInt();
                                area_y=scn.nextInt();
                            }
                            gameing.game.PIECE_AREA[area_x-1][area_y-1]=player_two.chessPIECE;
                            game_start_number++;
                            game_piece_total++;

                            winner=gameing.game.game_winner(area_x,area_y);
                            if(winner==true)
                            {
                                System.out.println(player_two.name+"獲勝");
                                player_two.score+=10;
                                break;
                            }
                        }
                        else
                        {
                            System.out.println("目前是player1,請輸入座標 x,y範圍1~3");
                            area_x=scn.nextInt();
                            area_y=scn.nextInt();
                            while(gameing.game.PIECE_AREA[area_x-1][area_y-1].chessmanPiece!=' ')
                            {
                                System.out.println("請重新輸入座標,這已經有被記號過了");
                                area_x=scn.nextInt();
                                area_y=scn.nextInt();
                            }
                            gameing.game.PIECE_AREA[area_x-1][area_y-1]=player_one.chessPIECE;
                            game_start_number++;
                            game_piece_total++;

                            winner=gameing.game.game_winner(area_x,area_y);
                            if(winner==true)
                            {
                                System.out.println(player_one.name+"獲勝");
                                player_one.score+=10;
                                break;
                            }
                        }
                        //檢查勝敗
                        //檢查勝敗條件

                    }
                    System.out.println(player_one.name+" 分數:"+player_one.score);
                    System.out.println(player_two.name+" 分數:"+player_two.score);
                break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }
            
            
            //結束遊戲 如果按下結束遊戲則呼叫gameing.gameover();
            //如果沒結束遊戲則重新選擇想遊玩的遊戲
        }
    }
}
