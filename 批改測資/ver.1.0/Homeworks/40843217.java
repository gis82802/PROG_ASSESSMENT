////work2 2020/10/5
/*
40843217
���m��
*/

import java.util.Scanner;
public class work2{
	public static void main(String args[]){
		Scanner scn = new Scanner(System.in);
		int a; String b; byte c; short d; long e; float f; double g;
		
		//System.out.print("��Jint");
		a = scn.nextInt();
		//System.out.print("��Jchar");
		b = scn.next();
		//System.out.print("��Jbyte");
		c = scn.nextByte();
		//System.out.print("��Jshort");
		d = scn.nextShort();
		//System.out.print("��Jlong");
		e = scn.nextLong();
		//System.out.print("��Jfloat");
		f = scn.nextFloat();
		//System.out.print("��Jdouble");
		g = scn.nextDouble();
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
        //System.out.print(a+"\n"+b+"\n"+c+"\n"+d+"\n"+e+"\n"+f+"\n"+g);
	}
}