import java.util.Scanner;
class TicTacToe{
	String tmp;
	void Piece(ChessBoard game){
		String[] tmp2;
		if(game.status==0)
		{
			System.out.println("error!");
		}
		else{
			System.out.println("its your turn! please enter x,y ex: 1,2 .");
			Scanner Tsc=new Scanner(System.in);
			while(true){
				tmp=Tsc.nextLine();
				tmp2=tmp.split(",");
				if(game.cdt[Integer.parseInt(tmp2[0])-1][Integer.parseInt(tmp2[1])-1]==0) break;
				System.out.println("error! enter again.");
			}
			game.viewCB(tmp2);
		}
	}
	void CpuFstPiece(ChessBoard game){
		int rdnX,rdnY;
		do{
			rdnX=(int)(Math.random()*3);
			rdnY=(int)(Math.random()*3);
			if(game.cdt[rdnX][rdnY]==0) break;
		}while(true);
		System.out.println("Cpu turn!it played: "+(rdnX+1)+","+(rdnY+1));
		game.viewCB(rdnX,rdnY);
		
	}
	void CpuPiece(ChessBoard game){
		
	}
}
class ChessBoard{
	int status=0;
	int [][]cdt=new int[3][3];    					//cdt save chess board status
	void GameStart(){
		status=1;
	}
	boolean whoFirst(){
		int status=0,cpuRdn;
		String tmp;
		System.out.println("Please enter 1 or 2 or 3, it means scissors, rock, paper");
		Scanner CBsc=new Scanner(System.in);
		tmp=CBsc.nextLine();
		while(true){
			cpuRdn=(int)(Math.random()*3)+1;
			System.out.println("Cpu: "+cpuRdn);
			if((tmp.equals("1")&& cpuRdn==2) || (tmp.equals("2")&& cpuRdn==3) || (tmp.equals("3")&& cpuRdn==1)){
				System.out.println("Cpu first!\n");
				return false;
			}
			else if((tmp.equals("1")&& cpuRdn==3) || (tmp.equals("2")&& cpuRdn==1) || (tmp.equals("3")&& cpuRdn==2)){
				System.out.println("You first!\n");
				return true;
			}
			System.out.println("draw! enter again.\n");
			tmp=CBsc.nextLine();
		}
	}
	void viewCB(String[] tmp){
		
		cdt[Integer.parseInt(tmp[0])-1][Integer.parseInt(tmp[1])-1]=1;
		for (int []x:cdt){
			System.out.print("| ");
			for(int y:x){
				System.out.print(y==1?"X":y==2?"O":"N");
				System.out.print("| ");
			}
			System.out.println();
		}
	}
	void viewCB(int rdnX,int rdnY){
		cdt[rdnX][rdnY]=2;
		for (int []x:cdt){
			System.out.print("| ");
			for(int y:x){
				System.out.print(y==2?"O":y==1?"X":"N");
				System.out.print("| ");
			}
			System.out.println();
		}
	}
	boolean GameCheck(){
		for(int i=0;i<3;i++)
		{
			if(cdt[0][i]==cdt[1][i]&&cdt[1][i]==cdt[2][i]&&cdt[0][i]!=0){
				System.out.println(cdt[0][i]==1?"You Win!":cdt[0][i]==2?"You Lose...":"");
				return false;
			}
			if(cdt[i][0]==cdt[i][1]&&cdt[i][1]==cdt[i][2]&&cdt[i][0]!=0){
				System.out.println(cdt[i][0]==1?"You Win!":cdt[i][0]==2?"You Lose...":"");
				return false;
			}
		}
		if(cdt[0][0]==cdt[1][1]&&cdt[1][1]==cdt[2][2]&&cdt[0][0]!=0){
				System.out.println(cdt[0][0]==1?"You Win!":cdt[0][0]==2?"You Lose...":"");
				return false;
		}
		if(cdt[0][2]==cdt[1][1]&&cdt[1][1]==cdt[2][0]&&cdt[0][2]!=0){
				System.out.println(cdt[0][2]==1?"You Win!":cdt[0][2]==2?"You Lose...":"");
				return false;
		}
		return true;
	}

}
public class main{
	public static void main(String[] args){
		
		ChessBoard g1=new ChessBoard();			// Create chess game
		TicTacToe p1=new TicTacToe();			// Create player
		//p1.Piece(g1); 				// Return error cause game not start.
		g1.GameStart();					// Check game start, if it is not start that it can't piece the chess.
		if(g1.whoFirst()){  				// Rock-paper-scissors decides who first, cpu first return 0, gamePlayer first return 1. 		
			p1.Piece(g1);		
			p1.CpuFstPiece(g1);			// Cpu first will play random
		}
		else {
			p1.CpuFstPiece(g1); 		        // Cpu first will play random
		}
		while(g1.GameCheck()){				// Check game over.if player win will return you win, or you lose. 
			p1.Piece(g1);				// if coordinate already has chess,return error and ask for new coordinate.
			p1.CpuFstPiece(g1);			// First Check coordinate. Second prevent player win(ex. player has two chess on line). Third play continue.(ex. if first chess on (0,0), next will be (0,1) or (1,0).)
		}	
	}
}