//1011上課練習_2
import java.util.Scanner;
public class a1011_2
{
	public static boolean isWellOrdered(int number) {
        int prevDigit = 10; 

        while (number > 0) {
            int currentDigit = number % 10;
            number /= 10;
            
            if (currentDigit >= prevDigit) {
                return false;
            }
            prevDigit = currentDigit;
        }
        return true;
    }
	public static void main(String arg[])
	{
		System.out.print("請輸入數字:");
		Scanner scn=new Scanner(System.in);
		int input=scn.nextInt();
		int in2=input;
		int[] temp=new int[10];
		for(int i=0;input!=0;i++)
		{
			temp[i]=input%10;
			input/=10;
		}
		boolean a=true;
		for(int i=0;i<9;i++)
		{
			if(temp[i]<=temp[i+1]&&temp[i]!=0&&temp[i+1]!=0)
			{
				a=false;
				break;
			}
		}
		if(a)
			System.out.println(in2+" is well-ordered number");
		else
			System.out.println(in2+" not well-ordered number");
		
		long out=0;
		for(int i=1;i<=100000;i++)
		{
			if(isWellOrdered(i))
				out++;
			
		}
		System.out.println("小於100000的整數有"+out+"個well-ordered number");
	}
}