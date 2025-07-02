//1004上課練習_1
import java.util.Scanner;
public class a1004_1
{
	public static void main(String arg[])
	{
		System.out.print("請輸入x1 y1 x2 y2:");
		Scanner scn=new Scanner(System.in);
		double a1=scn.nextDouble();
		double a2=scn.nextDouble();
		double b1=scn.nextDouble();
		double b2=scn.nextDouble();
		System.out.println("直線方程式:(y-"+a2+")="+((a2-b2)/(a1-b1))+"(x-"+a1+")");
		
		double d=Math.sqrt(Math.pow(a1-b1,2)+Math.pow(a2-b2,2));
		System.out.println("歐式距離為:"+d);
		
		d=Math.abs(a1-a2)+Math.abs(b1-b2);
		System.out.println("曼哈頓距離為:"+d);
		
		d=Math.max(Math.abs(a2-a1),Math.abs(b2-b1));
		System.out.println("切比雪夫距離為:"+d);
		
		double ab=a1*b1+b2*a2;
		double ab1=Math.sqrt(Math.pow(a1,2)+Math.pow(a2,2))*Math.sqrt(Math.pow(b1,2)+Math.pow(b2,2));
		d=ab/ab1;
		System.out.println("視為向量的夾角為:"+Math.acos(d));
	}
}