/*檔案標頭
filename:hw4_1.java
funtion:輸入2個二維資料點,計算(1)通過此二點的直線方程式、(2)計算此二點的歐式距離、
曼哈頓距離、切比雪夫距離(3)將資料點視為向量,計算此二個向量的夾角
author:劉宗修
date:2024/10/4
version:jdk23
*/

//函式庫導入
import java.util.Scanner;//引入Scanner

public class hw4_1 {
	public static void main(String[] arg){
		Scanner sc = new Scanner(System.in);//初始化Scanner套件

		//變數設定
		float x1 = 0, x2 = 0, y1=1, y2=-1;//使用者設定之座標初值
		float m = 0, b = 0;//斜率變數和Y軸截距變數
		double X_lan = 0.0, Y_lan = 0.0, Hypo_lan = 0.0;//計算歐式、曼哈頓及切比雪夫距離之變數
		double Dot = 0.0, Xvec_len = 0.0, Yvec_len = 0.0, cos = 0.0;//計算向量距離之變數
		
		//輸入讀取
		System.out.print("請輸入x1座標:");
		x1=sc.nextFloat();//讓使用者輸入float
		System.out.print("請輸入y1座標:");
		y1=sc.nextFloat();//讓使用者輸入float
		System.out.print("請輸入x2座標:");
		x2=sc.nextFloat();//讓使用者輸入float
		System.out.print("請輸入y2座標:");
		y2=sc.nextFloat();//讓使用者輸入float
		
		//////////////////////////////////////////計算直線方程式
		m =((y2-y1)/(x2-x1));
		b = y1 - (m*x1);
		if(b>=0){
			System.out.println("直線方程式: y="+(int)m+"x+"+(int)b);
		}else{
			System.out.println("直線方程式: y="+(int)m+"x"+(int)b);
		}

		//////////////////////////////////////////計算歐式距離
		X_lan=Math.pow((x2-x1), 2);
		Y_lan=Math.pow((y2-y1), 2);

		Hypo_lan=Math.pow(X_lan+Y_lan, 0.5);
		System.out.println("歐式距離為:"+Hypo_lan);

		//////////////////////////////////////////計算曼哈頓距離
		X_lan=Math.abs(x1-x2);
		Y_lan=Math.abs(y1-y2);
		System.out.println("曼哈頓距離為:"+(X_lan+Y_lan));

		//////////////////////////////////////////計算切比雪夫距離

		X_lan=Math.abs(x1-x2);
		Y_lan=Math.abs(y1-y2);
		System.out.println("切比雪夫距離為:"+Math.max(X_lan,Y_lan));

		//////////////////////////////////////////計算向量距離

        	Dot = (x1 * x2) + (y1 * y2);// 計算內積 (dot product)
        	
        	Xvec_len= Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));// 計算兩向量的長度 (magnitude)
        	Yvec_len = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));// 計算兩向量的長度 (magnitude)
       		
        	cos = Dot / (Xvec_len * Yvec_len);// 計算 cos 值
        	
		System.out.println("兩個向量夾角為為:"+Math.toDegrees(Math.acos(cos))+"度");// 輸出結果




		//程式結束
		sc.close();
	}

}