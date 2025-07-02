import java.util.Scanner;
public class hw11025b
{

	public static void main(String arg[])
	{
		Scanner sc = new Scanner(System.in);
		int n,m;
		int a[][];
   		a=new int[2][2];
		int b[][];
		System.out.println("輸入一個2*2的矩陣");
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				a[i][j]=sc.nextInt();
			}
		}
		b=invMatrix(a);
		for(int i=0;i<b.length;i++)
		{
			for(int j=0;j<b[0].length;j++)
			System.out.print(b[i][j]+" ");
		System.out.println();
		}
		int c[][];
		c=MatMultiply(a,b);
		for(int i=0;i<c.length;i++)
		{
			for(int j=0;j<c[0].length;j++)
			System.out.print(c[i][j]+" ");
		System.out.println();
		}
	}

	public static int[][] MatMultiply(int arr[][],int arr1[][])
	{
		int c[][];
		if(arr[0].length!=arr1.length)
			return null;
   		else
		{
			c = new int [arr.length][arr1[0].length];
			for(int i=0;i<arr.length;i++)
				for(int j=0;j<arr1[0].length;j++)
					for(int k=0;k<arr[0].length;k++)
					c[i][j] += arr[i][k]*arr1[k][j];
			return c;
		}
	}
	public static int[][] invMatrix(int arr[][])
	{	
		int b[][];
		b = new int[2][2];
		for(int i=0;i<arr.length;i++)
			for(int j=0;j<arr[0].length;j++)
			b[i][j]=arr[i][j];
		int x;
		if(b[0][0]*b[1][1]-b[0][1]*b[1][0]!=0)
		{
		 x= b[0][0];b[0][0]= b[1][1];b[1][1]=x;
		 b[0][1]=-b[0][1];b[1][0]=-b[1][0];
		return b;
		}
		else 
		return null;
	}
}