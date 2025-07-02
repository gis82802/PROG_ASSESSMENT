import java.util.Scanner;
public class path
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner (System.in);
		
		int x1,y1,x2,y2,a,b;
		System.out.println("輸入要尋找最短路徑的線段兩點: ");
		System.out.println("x1 = ");
		x1 = sc.nextInt();
		System.out.println("y1 = ");
		y1 = sc.nextInt();
		System.out.println("x2 = ");
		x2 = sc.nextInt();
		System.out.println("y2 = ");
		y2 = sc.nextInt();
		
		System.out.println("輸入要尋找最短路徑的座標(a,b): ");
		System.out.println("a = ");
		a = sc.nextInt();
		System.out.println("b = ");
		b = sc.nextInt();
		
		//方程式
		float m = (float)(y2-y1)/(x2-x1);//斜率
		float c = (m*(-x1))+y1;
		System.out.println("直線方程式:y - "+y1+" = "+m+" ( x - "+x1+")");
		System.out.println("直線方程式:"+m+"x - y + ( "+c+" ) = 0");		
		
		//距離
		double d = (m*a-b+c)/(Math.sqrt(Math.pow(a,2)+Math.pow(b,2)));
		System.out.println("線與點的距離:"+(m*a-b+c));
	}
}