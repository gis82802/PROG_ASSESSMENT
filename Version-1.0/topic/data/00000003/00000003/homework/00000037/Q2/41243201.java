import java.util.Scanner;

public class hw1025_3_2
{
	public static void main(String[] args)
	{
		Scanner scn=new Scanner(System.in);


		
		System.out.println("輸入2*2矩陣A內容:");
		double[][] A=new double[2][2];
		for(int i=0;i<2;i++)
			for(int j=0;j<2;j++)
				A[i][j]=scn.nextInt();



		double[][] result=invMatrix(A);
	
		System.out.println("A反矩陣為:");
		for(int i=0;i<2;i++)	
		{
			for(int j=0;j<2;j++)
			{	
				System.out.print(result[i][j]+"  ");
			}
			System.out.println();
		}

	}

	public static double[][] invMatrix(double[][] A1)
	{
		double a=A1[0][0];
		double b=A1[0][1];
		double c=A1[1][0];
		double d=A1[1][1];
			
		double dt=a*d-b*c;

		double[][] r={{d/dt,-b/dt},{-c/dt,a/dt}};
		
		return r;
	}
}