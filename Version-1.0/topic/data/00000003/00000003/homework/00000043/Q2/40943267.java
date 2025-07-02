import java.util.Scanner;
public class app7_H4
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		int a1=2,b1=2;
		double flag,n=0;

		
		double[][] a=new double[a1][b1];
		double[][] b=new double[a1][b1];
		double[][] c=new double[a1][b1];
		System.out.printf("Enter %2d*%2d array value = ",a1,b1);
		for(int i=0;i<a1;i++)
		{
			for(int j=0;j<b1;j++)
			{
				n=scanner.nextDouble();
				a[i][j]=n;
			}
		}
		
		flag=1/(a[0][0]*a[1][1]-a[0][1]*a[1][0]);
		
		b[0][0]=flag*a[1][1];

		b[0][1]=flag*(-a[0][1]);

		b[1][0]=flag*(-a[1][0]);

		b[1][1]=flag*a[0][0];
			
		for(int i=0;i<a1;i++)
		{
			for(int j=0;j<b1;j++)
			{
				for(int k=0;k<b1;k++)
				{
					c[i][j]+=a[i][k]*b[k][j];
				}
			}
		}

		System.out.printf("inverse array value = \n");
		for(int i=0;i<a1;i++)
		{
			for(int j=0;j<b1;j++)
			{
				System.out.printf("%4.1f",b[i][j]);		
			}
			System.out.print("\n");
		}

		System.out.printf("array*inverse array value = \n");
		for(int i=0;i<a1;i++)
		{
			for(int j=0;j<b1;j++)
			{
				System.out.printf("%4.1f",c[i][j]);		
			}
			System.out.print("\n");
		}
	}
}