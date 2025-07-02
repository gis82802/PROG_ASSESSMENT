/*檔案標頭
filename:hw4_3.java
funtion:比較三數大小並排序
author:劉宗修
date:2024/10/4
version:jdk23
*/

//函式庫導入
import java.util.Scanner;//引入Scanner

public class hw4_3 {
	public static void main(String[] arg){
		Scanner sc = new Scanner(System.in);//初始化Scanner套件
	
		//變數設定
		int num1 = 0, num2 = 0, num3 = 0;
		int max = 0, min = 0, middle = 0;

		//輸入讀取
		System.out.print("請輸入整數1=");
		num1=sc.nextInt();//讓使用者輸入int
		System.out.print("請輸入整數2=");
		num2=sc.nextInt();//讓使用者輸入int
		System.out.print("請輸入整數3=");
		num3=sc.nextInt();//讓使用者輸入int

		//程式主要執行部分
		max = (num1 >= num2)? (num1 >=num3 ? num1 : num3) :( num2 >= num3 ? num2 : num3);//判斷3個整數誰是最大值
		min = (num1 <= num2)? (num1 <=num3 ? num1 : num3) :( num2 <= num3 ? num2 : num3);//判斷3個整數誰是最小值
		middle = (num1+num2+num3) - (max+min);//用計算的方式算出中間值

		//輸出結果
		System.out.println("max = "+max);
		System.out.println("middle = "+middle);
		System.out.println("min = "+min);

		//程式結束
		sc.close();


	}

}