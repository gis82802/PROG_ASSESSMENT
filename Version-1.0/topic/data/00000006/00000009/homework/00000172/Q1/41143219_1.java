/*
filename:java2_hw3
function:設計井字棋遊戲(TicTacToe)中的類別，例如：ChessBoard, Player, Piece 等
		思考每個類別應具備的成員函式，以及互動方式
author:41143219周偉宸
datetime:2024/3/12
version:1.0
*/
import java.util.Scanner;
class Piece{
	boolean circle;
	public int x,y;
	public Piece(int x1,int y1,boolean circle){
		x=x1;y=y1;this.circle=circle;
	}
}

class Player{
	public static boolean HUMAN_BK=true;
	public static boolean COMPUTER=false;
	Scanner scan=new Scanner(System.in);
	boolean playerType;
	public Player(boolean type){
		playerType=type;
	}
	public void getPieces(ChessBoard cb,boolean turn,Game game){
		int x,y;
		boolean last=true;
		x=0;y=0;
		while(true){
			if(playerType){
				if(!last){System.out.printf("there already has a piece.please input again:");}
				x=scan.nextInt();y=scan.nextInt();
			}
			else{
				Piece temp=cb.getEmpty();
				x=temp.x;y=temp.y;
			}
			if(last=cb.addPieces(new Piece(x,y,turn))){break;}
		}
	}
}

class Game{
	boolean turn=true;
	ChessBoard cb;
	Player playerA;
	Player playerB;
	public Game(){}
	public void start(){
		cb = new ChessBoard();
		playerA = new Player(Player.HUMAN_BK);
		playerB = new Player(Player.COMPUTER);
	}
	public int checkGameOver(){
		int won=cb.checkWon();
		if(won!=0){return won;}
		if(cb.fullBoard()){return 3;}
		return 0;
	}
	public void changeTurn(){
		if(turn){
			System.out.printf("PLAYER A please input a position(int y,int x):");
			playerA.getPieces(cb,turn,this);
			turn=false;
		}
		else{
			System.out.printf("PLAYER B please input a position(int y,int x):");
			playerB.getPieces(cb,turn,this);
			turn=true;
		}
		cb.refresh();
	}
}

class ChessBoard{
	int [][]board;
	public ChessBoard(){
		board=new int[3][3];
		refresh();
	}
	public boolean addPieces(Piece piece){
		if((piece.x==-1)||(piece.y==-1)||(board[piece.x][piece.y]!=0)){
			return false;
		}
		else{
			board[piece.x][piece.y]=piece.circle?1:2;
			return true;
		}
	}
	public int checkWon(){
		int res=0;
		for(int i=1;i<=2;i++){
			if(((board[0][0]==i)&&(board[0][1]==i)&&(board[0][2]==i))||
			((board[1][0]==i)&&(board[1][1]==i)&&(board[1][2]==i))||
			((board[2][0]==i)&&(board[2][1]==i)&&(board[2][2]==i))||
			((board[0][0]==i)&&(board[1][0]==i)&&(board[2][0]==i))||
			((board[0][1]==i)&&(board[1][1]==i)&&(board[2][1]==i))||
			((board[0][2]==i)&&(board[1][2]==i)&&(board[2][2]==i))||
			((board[0][2]==i)&&(board[1][1]==i)&&(board[2][0]==i))||
			((board[0][0]==i)&&(board[1][1]==i)&&(board[2][2]==i))){
				res=i;
			}
		}
		return res;
	}
	public void refresh(){
		System.out.printf(" x");
		for(int x=0;x<board.length;x++){
			System.out.printf(x+" ");
		}
		System.out.printf("\ny\n");
		for(int x=0;x<board.length;x++){
			for(int y=0;y<board[x].length;y++){
				if(y==0)System.out.printf(x+" ");
				if(board[x][y]==0)System.out.printf(" ");
				else if(board[x][y]==1)System.out.printf("O");
				else if(board[x][y]==2)System.out.printf("X");
				if(y<board.length-1)System.out.printf("|");
				else System.out.printf("\n");
			}
			if(x<board.length-1)System.out.printf("  -----");
			System.out.printf("\n");
		}
	}
	public boolean fullBoard(){
		boolean full=true;
		for(int x=0;x<board.length;x++){
			for(int y=0;y<board[x].length;y++){
				if(board[x][y]==0){
					full=false;
					break;
				}
			}
			if(!full)break;
		}
		return full;
	}
	public Piece getEmpty(){
		Piece ret;
		int sum=0;
		int x1=-1,y1=-1;
		for(int x=0;x<board.length;x++){
			for(int y=0;y<board[x].length;y++){
				if(board[x][y]==0)sum++;
			}
		}
		if(sum>0){
			sum=(int)(Math.random() *(sum)+1);
			for(int x=0;x<board.length;x++){
				for(int y=0;y<board[x].length;y++){
					if(board[x][y]==0)sum--;
					if(sum==0){
						x1=x;y1=y;
						System.out.printf("COMPUTER SET ON "+x+","+y+"!\n");
						break;
					}
				}
				if(sum==0)break;
			}
		}
		return ret=new Piece(x1,y1,true);
	}
}


public class java2_hw3{
	public static void main(String []args){
		Game game=new Game();
		game.start();
		int winner;
		while(true){
			winner=game.checkGameOver();
			if(winner!=0){
				if(winner==1)System.out.printf("PLAYER A WON!");
				if(winner==2)System.out.printf("PLAYER B WON!");
				if(winner==3)System.out.printf("DRAW...");
				break;
			}
			game.changeTurn();
		}
	}
}