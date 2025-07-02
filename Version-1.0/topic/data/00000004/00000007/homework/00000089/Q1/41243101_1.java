import java.util.Scanner;
public class sort
{
	public static void main(String args[])
	{
		int size,i,j,n;
		System.out.print("請輸入陣列大小:");
		Scanner scn=new Scanner(System.in);
		size=scn.nextInt();
		int a[]=new int [size]; 
		System.out.print("請輸入"+size+"個數值:");
		for(i=0;i<size;i++)
		{
			a[i]=scn.nextInt();
		}
		System.out.print("排序前: ");
		for(i=0;i<size;i++)
		{
			if(i==a.length-1)
			{
				System.out.println(a[i]);
			}
			else
				System.out.print(a[i]+" ");
		}

		for(i=0;i<a.length;i++)
		{
			for(j=i;j<a.length;j++)
			{
				if(a[i]>a[j])
				{
					n=a[i];
					a[i]=a[j];
					a[j]=n;
				}
			}
		}		
		System.out.print("a陣列中數值小到大排序後的結果: ");
		for(i=0;i<a.length;i++)
		{
			if(i==a.length-1)
			{
				System.out.println(a[i]);
			}
			else
				System.out.print(a[i]+" ");
		}
	}
}