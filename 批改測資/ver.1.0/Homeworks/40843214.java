// filename: �ϥΪ̿�J���P��l��ƫ��A�����
// auther:�G�v�a
// Date: 2020/10/5

 import java.util.Scanner;
 public class homework2
 {
    public static void main(String[] argv)
    {
        Scanner scn=new Scanner(System.in);

	byte   a;
	short  b;
	int    c;
	char   d;
	long   e;
	float  f;
	double g;
	
	//System.out.println("�п�Jbyte");
	a=scn.nextByte();
	System.out.println(a);
	//System.out.println("�п�Jshort");
	b=scn.nextShort();
	System.out.println(b);
	//System.out.println("�п�Jint");
	c=scn.nextInt();
	System.out.println(c);
	//System.out.println("�п�Jchar");
	d=scn.next().charAt(0);
	System.out.println(d);
	//System.out.println("�п�Jlong");
	e=scn.nextLong();
	System.out.println(e);
	//System.out.println("�п�Jfloat");
	f=scn.nextFloat();
	System.out.println(f);
	//System.out.println("�п�Jdouble");
	g=scn.nextDouble();
	System.out.println(g);
    }
 }
