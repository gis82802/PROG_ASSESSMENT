import java.util.Scanner;
public class Comparison
{
	public static void main(String args[])
	{
		Scanner scn = new Scanner(System.in);
		int a,b,c,mid,max,min;
		System.out.println("輸入三個不一樣的數字:");
		a=scn.nextInt();
		b=scn.nextInt();
		c=scn.nextInt();

		max = Math.max(a,Math.max(b,c));
		min = Math.min(a,Math.min(b,c));
		mid = a+b+c-min-max;
		
		System.out.println("max:"+max);
		System.out.println("mid:"+mid);
		System.out.println("min:"+min);
	}
}