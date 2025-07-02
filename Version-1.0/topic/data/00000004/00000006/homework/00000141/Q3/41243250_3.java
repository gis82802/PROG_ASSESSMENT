/*檔案標頭
filename:ch5_9.java
funtion:reverse digit order of an integer given by the user
author:劉宗修
date:2024/10/11
version:jdk23
*/

//函式庫導入
import java.util.Scanner;//引入Scanner

public class ch5_9 
{
	public static void main(String[] arg)
	{
		Scanner sc = new Scanner(System.in);//初始化Scanner套件

		//變數設定
		int num = 0;//儲存使用者輸入值
		int Reverse_Num = 0 ;//儲存和計算Reverse的數字

		//輸入讀取
		System.out.print("請輸入一個小於10000的整數(Int):");
		num=sc.nextInt();//讓使用者輸入int

		//迴圈
		for(;num != 0;num/=10)
		{
			int a = num%10;
			Reverse_Num = Reverse_Num*10 + a;
		}
	
		//輸出結果
		System.out.println("reverse後的整數:"+Reverse_Num);
		
		//程式結束
		sc.close();
	}
}
