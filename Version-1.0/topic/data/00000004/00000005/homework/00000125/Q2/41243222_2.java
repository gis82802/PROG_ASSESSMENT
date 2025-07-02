/*
filename:app 4_3
funtion:distance of pooint too line
auther:ToBoShu
date:2024/10/04
version:jdk23
*/
/*
System.out.println();
import java.util.Scanner;
Scanner sc = new Scanner(system.in);
int x = sc.nextInt;
throws Exxception
Thread.sleep(x);
Math.pow(x,2.0);
Math.squt(x);
*/

import java.util.Scanner;

public class app4_3
{
	public static void main(String args[]) 

	{
	//使用者輸入
	Scanner sc = new Scanner(System.in);
	int x1, y1, x2, y2, x, y, a, b, c;
	double dis,tmp;
	System.out.print("請輸入直線方程式x1座標:");
	x1 = sc.nextInt();
	System.out.print("請輸入直線方程式y1座標:");
	y1 = sc.nextInt();
	System.out.print("請輸入直線方程式x2座標:");
	x2 = sc.nextInt();
	System.out.print("請輸入直線方程式y2座標:");
	y2 = sc.nextInt();
	System.out.print("請輸入點座標x:");
	x = sc.nextInt();
	System.out.print("請輸入點座標y:");
	y = sc.nextInt();
	
	//計算直線方程式(ax+by+c=0)
	a = y2-y1;
	b = x1-x2;
	c = x2 *y1 - x1 * y2;
	//計算點到直線距離
	dis = Math.abs(a*x + b*y + c)/Math.pow(a*a+b*b,0.5);
	System.out.println("以(" + x1 + "," + y1 + ") 和 (" + x2 + "," + y2 + ") 形成的直線方程式為:" + a + "x +" + b + "y +" + c + " = 0");
	System.out.println("點 (" + x + "," + y + ") 與直線的最短距離為: " + dis);
	
	}
}