import java.util.Scanner;
public class e2D
{
	public static void main(String args[])
	{
		Scanner scn=new Scanner(System.in);
		int x1,x2,y1,y2;
		System.out.println("輸入兩個座標點:");
		System.out.println("x1=");
		x1=scn.nextInt();
		System.out.println("y1=");
		y1=scn.nextInt();
		System.out.println("x2");
		x2=scn.nextInt();
		System.out.println("y2=");
		y2=scn.nextInt();
		
		float m=(float)(y2-y1)/(x2-x1);//斜率
		System.out.println("直線方程式:y-"+y1+"="+m+"(x-"+x1+")");//直線方程式

		//歐式距離
 		double d=Math.pow((x2-x1),2)+Math.pow((y2-y1),2);//歐式距離的平方
		System.out.println("歐式距離:"+Math.sqrt(d));

		//曼哈頓距離
		int Ma=Math.abs(y2-y1)+Math.abs(x2-x1);
		System.out.println("曼哈頓距離:"+Ma);

		//切比雪夫距離
		int Ch=Math.max(Math.abs(x2-x1),Math.abs(y2-y1));
		System.out.println("切比雪夫距離:"+Ch);

		//夾角
		float dot=(x1*x2+y1*y2);
		double a=Math.pow(x1,2)+Math.pow(y1,2);
		double b=Math.pow(x2,2)+Math.pow(y2,2);
		double la=Math.sqrt(a);
		double lb=Math.sqrt(b);
		double angle=Math.toDegrees(Math.acos(dot/la*lb));
		System.out.println("夾角:"+angle);
	}
}