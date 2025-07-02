/*
    Filename: "App02_1004"
    Function: 求點到直線距離
    Author: SHUN-YE XU
    Version: 17.0.11
    date: 2024/10/4
*/

import java.util.Scanner;

public class App02_1004
{
    
    public static void main(String[] args)
    {
	float x, y, m, cept;
	double distance;

	Scanner s = new Scanner(System.in);

	System.out.print("輸入x,y: ");
	x = s.nextFloat(); y = s.nextFloat();
	System.out.print("輸入斜率,截距: ");
	m = s.nextFloat(); cept = s.nextFloat();
	
	distance = Math.abs(m*x - y + cept) / Math.sqrt(m*m + 1); 
	System.out.println("點到直線距離" + distance);
    }
}	