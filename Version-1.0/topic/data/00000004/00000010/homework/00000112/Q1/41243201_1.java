import java.util.Scanner;

public class hw1025_3_1
{
	public static void main(String[] args)
	{
		Scanner scn=new Scanner(System.in);

		System.out.print("輸入矩陣A的行數、列數:");
		int rowA=scn.nextInt();
		int colA=scn.nextInt();
		int[][] A=new int[rowA][colA];
		
		System.out.println("輸入矩陣A內容:");
		for(int i=0;i<rowA;i++)
			for(int j=0;j<colA;j++)
				A[i][j]=scn.nextInt();

		System.out.print("輸入矩陣B的行數、列數:");
		int rowB=scn.nextInt();
		int colB=scn.nextInt();
		int[][] B=new int[rowB][colB];
		
		System.out.println("輸入矩陣B內容:");
		for(int i=0;i<rowB;i++)
			for(int j=0;j<colB;j++)
				B[i][j]=scn.nextInt();

		int[][] result=MatMultiply(A,B);

		if(result==null)
			System.out.println("null");
		else
		{
			System.out.println("相乘結果:");
			for(int i=0;i<rowA;i++)	
			{
				for(int j=0;j<colB;j++)
				{	
					System.out.print(result[i][j]+" ");
				}
				System.out.println();
			}
		}
	}

	public static int[][] MatMultiply(int[][] a,int[][] b)
	{
		if(a[0].length!=b.length)
			return null;

		int rowa=a.length;
		int cola=a[0].length;
		int colb=b[0].length;

		int[][] r=new int[rowa][colb];

		for(int i=0;i<rowa;i++)
		{
			for(int j=0;j<colb;j++)
			{
				for(int k=0;k<cola;k++)
					r[i][j]+=(a[i][k]*b[k][j]);
			}
		}
		return r;
	}
}