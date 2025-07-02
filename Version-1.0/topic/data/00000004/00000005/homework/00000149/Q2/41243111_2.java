import java.util.Scanner;
import java.lang.Math;

public class Test2
{
	
	//========== 計算點與線距離的函式
	
	public static double CalculateDistance(double x,double y,double m, double b) 
	{
		double A = -m;  // 直線方程式: y = mx + b
		double B = 1;   // 將直線轉換為 Ax + By + C = 0 的形式
		double C = -b;
		
        	return Math.abs(A*x+B*y+C)/Math.sqrt(A*A+B*B);  // 計算距離
	}
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		//==========  使用者輸入點和線
		
        	System.out.print("請輸入點的x座標:");
		double x = s.nextDouble();
        	System.out.print("請輸入點的y座標:");
		double y = s.nextDouble();

        	System.out.print("請輸入直線方程式的斜率m:");
		double m = s.nextDouble();
        	System.out.print("請輸入直線方程式的y截距:");
		double b = s.nextDouble();
		
		//==========  輸出結果
		
		double distance = CalculateDistance(x,y,m,b);  //代入求解
		System.out.printf("點(%.2f, %.2f)到直線y = %.2fx + %.2f的最短距離是:%.4f%n",x,y,m,b,distance);
		
		s.close();
	}
}