/*
�Z��:��u�G�A
�m�W:�i����
�Ǹ�:40843218
���:10/5
�ɮצW��:app2
�\��:�g�{�����ϥΪ̿�J���P��l��ƫ��A�����(byte, short, int, char, long, float, dobule)
*/


import java.util.Scanner;

public class app2
{
	public static void main(String args[])
	{
		byte byte1;
		short short1;
		int int1;
		char char1;
		long long1;
		float float1;
		double double1; 
		Scanner scn =new Scanner(System.in);
	
		//System.out.println("�п�Jbyte");
		byte1 = scn.nextByte();
		
		//System.out.println("�п�Jshort");
		short1 = scn.nextShort();

		//System.out.println("�п�Jint");
		int1 = scn.nextInt();

		//System.out.println("�п�Jchar");
		char1 = scn.next().charAt(0);

		//System.out.println("�п�Jlong");
		long1 = scn.nextLong();

		//System.out.println("�п�Jfloat");
		float1 = scn.nextFloat();

		//System.out.println("�п�Jdouble");
		double1 = scn.nextDouble();

		System.out.println(byte1);
		System.out.println(short1);
		System.out.println(int1);
		System.out.println(char1);
		System.out.println(long1);
		System.out.println(float1);
		System.out.println(double1);
        //System.out.println(byte1 + " " +  short1 + " " + int1 + " " + char1 + " "+ long1 + " " + float1 + " " + double1 );

	}

}