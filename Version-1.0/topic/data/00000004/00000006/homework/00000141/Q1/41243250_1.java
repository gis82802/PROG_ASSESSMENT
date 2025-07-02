/*檔案標頭
filename:ch5_5.java
funtion:(a)當i=10000,20000,...到 100000,所求到的pi值為多少?
author:劉宗修
date:2024/10/11
version:jdk23
*/

public class ch5_5 
{
	public static void main(String[] arg)
	{

		//變數設定
		float pi = 0, sum = 0;
	
		//迴圈
		for(int i = 10000;i <= 100000;i += 10000)
		{
			for(float j = 1;j <=i;j += 2)
			{
				float num = 2*j - 1, num1=2*j + 1;//將公式結果以變數方式儲存

				//計算公式
				sum += (float)1/num;
				sum -=  (float)1/num1;
			}

			//輸出結果
			System.out.println("當i為"+i+"時pi的值為"+4*sum);

			//恢復預設值
			pi = 0;sum = 0;

		}
	}
}
