import java.util.Scanner;

public class type_data
{
	public static void main(String args[])
	{
		Scanner scn=new Scanner(System.in);
		byte a;
		short b;
		int c;
		char d;
		long e;
		float f;
		double g;
		
		

		//System.out.print("請輸入byte資料: ");
		a=scn.nextByte();
		System.out.println(a);
		
		//System.out.print("請輸入short資料: ");
		b=scn.nextShort();
		System.out.println(b);

		//System.out.print("請輸入int資料: ");
		c=scn.nextInt();
		System.out.println(c);

		//System.out.print("請輸入char資料: ");
		d=scn.next().charAt(0);
		System.out.println(d);

		//System.out.print("請輸入long資料: ");
		e=scn.nextLong();
		System.out.println(e);

		//System.out.print("請輸入float資料: ");
		f=scn.nextFloat();
		System.out.println(f);

		//System.out.print("請輸入double資料: ");
		g=scn.nextDouble();
		System.out.println(g);
		
	}
}