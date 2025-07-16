//資工二乙 莊宇埕 40843230
//寫程式讓使用者輸入不同原始資料型態的資料(byte, short, int, char, long, float, double)

import java.util.Scanner;

public class app2
{
	public static void main(String args[])
	{
		byte a;short b;int c;char d;long e;float f;double g;
		Scanner scn = new Scanner (System.in);

		//System.out.println("key in byte");
		a = scn.nextByte();

		//System.out.println("key in short");
		b = scn.nextShort();

		//System.out.println("key in int");
		c = scn.nextInt();

		//System.out.println("key in char");
		d = scn.next().charAt(0);

		//System.out.println("key in long");
		e = scn.nextLong();

		//System.out.println("key in float");
		f = scn.nextFloat();

		//System.out.println("key in double");
		g = scn.nextDouble();
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
        //System.out.println("byte: " + a + "short: " + b + "int: " + c + "char: " + d + "long: " + e + "float: " + f + "double: " + g);
	}
}