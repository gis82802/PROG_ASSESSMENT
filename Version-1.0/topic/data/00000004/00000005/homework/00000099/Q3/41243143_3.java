import java.util.Scanner;

public class app2
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int a,b,c;
		System.out.print("輸入三數a、b、c(空格隔開)：");
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();

		System.out.println("最大值："+((((a>b)? a:b) > c)? ((a>b)? a:b):c));
		System.out.println("中間值："+((((a>b)? a:b) < c)? ((a>b)? a:b):c));
		System.out.println("最小值："+((((a<b)? a:b) < c)? ((a<b)? a:b):c));
	}
}