/*
filename:ScannerPractice
function:��J�m��
author:���_�M
date:2020/10/05
version:1.0
*/

import java.util.Scanner;
public class ScannerPractice {
    public static void main(String args[]) {
	Scanner scan = new Scanner(System.in);
	byte b;
	//System.out.println("��J(byte)���A���:");
	b = scan.nextByte();

	short s;
	//System.out.println("��J(short)���A���:");
	s = scan.nextShort();

	int i;
	//System.out.println("��J(int)���A���:");
	i = scan.nextInt();

	char c;
	//System.out.println("��J(char)���A���:");
	c = scan.next().charAt(0);

	long l;
	//System.out.println("��J(long)���A���:");
	l = scan.nextLong();

	float f;
	//System.out.println("��J(float)���A���:");
	f = scan.nextFloat();

	double d;
	//System.out.println("��J(double)���A���:");
	d = scan.nextDouble();
	System.out.println(b);
	System.out.println(s);
	System.out.println(i);
	System.out.println(c);
	System.out.println(l);
	System.out.println(f);
	System.out.println(d);
    }
}