/*
   HW2
   �g�{�����ϥΪ̿�J���P��l��ƫ��A�����(byte, short, int, char, long, float, dobule)
   40843110 �����
*/
import java.lang.Integer;
import java.util.*;
public class HW2
{
	public static void main(String args[])
	{
		Scanner scn=new Scanner(System.in);
		byte Byte0;
		short Short0;
		int Int0;
		char Char0;
		long Long0;
		float Float0;
		double Double0;

				
		//System.out.print("��Jbyte���O���=");
		Byte0=scn.nextByte();
		System.out.println(Byte0);

		//System.out.print("��Jshort���O���=");
		Short0=scn.nextShort();
		System.out.println(Short0);

		//System.out.print("��Jint���O���=");
		Int0=scn.nextInt();
		System.out.println(Int0);

		//System.out.print("��Jchar���O���=");
		Char0=scn.next().charAt(0);
		System.out.println(Char0);

		//System.out.print("��Jlong���O���=");
		Long0=scn.nextLong();
		System.out.println(Long0);

		//System.out.print("��Jfloat���O���=");
		Float0=scn.nextFloat();
		System.out.println(Float0);

		//System.out.print("��Jdouble���O���=");
		Double0=scn.nextDouble();
		System.out.println(Double0);

	}
}