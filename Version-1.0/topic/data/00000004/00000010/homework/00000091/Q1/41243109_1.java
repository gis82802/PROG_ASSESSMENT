import java.util.Scanner;
public class MathMultiple
{
	public static void main(String[] args)
	{
		//a
		Scanner sc = new Scanner(System.in);
		int fl=0;
		
		System.out.println("輸入a[a1][a2]");
		System.out.print("a1 = ");
		int a1 = sc.nextInt();
		System.out.print("a2 = ");
		int a2 = sc.nextInt();
		System.out.println("輸入b[b1][b2]");
		System.out.print("b1 = ");
		int b1 = sc.nextInt();
		System.out.print("b2 = ");
		int b2 = sc.nextInt();

		double a[][] = new double[a1][a2];
		double b[][] = new double[b1][b2];
		double fin[][] = new double[a1][b2];

		System.out.println("輸入a陣列:");
		for(int i = 0; i < a1; i++)
		{
			for(int j = 0; j < a2; j++)
			{
				a[i][j] = sc.nextDouble();
			}

		}

		System.out.println("輸入b陣列:");
		for(int i = 0; i < b1; i++)
		{
			for(int j = 0; j < b2; j++)
			{
				b[i][j] = sc.nextDouble();
			}

		}

		if(a2!=b1)
			fl=1;
		else
			fin = multiple(a, b, a1, a2, b1, b2);
		
		if( fl==1 )
			System.out.println("null");
		else if( fl==0 )
		{
			System.out.println("a陣列:");
			for(int i = 0; i < a1; i++)
			{
				for(int j = 0; j < a2; j++)
				{
					System.out.print(a[i][j]+" ");
				}
				System.out.println(" ");
			}

			System.out.println("b陣列:");
			for(int i = 0; i < b1; i++)
			{
				for(int j = 0; j < b2; j++)
				{
					System.out.print(b[i][j]+" ");
				}
				System.out.println(" ");
			}

			System.out.println("a X b:");
			for(int i = 0; i < a1; i++)
			{
				for(int j = 0; j < b2; j++)
				{
					System.out.print(fin[i][j]+" ");
				}
				System.out.println(" ");
			}
		}

		//b
		System.out.println("輸入2x2矩陣");
		double A[][] = new double[2][2];
		double A1[][] = new double[2][2];
		double I[][] = new double[2][2]; 
		for(int i = 0;i < 2; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				A[i][j] = sc.nextDouble();
			}
		}
		double m = A[0][0] * A[1][1] - A[0][1] * A[1][0];
		A1[0][0] = (1.0 / m ) * A[1][1];
		A1[0][1] = -(1.0 / m ) * A[0][1];
		A1[1][0] = -(1.0 / m ) * A[1][0];
		A1[1][1] = (1.0 / m ) * A[0][0];
	
		if( m != 0 )
		{
			I = multiple(A, A1, 2, 2, 2, 2);
			
			System.out.println("反矩陣:");
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < 2; j++)
				{
					System.out.print(A1[i][j]+" ");
				}
				System.out.println(" ");
			}
			System.out.println("單位矩陣:");
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < 2; j++)
				{
					System.out.print(I[i][j]+" ");
				}
				System.out.println(" ");
			}
			
		}
		else
			System.out.print("null");
	}
	
	public static double[][] multiple(double a[][], double b[][], int a1, int a2, int b1, int b2)
	{
		double f[][] = new double[a1][b2];
		for(int i = 0; i < a1; i++)
		{
			for(int j = 0; j < b2; j++)
			{	
				double sum = 0;
				for(int k = 0; k < a2; k++)
				{
					sum += a[i][k] * b[k][j];
				}
				f[i][j] = sum;
			}
			 
		}
		return f;
	}
}