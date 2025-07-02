//1018上課練習_1
import java.util.Scanner;
public class a1018_1
{
	public static void main(String arg[])
	{
		Scanner scn=new Scanner(System.in);
		System.out.print("請輸入陣列大小:");
		int input=scn.nextInt();
		int arr[]=new int[input],arr1[]=new int[input];
		for(int i=0;i<input;i++)
		{
			arr[i]=scn.nextInt();
		}
		System.out.print("原始陣列為:");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
		for(int i=0;i<arr.length;i++)
			for(int j=0;j<arr.length-1;j++)
				if(arr[j]>arr[j+1])
				{
					int temp;
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
		System.out.print("排序後陣列為:");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}