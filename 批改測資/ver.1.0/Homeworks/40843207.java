/*
Filename Function
ID number:40843207
Author:張子軒	
Ver:2020/10/5
讓使用者輸入不同原始資料型態的資料
*/
import java.util.Scanner; 
public class practice2
{
   public static void main(String args[])
   {
	Scanner scn=new Scanner(System.in);
	byte a;
	short b;
	int c;
	String d;
	long f;
	float g;
	double h;
	//System.out.print("輸入byte型態的資料：");
	a = scn.nextByte();
	//System.out.print("輸入short型態的資料：");
	b = scn.nextShort();
	//System.out.print("輸入int型態的資料：");
	c = scn.nextInt();
	//System.out.print("輸入char型態的資料：");
	d = scn.next();
	//System.out.print("輸入long型態的資料：");
	f = scn.nextLong();
	//System.out.print("輸入float型態的資料：");
	g = scn.nextFloat();
	//System.out.print("輸入double型態的資料：");
	h = scn.nextDouble();

	System.out.println(a);
	System.out.println(b);
	System.out.println(c);
	System.out.println(d);
	System.out.println(f);
	System.out.println(g);
	System.out.println(h);
   }
}