////work2 2020/10/5
/*
40843217
黃雋晏
*/

import java.util.Scanner;
public class work2{
	public static void main(String args[]){
		Scanner scn = new Scanner(System.in);
		int a; String b; byte c; short d; long e; float f; double g;
		
		//System.out.print("輸入int");
		a = scn.nextInt();
		//System.out.print("輸入char");
		b = scn.next();
		//System.out.print("輸入byte");
		c = scn.nextByte();
		//System.out.print("輸入short");
		d = scn.nextShort();
		//System.out.print("輸入long");
		e = scn.nextLong();
		//System.out.print("輸入float");
		f = scn.nextFloat();
		//System.out.print("輸入double");
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