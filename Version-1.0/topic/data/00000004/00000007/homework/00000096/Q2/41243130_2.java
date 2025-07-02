//1018上課練習_2
import java.util.Scanner;
public class a1018_2
{
	public static int max(int arr[],int n)
	{
		int max=-1;
		for(int i=n+1;i<arr.length;i++)
			if(arr[i]>max)
				max=arr[i];
		return max;
	}
	public static int min(int arr[],int n)
	{
		int min=arr[0];
		for(int i=n+1;i<arr.length;i++)
		{	
			if(arr[i]<min)
				min=arr[i];
		}
		if(n+1==arr.length)
			{
				min=-1;
			}
		return min;
	}
	public static void main(String arg[])
	{
		Scanner scn=new Scanner(System.in);
		System.out.print("請輸入陣列大小:");
		int input=scn.nextInt();
		int arr[]=new int[input],arr1[]=new int[input];
		System.out.print("輸入請原始陣列:");
		for(int i=0;i<input;i++)
		{
			arr[i]=scn.nextInt();
		}
		System.out.println("原始陣列");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
		System.out.println("已最大值取代後的陣列");
		for(int i=0;i<arr.length;i++)
			System.out.print(max(arr,i)+" ");
		System.out.println();
		System.out.println("已最小值取代後的陣列");
		for(int i=0;i<arr.length;i++)
			System.out.print(min(arr,i)+" ");
		System.out.println();
	}
}