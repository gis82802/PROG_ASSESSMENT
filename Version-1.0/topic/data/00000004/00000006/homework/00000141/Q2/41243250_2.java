/*檔案標頭
filename:ch5_8.java
funtion:find the well-order number in 1~100000
author:劉宗修
date:2024/10/11
version:jdk23
*/

public class ch5_8 
{
	public static void main(String[] arg)
	{
		
		//變數設定
		int num = 1;		
		int T = 0;

		//迴圈1
		for(;num <= 100000;num++)
		{
			int stop = 0;//停止條件變數
			int maxnum = 10 ;
			int num1_save = num;//儲存使用者輸入值
			int num2_save = num;//儲存使用者輸入值

			//迴圈2
			for(;num2_save != 0;num2_save/=10)
			{
				int a = num2_save%10;//取num最後一位數
				if(a < maxnum)//若下一位數小於maxnum則將值儲存進maxnum並和在下一位數進行比較
				{
					maxnum = a;
				}
				else
				{
					stop = 1;
					break;
				}
			}

			//跳離迴圈,輸出結果,並計算有幾個 well-order number
			if(stop != 1) 
			{
				T++;//計算有幾個 well-order number
				System.out.println(num1_save+"是一個 well-order number");
			}
		}
	
		//輸出結果
		System.out.println("從1~100000的 well-order number 總共有 :"+T+"個");
	}
}
