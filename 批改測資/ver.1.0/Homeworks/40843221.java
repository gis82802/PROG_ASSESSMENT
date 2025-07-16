/*
名稱:輸入不同原始資料型態的資料
功能:寫程式讓使用者輸入不同原始資料型態的資料(byte, short, int, char, long, float, dobule)
班級:資工二乙
姓名:余承儒
學號:40843221
日期:2020.10.5

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
	
	//System.out.println("請輸入位元");
	a=scn.nextByte();

	//System.out.println("請輸入短整數");
	b=scn.nextShort();

	//System.out.println("請輸入整數");
	c=scn.nextInt();

	//System.out.println("請輸入字元");
	d=scn.next();
	dd=d.charAt(0);

	//System.out.println("請輸入長整數");
	e=scn.nextLong();

	//System.out.println("請輸入浮點數");
	f=scn.nextFloat();

	//System.out.println("請輸入倍經度");
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