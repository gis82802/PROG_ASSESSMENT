/*
filename:hw1.java
funtion: 建立一個一維整數陣列, 將陣列內容進行排序, 程式輸出排序前與排序後的結果
author: 劉宗修
date: 2024/10/25
version: jdk23
*/

// 函式庫導入
import java.util.Scanner; // 引入 Scanner 類別，用於讀取使用者輸入

public class hw1 {
	public static void main(String[] arg)
	{

		// 初始化 Scanner 物件，準備讀取使用者輸入
		Scanner sc = new Scanner(System.in);
		 
		//System.out.println("請輸入陣列長度：");
		//int num = sc.nextInt(); // 讓使用者輸入整數，表示陣列大小
		
		int B[][];

		System.out.println("請輸入第一個矩陣大小是幾乘幾(n*n?)請輸入n的值:");
		int num = sc.nextInt(); // 讓使用者輸入整數，表示陣列大小
		int A[][][] = new int[2][num][num];//加入4個空的值
		arr(A);
		/*
		//System.out.println("請輸入您的矩陣大小是幾乘幾(n*n?):");
		for(int i=0;i<2;i++)
		{
			System.out.println("////////////");
			for(int j=0;j<num;j++)
			{
				for(int k=0;k<num;k++)
				{
					
					System.out.print("請輸入第"+(i+1)+"個陣列位置為("+(j+1)+","+(k+1)+"的值)");
					A[i][j][k]=sc.nextInt(); // 讓使用者輸入整數，表示陣列大小
				
				}
			}
		}
		System.out.println("////////////");
		for(int i=0;i<num;i++)
		{
			System.out.println("第"+(i+1)+"個陣列值為");
			for(int j=0;j<num;j++)
			{
				for(int k=0;k<num;k++)
				{
					System.out.print(A[i][j][k]);
					System.out.print(" ");				
				}
				System.out.println("");				
			}
			System.out.println("");
		}*/

		



		
	}
	public static int[][][] arr(int ARR[][][])
	{
		if(ARR[1][1].length != ARR[2].length)
			System.out.println("////////////");
		/*for(int i=0;i<ARR.length;i++)
		{
			for(int j=0;j<ARR[i].length;j++)
			{
				ARR[i][j]+=10;
			}
		}
		return ARR;*/
	}
}