/*
filename:app 4_1
funtion:any distance
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
public class app4_2
{
	public static void main(String args[]) 

	{
	Scanner sc = new Scanner(System.in);
	int x1, y1, x2, y2, a, b, c;
	double dis, tmp;

	//使用者輸入
	System.out.print("請輸入x1座標:");
	x1 = sc.nextInt();
	System.out.print("請輸入y1座標:");
	y1 = sc.nextInt();
	System.out.print("請輸入x2座標:");
	x2 = sc.nextInt();
	System.out.print("請輸入y2座標:");
	y2 = sc.nextInt();
	
	//計算直線方程式(ax+by+c=0)
	a = y2-y1;
	b = x1-x2;
	c = x2 *y1 - x1 * y2;
	System.out.println("(" + x1 + "," + y1 + ") 和 (" + x2 + "," + y2 + ") 的直線方程式為:" + a + "x +" + b + "y +" + c + " = 0");
	
	//計算歐式距離(點到點距離)
	tmp = Math.pow(x1-x2,2)+Math.pow(y1-y2,2);
	dis = Math.pow(tmp,0.5);
	System.out.println("(" + x1 + "," + y1 + ") 和 (" + x2 + "," + y2 + ") 的歐式距離為:" + dis);

	//計算曼哈頓距離
	dis = Math.abs(x1-x2)+Math.abs(y1-y2);
	System.out.println("(" + x1 + "," + y1 + ") 和 (" + x2 + "," + y2 + ") 的曼哈頓距離為:" + dis);
	
	//計算切比雪夫距離
	dis = Math.max(Math.abs(x1-x2), Math.abs(y1-y2));
	System.out.println("(" + x1 + "," + y1 + ") 和 (" + x2 + "," + y2 + ") 的切比雪夫距離為:" + dis);

	//計算兩向量夾角
	tmp = (x1 * x2 + y1 * y2) / (Math.pow((x1 * x1 + y1 * y1), 0.5) * Math.pow((x2 * x2 + y2 * y2), 0.5));
	tmp = Math.max(-1.0, Math.min(1.0, tmp));
	System.out.println("(" + x1 + "," + y1 + ") 和 (" + x2 + "," + y2 + ") 的向量夾角為: " + Math.toDegrees(Math.acos(tmp)) + " 度");

	}
}