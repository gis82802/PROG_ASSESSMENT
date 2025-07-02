import java.util.Scanner;
public class hw11025
{

	public static void main(String arg[])
	{
		Scanner sc = new Scanner(System.in);
		int n,m;
		int a[][];
		int b[][];
		System.out.println("輸入第一個矩陣的大小m*n");
		System.out.print("m = ");
		m=sc.nextInt();
		System.out.print("n = ");
		n=sc.nextInt();
		a =new int[m][n];
		System.out.println("輸入第一個矩陣的內容");
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				a[i][j]=sc.nextInt();
			}
		}
		System.out.println("輸入第二個矩陣的大小m*n");
		System.out.print("m = ");
		m=sc.nextInt();
		System.out.print("n = ");
		n=sc.nextInt();
		b =new int[m][n];
		System.out.println("輸入第一個矩陣的內容");
		for(int i=0;i<b.length;i++)
		{
			for(int j=0;j<b[i].length;j++)
			{
				b[i][j]=sc.nextInt();
			}
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
}