/*
	資工二乙	41243202	林沛慧
	作業一：陣列排序
	功能：先輸入一個數為陣列大小，再輸入陣列內容，畫面會先輸出原始的陣列，再輸出由小到大的陣列排序。
*/ 
import java.util.Scanner;
public class classtest1
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner (System.in);
		int[] a = new int[10];
		int aa = 0;
		System.out.print("請輸入陣列大小(最多10個)：");
		int n = sc.nextInt();
		System.out.print("請輸入陣列內容：");
		for(int i = 0 ; i < n ; i++)
		{
			a[i] = sc.nextInt();
		}
		System.out.print("排序前：(");
		for(int j = 0 ; j < n ; j++)
		{
			if(j<n-1)
				System.out.print(a[j]+",");
			else
				System.out.println(a[j]+")");
		}
		for(int i = n-1 ; i > 0 ; i--)
		{
			for(int f = 1 ;f < n ; f++)
			{
				if(a[f]<a[f-1])
				{
					aa = a[f];
					a[f] = a[f-1];
					a[f-1] = aa;
				}
			}
		}
		System.out.print("排序後：(");
		for(int j = 0 ; j < n ; j++)
		{
			if(j<n-1)
				System.out.print(a[j]+",");
			else
				System.out.print(a[j]+")");
		}			
	}
}