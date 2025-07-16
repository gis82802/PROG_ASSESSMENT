/*
number:40243214
name:wenyenlin
*/
import java.lang.Integer;
import java.util.*;
public class dataType
{
	public static void main(String arg[])
	{
		Scanner scn = new Scanner(System.in);
		byte byte1;
		short short1;
		int int1;
		char char1;
		long long1;
		float float1;
		double double1;
		
		//System.out.println("please input byte data");
		byte1 = scn.nextByte();
		System.out.println(byte1);		

		//System.out.println("please input short data");
		short1 = scn.nextShort();
		System.out.println(short1);	

		//System.out.println("please input int data");
		int1 = scn.nextInt();
		System.out.println(int1);	

		//System.out.println("please input char data");
		char1 = scn.next().charAt(0);
		System.out.println(char1);	

		//System.out.println("please input long data");
		long1 = scn.nextLong();
		System.out.println(long1);

		//System.out.println("please input float data");
		float1 = scn.nextFloat();
		System.out.println(float1);

		//System.out.println("please input double data");
		double1 = scn.nextDouble();
		System.out.println(double1);
	}
}