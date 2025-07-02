import java.util.Scanner;
import java.lang.Math;
public class wk2{

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int x1;
		int y1;
		double L,a,b,c;
		double PQ=0;
		System.out.println("input(x1,y1)");
		x1 = sc.nextInt();
		y1 = sc.nextInt();
		System.out.println("input {L}:(ax+by+c=0)");
		System.out.println("input a");
		a = sc.nextInt();
		System.out.println("input b");
		b = sc.nextInt();
		System.out.println("input c");
		c = sc.nextInt();
		PQ=Math.abs(a*x1 +b*y1+c) /Math.sqrt( Math.pow(a,2)+Math.pow(b,2));  //點到直線公式
		System.out.println("PQ= "+PQ);  
		
	}
}