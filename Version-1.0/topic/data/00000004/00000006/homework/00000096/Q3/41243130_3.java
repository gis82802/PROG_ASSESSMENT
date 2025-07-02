//1011上課練習_3
import java.util.Scanner;
public class a1011_3
{
	public static void main(String arg[])
	{
		System.out.print("請輸入數字:");
		Scanner scn=new Scanner(System.in);
		int input=scn.nextInt();
		int output=0;
		while(input!=0)
		{
			output*=10;
			output+=input%10;
			input/=10;
		}
		System.out.println(output);
	}
}