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
		
		

		//System.out.print("�п�Jbyte���: ");
		a=scn.nextByte();
		System.out.println(a);
		
		//System.out.print("�п�Jshort���: ");
		b=scn.nextShort();
		System.out.println(b);

		//System.out.print("�п�Jint���: ");
		c=scn.nextInt();
		System.out.println(c);

		//System.out.print("�п�Jchar���: ");
		d=scn.next().charAt(0);
		System.out.println(d);

		//System.out.print("�п�Jlong���: ");
		e=scn.nextLong();
		System.out.println(e);

		//System.out.print("�п�Jfloat���: ");
		f=scn.nextFloat();
		System.out.println(f);

		//System.out.print("�п�Jdouble���: ");
		g=scn.nextDouble();
		System.out.println(g);
		
	}
}