import java.util.Scanner;
public class arr
{
	public static void main(String[] args)
	{
		int ch,x;
		int[] a = new int[99];
		Scanner sc = new Scanner (System.in);

		System.out.println("輸入陣列的值(輸入0為結束):");
		for(x = 0;  ; x++)
		{
			a[x] = sc.nextInt();  //輸入陣列的值
			if(a[x] == 0) //輸入0就停止輸入
			{
				break;
			}
		}
		for(int i = 0; i < x; i++)  //輸出輸入陣列
		{
			System.out.print(a[i] + " ");
		}
		System.out.print("\n");
		for(int i = 0; i < x; i++)
		{
			for(int j = i+1; j < x; j++)
			{
				if(a[i] > a[j])  //由小到大排序
				{
					ch = a[i];
					a[i] = a[j];
					a[j] = ch;
				}
			}
		}
		for(int i = 0; i < x; i++)
		{
			System.out.print(a[i] + " ");
		}
	}
}
