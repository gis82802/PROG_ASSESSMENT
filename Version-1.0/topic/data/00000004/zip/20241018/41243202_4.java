/*
	資工二乙	41243202	林沛慧
	作業三：矩陣
	功能：輸入一個數為矩陣的大小，再依序輸入矩陣的行、列數字，然後輸出原始矩陣
	      再來可以輸入要刪掉哪個行列，然後輸出刪除完的矩陣，最後輸出計算結果
*/
import java.util.Scanner;
public class classtest4
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		//輸入矩陣大小
		System.out.print("請輸入一個數，此為方矩陣的大小(最大為4)：");
		int n = sc.nextInt();	
		
		int [][] rm = new int[n][n];
		int [][] vup = new int [n-1][n-1];

		//輸入矩陣內容
		for(int i = 0 ; i < n ; i++)
		{
			int ii = i+1;
			System.out.print("請輸入第"+ii+"行");
			for(int j =  0 ; j < n ; j++)
			{
				int jj = j+1;
				System.out.print("第"+jj+"列的數：");
				rm[i][j] = sc.nextInt();
			}
			System.out.println();
		}

		//輸出原始矩陣
		System.out.println("列出原始矩陣：");
		for(int i = 0 ; i < n ; i++)
		{
			for(int j = 0 ; j < n ; j++)
			{
				System.out.print(rm[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();

		//輸入要刪掉的行列
		System.out.print("請輸入兩個整數，分別為要刪除的行與列(不大於陣列大小)：");
		int c = sc.nextInt();
		c-=1;
		int r = sc.nextInt();
		r-=1;
		System.out.println();	

		//輸出刪除完的
		System.out.println("刪除後：");
		int di = 0;
		for(int i = 0 ; i < n ; i++)
		{
			if(i != c)
			{	
				int dj = 0;
				for(int j = 0 ; j < n ; j++)
				{
					if(j != r)
					{
						System.out.print(rm[i][j]+" ");
						vup[di][dj] = rm[i][j];
						dj+=1;	
					}
					
				}
				System.out.println();
				di+=1;
			}
		}

		
		//計算
		System.out.println("其刪除後矩陣計算後為：");
		if( n == 2 )
			System.out.print(vup[0][0]);
		
		if( n == 3 )
			System.out.print(vup[0][0]*vup[1][1]-vup[0][1]*vup[1][0]);

		if( n == 4 )
			System.out.print(vup[0][0]*vup[1][1]*vup[2][2]+vup[1][0]*vup[2][1]*vup[0][2]+vup[2][0]*vup[0][1]*vup[1][2]
					-vup[0][2]*vup[1][1]*vup[2][0]-vup[1][2]*vup[2][1]*vup[0][0]-vup[2][2]*vup[1][0]*vup[0][1]);
	}
}