/*
�W��:��J���P��l��ƫ��A�����
�\��:�g�{�����ϥΪ̿�J���P��l��ƫ��A�����(byte, short, int, char, long, float, dobule)
�Z��:��u�G�A
�m�W:�E�Ӿ�
�Ǹ�:40843221
���:2020.10.5

*/

import java .util.Scanner;
public class HW2
{
    public static void main(String args[])
    {
	Scanner scn=new Scanner(System.in);
	byte a;
	short b;
	int c;
	String d;
	char dd;
	long e;
	float f;
	double g;
	
	//System.out.println("�п�J�줸");
	a=scn.nextByte();

	//System.out.println("�п�J�u���");
	b=scn.nextShort();

	//System.out.println("�п�J���");
	c=scn.nextInt();

	//System.out.println("�п�J�r��");
	d=scn.next();
	dd=d.charAt(0);

	//System.out.println("�п�J�����");
	e=scn.nextLong();

	//System.out.println("�п�J�B�I��");
	f=scn.nextFloat();

	//System.out.println("�п�J���g��");
	g=scn.nextDouble();


	System.out.println(a);
	System.out.println(b);
	System.out.println(c);
	System.out.println(d);
	System.out.println(e);
	System.out.println(f);
	System.out.println(g);

    }
}