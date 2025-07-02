/*
	資工二乙	41243202	林沛慧
	作業二：先輸入陣列大小，再輸入陣列內容，畫面先輸出原始陣列，再輸出排序後的陣列。
	(排序方法為：第1個數會是除他以外後面最大的數，依此類推，到最後一個數則輸出-1)
*/
import java.util.Scanner;
public class classtest2
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int [] a = new int[10];
		System.out.print("請輸入陣列大小(最大是10)：");
		int n = sc.nextInt();
		System.out.print("請輸入陣列內容：");
		for(int i = 0 ; i < n ; i++)
		{
			a[i] = sc.nextInt();
		}
		System.out.print("排序前：(");
		for(int i = 0 ; i < n ; i++)
		{
			if(i < n-1)
				System.out.print(a[i]+",");
			else
				System.out.println(a[i]+")");
		}
		System.out.print("排序後：(");
		for(int i = 0 ; i < n ; i++)
		{
			int max = 0;
			for(int j = i+1 ; j < n ; j++)
			{
				if(a[j]>max)
					max = a[j];
			}
			if(i < n-1)
				System.out.print(max+",");
			else
				System.out.print("-1)");	
	}
	}
}