/*
Filename Function
ID number:40843207
Author:�i�l�a	
Ver:2020/10/5
���ϥΪ̿�J���P��l��ƫ��A�����
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
	//System.out.print("��Jbyte���A����ơG");
	a = scn.nextByte();
	//System.out.print("��Jshort���A����ơG");
	b = scn.nextShort();
	//System.out.print("��Jint���A����ơG");
	c = scn.nextInt();
	//System.out.print("��Jchar���A����ơG");
	d = scn.next();
	//System.out.print("��Jlong���A����ơG");
	f = scn.nextLong();
	//System.out.print("��Jfloat���A����ơG");
	g = scn.nextFloat();
	//System.out.print("��Jdouble���A����ơG");
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