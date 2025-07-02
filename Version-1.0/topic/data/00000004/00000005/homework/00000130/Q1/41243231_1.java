/*
    Filename: "App01_1004"
    Function: 求直線方程式、歐式距離、曼哈頓距離、切比雪夫距離、夾角
    Author: SHUN-YE XU
    Version: 11.0.12
    date: 2024/10/4
*/

import java.util.Scanner;

public class App01_1004
{
    
    public static void main(String[] args)
    {
	int x1, x2, y1, y2, m, b;
	double angle;
	Scanner s = new Scanner(System.in);

	System.out.print("輸入x1,y1: ");
	x1 = s.nextInt(); y1 = s.nextInt();
	System.out.print("輸入x2,y2: ");
	x2 = s.nextInt(); y2 = s.nextInt();
	
	m = (y2-y1) / (x2-x1); // 求斜率
	b = y1 - m * x1;
	angle = Math.toDegrees(Math.acos((x1*x2+y1*y2) / (Math.sqrt(x1 * x1 + y1 * y1) * Math.sqrt(x2 * x2 + y2 * y2))));
	
	if(b < 0)
	{
	    System.out.println("直線方程式: y = "+m+"x - "+Math.abs(b)+"");
	}
	    
	else
	{
	    System.out.println("直線方程式: y = "+m+"x + "+b+"");
	}
	    
	System.out.println("歐式距離: "+ Math.sqrt(Math.pow(x1-y1, 2) + Math.pow(x2-y2, 2)));
	System.out.println("曼哈頓距離: "+ Math.abs(x1-x2) + Math.abs(y1-y2));
	System.out.println("切比雪夫距離: "+ Math.max(Math.abs(x1-x2), Math.abs(y1-y2)));
	System.out.println("夾角: "+ angle/180 * Math.PI);
	
    }
}