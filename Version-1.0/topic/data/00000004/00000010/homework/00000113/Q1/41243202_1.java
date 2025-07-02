/*
	資工二乙	41243202	林沛慧
	功能：輸入兩個二維陣列，並印出相乘後的結果
*/
import java.util.Scanner;
public class hw3_a
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入兩個二維矩陣：");
		System.out.print("第一個是幾行幾列的矩陣");
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int [][] a = new int [x1][y1];
		System.out.print("請輸入內容：");
		for(int i = 0 ; i < x1 ; i++)
			for(int j = 0 ; j < y1 ; j++)
				a[i][j] = sc.nextInt();
		System.out.print("第二個是幾行幾列的矩陣");
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int [][] b = new int [x2][y2];
		System.out.print("請輸入內容：");
		for(int i = 0 ; i < x2 ; i++)
			for(int j = 0 ; j < y2 ; j++)
				b[i][j] = sc.nextInt();
		System.out.print(matmultiply(a,b,x1,x2,y1,y2));
		
	}
	public static int matmultiply(int a[][],int b[][],int x1,int x2,int y1,int y2)
	{
		int sum = 0;
		if( x1 == y2 && x2 == y1)
		{
			for(int i = 0 ; i < x1 ; i++)
			{
				for(int j = 0 ; j < x2 ; j++)
				{
					sum += a[i][j]*b[j][i];
				}
			}
		}
		else
			System.out.print("null");

		return sum;		
	}
}