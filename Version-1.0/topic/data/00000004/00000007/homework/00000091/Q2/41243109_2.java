import java.util.Scanner;
public class comp
{
	public static void main(String[] args)
	{
		int ch,x,max=0,min;
		int[] a = new int[99];
		Scanner sc = new Scanner (System.in);

		System.out.println("輸入陣列的值(輸入0為結束):");
		for(x = 0;  ; x++)
		{
			a[x] = sc.nextInt();   //輸入陣列的值
			if(a[x] == 0)  //輸入值為0停止輸入
			{
				break;
			}
		}
		for(int i = 0; i < x; i++)  //輸出輸入陣列
		{
			System.out.print(a[i] + " ");
		}
		System.out.print("\n");

		int[] ma = new int[x];
		int[] mi = new int[x];
		
		//max
		for(int i = 0; i < x; i++)
		{
			max = 0;
			for(int j = i+1; j < x; j++)
			{
				if(a[j] > max)  //比較後來的值
				{
					max = a[j];  
				}
			}
			ma[i] = max;
		}
		for(int i = 0; i < x-1; i++)
		{
			System.out.print(ma[i] + " ");
		}
		System.out.print("-1\n");
		
		//min
		for(int i = 0; i < x; i++)
		{
			min = ma[0];
			for(int j = i+1; j < x; j++)
			{
				if(a[j] < min)  //比較後來的值
				{
					min = a[j];
				}
			}
			mi[i] = min;
		}
		for(int i = 0; i < x-1; i++)
		{
			System.out.print(mi[i] + " ");
		}
		System.out.print("-1\n");
	}
}
