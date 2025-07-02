/*
filename:hw
function:計算點與直線的距離
author:傅學呈
data:2024/10/04
version:11.0.12
*/
import java.util.Scanner;
public class hw
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		//輸入點座標
		System.out.print("輸入X座標(x1):");
		double x1= scanner.nextDouble();
		System.out.print("輸入Y座標(y1):");
		double y1= scanner.nextDouble();

		//輸入直線方程式的係數 Ax+By+C=0
		System.out.print("輸入直線方程式的係數 A: ");
        	double A = scanner.nextDouble();
        	System.out.print("輸入直線方程式的係數 B: ");
        	double B = scanner.nextDouble();
        	System.out.print("輸入直線方程式的係數 C: ");
        	double C = scanner.nextDouble();
		
		//計算點與直線的距離
		double distance;
		distance=(Math.abs(A*x1+B*y1+C))/(Math.sqrt(A*A+B*B));
		System.out.print("直線距離為:"+distance);
	}
}