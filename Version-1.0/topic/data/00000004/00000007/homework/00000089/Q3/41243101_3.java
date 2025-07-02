import java.util.Scanner;
public class triangle
{
	public static void main(String args[])
	{
		int n,k,row=0,column=0;
		Scanner scn=new Scanner(System.in);
		System.out.print("請輸入一1至20間的數值，作為三角形的高度:");
		n=scn.nextInt();	//高度
		int triangleArray[][]=new int [n][n];

		if(0<n&&n<=20)
		{
			for (row = 1; row <= n; row++)		//顯示下三角
			{
				for (column = 1; column <= row; column++)
				{
					System.out.print("*");
				}
				System.out.println();
			}
			System.out.println();			//空行分隔上下三角
			
			row=0;
			column=0;
			for (row = 1; column <= n; row++)	//顯示上三角
			{
				for (column = 1; column < row; column++)
				{
					System.out.print(" ");
				}
				for (k = n; k >= row; k--)
				{
					System.out.print("*");
				}
				System.out.println();
			}
			
			row=0;
			column=0;
			int number = 1;			
       			for (row = 0; row <n; row++)	 			  //填入數字到下三角陣列中,在第row列有row+1個元素
			{
          			for (column = 0; column <= row; column++)
				{
               				triangleArray[row][column] = number++; 	  // 填入數字,然後遞增
           			}
       			}
       			System.out.print("請輸入要查找的數字: ");
       	 		int x = scn.nextInt();
	        	boolean found = false;
			row=0;
			column=0;
			for (row = 0; row < n; row++)				  //搜尋數字的位置,並輸出列和行
			{
        			for (column = 0; column <= row; column++)
				{
        			        if (triangleArray[row][column] == x)
					{
                				System.out.println("找到數字"+x+"位於: 第"+(row+1)+"列,第"+(column+1)+"行");
						found = true;
                    	                    	break; 				 // 找到後直接退出內層迴圈
                			}
            			}
           			if (found) break; 				 // 找到後直接退出外層迴圈
        		}
        		if (!found)
			{
        			System.out.println("陣列中查無此數字");
       			}
			
		}
		else
			System.out.print("請重新輸入一1至20間的數值，作為三角形的高度:");
		
		scn.close(); 	// 關閉 Scanner
	}
}