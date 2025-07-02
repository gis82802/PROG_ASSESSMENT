import java.util.Scanner;
public class tree
{
	public static void main(String[] args)
	{
		int[][] tree = new int[20][20];
		Scanner sc = new Scanner(System.in);

		//a
		System.out.println("輸入高(小於20):");
		int n = sc.nextInt();

		//上三角
		System.out.println("下三角");
		for(int i = 1; i <= n; i++)  //列
		{
			for(int j = 1; j <= i; j++)  //行
			{
				System.out.print("*");
			}
			System.out.println();
		}

		//上三角
		System.out.println("上三角");
		for(int i = n; i >= 1; i--)  //列
		{
			for(int z = 1;z <= n-i; z++)  //行
			{
				System.out.print(" ");  //上三角每行前面的空格
			}
			for(int j = 1; j <= i; j++)
			{
				
				System.out.print("*");
			}
			System.out.println();
		}

		//b
		System.out.println("輸入num(小於100000):");
		int num = sc.nextInt();
		int count = 1;
		int l = 0,w = 0,fl = 0;

		for(int i = 1; i < 100000 && fl != 1; i++)
		{
			for(int j = 1; j <= i; j++)
			{
				if(count == num)
				{
					l = i;
					w = j;
					fl = 1;
				}
				count++;
			}
		}
		System.out.println("num在下三角高="+l+" 寬="+w+" 的地方");
	}
}