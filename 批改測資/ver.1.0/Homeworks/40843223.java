/*
filename:ScannerPractice
function:輸入練習
author:蔡震霖
date:2020/10/05
version:1.0
*/

import java.util.Scanner;
public class ScannerPractice {
    public static void main(String args[]) {
	Scanner scan = new Scanner(System.in);
	byte b;
	//System.out.println("輸入(byte)型態資料:");
	b = scan.nextByte();

	short s;
	//System.out.println("輸入(short)型態資料:");
	s = scan.nextShort();

	int i;
	//System.out.println("輸入(int)型態資料:");
	i = scan.nextInt();

	char c;
	//System.out.println("輸入(char)型態資料:");
	c = scan.next().charAt(0);

	long l;
	//System.out.println("輸入(long)型態資料:");
	l = scan.nextLong();

	float f;
	//System.out.println("輸入(float)型態資料:");
	f = scan.nextFloat();

	double d;
	//System.out.println("輸入(double)型態資料:");
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