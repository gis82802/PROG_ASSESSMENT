/*
   資工二乙 41243202 林沛慧
   作業三：比大小
   功能：可讓使用者輸入3個數字，並列出三個數字的最大值、中間值及最小值
         (不可使用if...else判斷式)
*/
import java.util.Scanner;
public class hw3
{
	public static void main(String[] args)
	{
		//輸入
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入第一個數字：");
		int num1 = sc.nextInt();
		System.out.println("請輸入第二個數字：");
		int num2 = sc.nextInt();
		System.out.println("請輸入第二個數字：");
		int num3 = sc.nextInt();
		//判斷
		int max = Math.max(num1,Math.max(num2,num3));
		int min = Math.min(num1,Math.min(num2,num3));
		int mid = num1+num2+num3-max-min;
		//輸出
		System.out.println("最大值："+max+"\n中間值："+mid+"\n最小值："+min);	
	}
}
