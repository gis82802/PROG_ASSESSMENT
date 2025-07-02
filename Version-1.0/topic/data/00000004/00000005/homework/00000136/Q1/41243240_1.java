/*
filename:app4_5
function:輸入座標並印出直線方程式和歐式距離、曼哈頓距離、切比雪夫距離及兩點視為向量之間的角度
author:傅學呈
data:2024/10/04
version:11.0.12
*/
import java.util.Scanner;
public class app4_5
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		//輸入點座標
		System.out.print("輸入X座標(x1):");
		double x1= scanner.nextDouble();
		System.out.print("輸入Y座標(y1):");
		double y1= scanner.nextDouble();
		System.out.print("輸入X座標(x2):");
		double x2= scanner.nextDouble();
		System.out.print("輸入Y座標(y2):");
		double y2= scanner.nextDouble();

		//判定是一條直線還是水平線或垂直線
		if (x2 - x1 != 0) {
			if(y2-y1!=0){
            			double m = (y2 - y1) / (x2 - x1);
            			double b = y1 - m * x1;
				System.out.println("直線方程式: y="+m+"x"+b);
			}
			else{
				System.out.println("此為水平線: y="+y1);
			}
		}
		else {
           		 System.out.println("此為垂直線: x="+x1);
        	}

		//用於紀錄(x1-x2)(y1-y2)的運算值
		double a=0,b=0;
		a=x1-x2;
		b=y1-y2;

		//歐式距離
		double EuclideanDis = Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
		System.out.println("歐式距離為:"+EuclideanDis);

		//將(x1-x2)和(y1-y2)若為負則取絕對值
		if(a<0){
			a=a*-1;
		}
		if(b<0){
			b=b*-1;
		}

		//曼哈頓距離(x1-x2)-(y1-y2)
		double ManhattanDis=a+b;
		System.out.println("曼哈頓距離為:"+ManhattanDis);
		
		//切比雪夫距離 max(|x1-x2|,|y1-y2|)
		double ChebDis=Math.max(a,b);				//兩點取最大值
		System.out.println("切比雪夫為max("+a+","+b+")距離:"+ChebDis);

		//計算兩個向量的夾角
		double vector=(x1*x2)+(y1*y2);				//將兩點座標視為向量後根據公式計算的值
		double P1=Math.sqrt(Math.pow(x1,2)+Math.pow(y1,2));	//第一項座標的長度
		double P2=Math.sqrt(Math.pow(x2,2)+Math.pow(y2,2));	//第二項座標的長度
		double Cos=vector/(P1*P2);				//存放計算完的餘弦值
		double Radian=Math.acos(Cos);				//將計算的值轉換成弧度
		double Degree=Math.toDegrees(Radian);			//將弧度轉換成角度
		System.out.println("兩點座標之間的夾角為:"+Degree);	//將結果輸出
		
	}
}