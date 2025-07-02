import java.util.Scanner;

public class hw1018_1
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
		
		System.out.println("排序前的陣列:");
		for(int i=0;i<length;i++)
		{
			System.out.printf("%d ",a[i]);
		}
		System.out.println();		

		
		for(int i=0;i<length-1;i++)
		{
			for(int j=0;j<length-1;j++)
			{
				if(a[j]>a[j+1])
				{
					int t=a[j];
					a[j]=a[j+1];
					a[j+1]=t;
				}
			}
		}
		
		System.out.println("排序後陣列:");
		for(int j=0;j<length;j++)
		{
			System.out.printf("%d ",a[j]);
		}
	}
}