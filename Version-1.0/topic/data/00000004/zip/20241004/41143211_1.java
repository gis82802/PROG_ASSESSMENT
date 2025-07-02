import java.util.Scanner;
import java.lang.Math;

public class Test1
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		//==========  輸入兩點座標
		
        	System.out.print("請輸入第一個點的x座標x1:");
		double x1 = s.nextDouble();
        	System.out.print("請輸入第一個點的y座標y1:");
		double y1 = s.nextDouble();
		
        	System.out.print("請輸入第二個點的x座標x2:");
		double x2 = s.nextDouble();
        	System.out.print("請輸入第二個點的y座標y2:");
		double y2 = s.nextDouble();
		
		//========== 直線方程式
		
		System.out.print("直線方程式為:");
		if(x1==x2)
			System.out.println("x="+x1);
		else
		{
			double m=(y2-y1)/(x2-x1);// 計算斜率
			double b=y1-m*x1;        // 計算y截距
			
			System.out.printf("y = %.2fx + %.2f%n",m,b);
		}
		
		//========== 兩點距離
		
		double Distance = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
		System.out.printf("兩點的歐式距離為:%.2f%n",Distance);
		
		double ManhattanDistance = Math.abs(x2-x1)+Math.abs(y2-y1);
		System.out.printf("兩點的曼哈頓距離為:%.2f%n",ManhattanDistance);
		
		System.out.print("為計算Minkowski距離，請輸入p值:");
        	double p = s.nextDouble();
		double MinkowskiDistance = Math.pow(Math.abs(x2-x1),p)+Math.pow(Math.abs(y2-y1),p);
		System.out.printf("兩點的Minkowski距離為:%.2f%n",MinkowskiDistance);
		
		//========== 向量夾角
		
        	double dotProduct = x1*x2+y1*y2; // 計算點積
		
		double magnitudeA = Math.sqrt(x1*x1+y1*y1); // 計算兩個向量的大小
		double magnitudeB = Math.sqrt(x2*x2+y2*y2);
        	
		double cosTheta = dotProduct/(magnitudeA*magnitudeB); // 計算夾角(單位為弧度)
		
		if (cosTheta<-1.0) cosTheta = -1.0; // 防止cosTheta超出-1到1的範圍
		if (cosTheta>1.0) cosTheta = 1.0;

		double angleInRadians = Math.acos(cosTheta);
		double angleInDegrees = Math.toDegrees(angleInRadians); // 轉換為度數
		
		System.out.printf("兩向量的夾角為:%.2f度%n",angleInDegrees);
		
		s.close();
	}
}