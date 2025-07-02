/*檔案標頭
filename:hw4_2.java
funtion:算出點到直線方程式的直線距離
author:劉宗修
date:2024/10/4
version:jdk23
*/

//函式庫導入
import java.util.Scanner;//引入Scanner

public class hw4_2 {
	public static void main(String[] arg){
		Scanner sc = new Scanner(System.in);//初始化Scanner套件

		//變數設定
		int a= 0, b = 0, c = 0;//ax+by+c=0公式變數值
		int x = 1, y = 1;//座標值
		double Distance = 0;//點到直線方程式的直線距離

		//輸入讀取
		System.out.println("請輸入L : ax+by+c=0 多項式中的a、b、c值(限整數)");
		System.out.print("a = ");
		a = sc.nextInt();//讓使用者輸入int
		System.out.print("b = ");
		b = sc.nextInt();//讓使用者輸入int
		System.out.print("c = ");
		c = sc.nextInt();//讓使用者輸入int
		System.out.println("請輸入P(x,y)座標中的x,y值(限整數)");
		System.out.print("x = ");
		x = sc.nextInt();//讓使用者輸入int
		System.out.print("y = ");
		y = sc.nextInt();//讓使用者輸入int


		//程式主要執行部分
		Distance = (Math.abs(a*x+b*y+c)/Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)));// 計算兩向量的長度 (magnitude)

		//輸出結果
		System.out.println("點到直線方程式的直線距離為: "+Distance);






		//程式結束
		sc.close();


	}

}