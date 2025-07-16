
/*
	Filename:Work2
	Function:InputVariousData
	Author:JiangChiYour40843238
	Datetime:20201005
	Version:1.0.0
*/
import java.util.Scanner;
public class Work2{
	
	public static void main(String[] arg){
		Scanner scn = new Scanner(System.in);
		byte b;
		int i;
		short s;
		char c;
		long l;
		float f;
		double d;
		
		//System.out.print("Pls Input a Interger:");
		i=scn.nextInt();
		System.out.println(i);

		//System.out.print("Pls Input a Byte:");
		b=scn.nextByte();
		System.out.println(b);

		//System.out.print("Pls Input a Short:");
		s=scn.nextShort();
		System.out.println(s);

		//System.out.print("Pls Input a Char:");
		c=scn.next().charAt(0);
		System.out.println(c);

		//System.out.print("Pls Input a Long:");
		l=scn.nextLong();
		System.out.println(l);

		//System.out.print("Pls Input a Float:");
		f=scn.nextFloat();
		System.out.println(f);

		//System.out.print("Pls Input a Double:");
		d=scn.nextDouble();		
		System.out.println(d);
	}
}