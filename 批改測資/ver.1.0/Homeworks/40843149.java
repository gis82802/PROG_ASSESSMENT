import java.util.Scanner;
public class app3_2
{
	public static void main(String args[])
	{
		Scanner scn=new Scanner(System.in);
		byte by;
		//System.out.print("�п�Jbyte�κA���:");
		by=scn.nextByte();
		System.out.println(by);
		
		
		short sh;
		//System.out.print("�п�Jshort�κA���:");
		sh=scn.nextShort();
		System.out.println(sh);
		
		
		int i;
		//System.out.print("�п�Jint�κA���:");
		i=scn.nextInt();
		System.out.println(i);
		
		
		String str;
		char ch;
		//System.out.print("�п�Jchar�κA���:");
		str=scn.next();
		ch=str.charAt(0);
		System.out.println(ch);
		
		
		long lo;
		//System.out.print("�п�Jlong�κA���:");
		lo=scn.nextLong();
		System.out.println(lo);
		
		
		float fl;
		//System.out.print("�п�Jfloat�κA���:");
		fl=scn.nextFloat();
		System.out.println(fl);
		
		
		double dou;
		//System.out.print("�п�Jdouble�κA���:");
		dou=scn.nextDouble();
		System.out.println(dou);
	}
}