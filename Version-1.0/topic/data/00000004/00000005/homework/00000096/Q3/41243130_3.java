//1004上課練習_3
import java.util.Scanner;
public class a1004_3
{
	public static void main(String arg[])
	{
		System.out.print("請輸入三個數:");
		Scanner scn=new Scanner(System.in);
		double a=scn.nextDouble();
		double b=scn.nextDouble();
		double c=scn.nextDouble();
		double max,min,mid;
		max=Math.max(a,Math.max(b,c));
		min=Math.min(a,Math.min(b,c));
		mid=Math.min(Math.min(Math.max(a,b),Math.max(b,c)),Math.max(a,c));
		System.out.println("最大值:"+max+"\n中間值:"+mid+"\n最小值:"+min);
	}
}