import java.util.Scanner;

public class Test3
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		//=========輸入
		
		System.out.printf("請輸入要點顛倒的數值x= ");
		int x = s.nextInt();

		//=========處理&輸出
		
		System.out.print(x);
		
		int temp = 0;
		while(x!=0)  //使用%10取個位數的方式 顛倒數字x
		{
			temp*=10;
			temp+=x%10;
			x/=10;
		}
		
		System.out.println("->"+temp);
		
		s.close();
	}
}