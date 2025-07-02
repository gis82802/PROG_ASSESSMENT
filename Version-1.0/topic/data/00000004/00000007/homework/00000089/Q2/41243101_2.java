import java.util.Scanner;
public class MaxMin
{
	public static void main(String args[])
	{
		int size,i,j,max=0,min=0;
		System.out.print("請輸入陣列大小:");
		Scanner scn=new Scanner(System.in);
		size=scn.nextInt();
		int a[]=new int [size]; 
		int MAX[]=new int [size];
		int MIN[]=new int [size];
		System.out.print("請輸入"+size+"個數值:");
		for(i=0;i<size;i++)
		{
			a[i]=scn.nextInt();
		}
		for(i=0;i<a.length-1;i++)	//以最大值取代
		{
			max=a[i+1];
			for(j=i+1;j<a.length;j++)
			{
				if(a[j]>max)
				{
					max=a[j];
				}
			}
			MAX[i]=max;
		}
		MAX[MAX.length-1]=-1;	

		for(i=0;i<a.length-1;i++)	//以最小值取代	
		{
			min=a[i+1];
			for(j=i+1;j<a.length;j++)
			{
				if(a[j]<min)
				{
					min=a[j];
				}
			}
			MIN[i]=min;
		}
		MIN[MIN.length-1]=-1;

		System.out.print("a陣列中每個元素被自己以後(不含自己)的最大值和最小值取代後的結果: ");
		System.out.print("[");
		for(i=0;i<MAX.length;i++)
		{
			if(i==MAX.length-1)
			{
				System.out.print(MAX[i]+"],");
			}
			else
				System.out.print(MAX[i]+",");
		}
			
		System.out.print("[");
		for(i=0;i<MIN.length;i++)
		{
			if(i==a.length-1)
			{
				System.out.println(MIN[i]+"]");
			}
			else
				System.out.print(MIN[i]+",");
		}
	}
}