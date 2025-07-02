import java.util.Scanner;
public class app7_H3
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		int a1,b1,a2,b2,n=0;

		System.out.printf("Enter array1 row size = ");
		a1=scanner.nextInt();
		System.out.printf("Enter array1 col size = ");
		b1=scanner.nextInt();

		System.out.printf("Enter array1 row size = ");
		a2=scanner.nextInt();
		System.out.printf("Enter array1 col size = ");
		b2=scanner.nextInt();

		if(b1 != a2)
		{
			System.out.printf("null");
		}		
		else
		{
			int[][] a=new int[a1][b1];
			int[][] b=new int[a2][b2];
			int[][] c=new int[a1][b2];
			System.out.printf("Enter %2d*%2d array1 value = ",a1,b1);
			for(int i=0;i<a1;i++)
			{
				for(int j=0;j<b1;j++)
				{
					n=scanner.nextInt();
					a[i][j]=n;
				}
			}
			System.out.printf("Enter %2d*%2d array2 value = ",a2,b2);
			for(int i=0;i<a2;i++)
			{
				for(int j=0;j<b2;j++)
				{
					n=scanner.nextInt();
					b[i][j]=n;
				}
			}
			
			for(int i=0;i<a1;i++)
			{
				for(int j=0;j<b2;j++)
				{
					for(int k=0;k<b1;k++)
					{
						c[i][j]+=a[i][k]*b[k][j];
					}
				}
			}

			System.out.printf("array1*array2 value = \n");
			for(int i=0;i<a1;i++)
			{
				for(int j=0;j<b2;j++)
				{
					System.out.printf("%4d",c[i][j]);		
				}
				System.out.print("\n");
			}
		}
	}
}