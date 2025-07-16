import java.util.Scanner;
public class app3_2
{
	public static void main(String args[])
	{
		Scanner scn=new Scanner(System.in);
		byte by;
		//System.out.print("請輸入byte形態資料:");
		by=scn.nextByte();
		System.out.println(by);
		
		
		short sh;
		//System.out.print("請輸入short形態資料:");
		sh=scn.nextShort();
		System.out.println(sh);
		
		
		int i;
		//System.out.print("請輸入int形態資料:");
		i=scn.nextInt();
		System.out.println(i);
		
		
		String str;
		char ch;
		//System.out.print("請輸入char形態資料:");
		str=scn.next();
		ch=str.charAt(0);
		System.out.println(ch);
		
		
		long lo;
		//System.out.print("請輸入long形態資料:");
		lo=scn.nextLong();
		System.out.println(lo);
		
		
		float fl;
		//System.out.print("請輸入float形態資料:");
		fl=scn.nextFloat();
		System.out.println(fl);
		
		
		double dou;
		//System.out.print("請輸入double形態資料:");
		dou=scn.nextDouble();
		System.out.println(dou);
	}
}