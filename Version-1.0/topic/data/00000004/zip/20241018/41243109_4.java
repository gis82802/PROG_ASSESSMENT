import java.util.Scanner;
public class matrix
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		//a
		System.out.println("輸入n(小於等於4):");
		int n = sc.nextInt();

		int[][] arr = new int[4][4];
		System.out.println("輸入矩陣內的值(小於20):");
		for(int x=0;x<n;x++)
		{
			for(int y=0;y<n;y++)
			{
				arr[x][y] = sc.nextInt();
			}
		}

		for(int x=0;x<n;x++)
		{
			for(int y=0;y<n;y++)
			{
				System.out.print(arr[x][y]);
			}
			System.out.println();
		}

		//b
		System.out.print("輸入i列跟j行");
		int i = sc.nextInt();
		int j = sc.nextInt();
		int total = 0;

		if(n == 3)
		{
			
			total = arr[0][0] * arr[1][1] * arr[2][2]
				+ arr[0][1] * arr[1][2] * arr[2][0]
				+ arr[0][2] * arr[1][0] * arr[2][1]
				- arr[0][2] * arr[1][1] * arr[2][0]
				- arr[0][1] * arr[1][0] * arr[2][2]
				- arr[0][0] * arr[1][2] * arr[2][1];	
		}
		else if(n == 4)
		{
			total = arr[0][0] * arr[1][1] * arr[2][2] * arr[3][3]
				+ arr[0][1] * arr[1][2] * arr[2][3] * arr[3][0]
				+ arr[0][2] * arr[1][3] * arr[2][0] * arr[3][1]
				+ arr[0][3] * arr[1][0] * arr[2][1] * arr[3][2]
				- arr[0][3] * arr[1][2] * arr[2][1] * arr[3][0]
				- arr[0][2] * arr[1][1] * arr[2][0] * arr[3][3]
				- arr[0][1] * arr[1][0] * arr[2][3] * arr[3][2]
				- arr[0][0] * arr[1][3] * arr[2][2] * arr[3][1];
		}

		for(int x=0;x<n;x++)
		{
			if(x==i-1)
			{
				continue;
			}
			for(int y=0;y<n;y++)
			{
				if(y==j-1)
				{
					continue;
				}
				else
				{
					System.out.print(arr[x][y]);
				}
			}
			System.out.println();
		}
		System.out.println("total = "+total);	
	}
}
