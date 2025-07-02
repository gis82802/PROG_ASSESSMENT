//1004上課練習_2
import java.util.Scanner;
public class a1004_2
{
	public static void main(String arg[])
	{
		System.out.print("請輸入A B C(方程式為AX+BY+C=0):");
		Scanner scn=new Scanner(System.in);
		double A=scn.nextDouble();
		double B=scn.nextDouble();
		double C=scn.nextDouble();
		System.out.print("請輸入X Y:");
		double x=scn.nextDouble();
		double y=scn.nextDouble();
		System.out.println("直線到點的距離="+Math.abs(A*x+B*y+C)/Math.sqrt(Math.pow(A,2)+Math.pow(B,2)));
	}
}