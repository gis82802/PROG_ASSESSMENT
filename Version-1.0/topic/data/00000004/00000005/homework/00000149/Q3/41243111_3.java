import java.util.Scanner;

public class Test3
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);

		//========== 輸入三個數值
		
		System.out.print("請輸入第一個數:");
		int a = s.nextInt();
		System.out.print("請輸入第二個數:");
		int b = s.nextInt();
		System.out.print("請輸入第三個數:");
		int c = s.nextInt();
		
		//========== 比較及輸出
		
		int max=(a>b) ?(a>c ?a :c) :(b>c ?b :c);
		System.out.println("最大值="+max);
		
		int min=(a<b) ?(a<c ?a :c) :(b<c ?b :c);
		System.out.println("最小值="+min);
		
		int mid=(a>b) 
                ?(a<c ?a :(b>c ?b :c)) 
                :(b<c ?b :(a>c ?a :c));
		System.out.println("中間值="+mid);
		
		s.close();
	}
}