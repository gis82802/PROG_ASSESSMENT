import java.util.Scanner;

public class hw1018_2
{
	public static void main(String args[])
	{
		Scanner scn=new Scanner(System.in);
		
		System.out.printf("輸入陣列長度:");
		int length=scn.nextInt();

		int[] a=new int [length];
		System.out.printf("輸入陣列內容:");
		for(int i=0;i<length;i++)
		{
			a[i]=scn.nextInt();
		}

		int a1[]=a;		

		System.out.println("排序前的陣列:");
		for(int i=0;i<length;i++)
		{
			System.out.printf("%d ",a[i]);
		}
		System.out.println();		

		int n=length;
		int[] maxa=new int[n];
		
		for(int i=0;i<n;i++)
		{
			if(i<n-1)		
			{
				int max=a[i+1];
				for (int j = i + 2; j < n; j++) 
				{
                    			if (a[j] > max)
					{
                       				 max = a[j];
					}
				}
				maxa[i]=max;
			}
			else
			{
				maxa[i]=-1;
			}
		}

		System.out.println("最大值陣列:");
		for(int j=0;j<length;j++)
		{
			System.out.printf("%d ",maxa[j]);
		}

		System.out.println();


		int n1=length;
		int[] mina=new int[n1];
		
		for(int i=0;i<n;i++)
		{
			if(i<n-1)		
			{
				int min=a1[i+1];
				for (int j = i + 2; j < n; j++) 
				{
                    			if (a1[j] < min)
					{
                       				 min = a1[j];
					}
				}
				mina[i]=min;
			}
			else
			{
				mina[i]=-1;
			}
		}

		System.out.println("最小值陣列:");
		for(int j=0;j<length;j++)
		{
			System.out.printf("%d ",mina[j]);
		}

	}
}

