import java.util.Scanner;//20201005 , 40843135 , ���a�e ,��J���P��l��ƫ��A�����
public class Oct1005_2
{
	public static void main(String args[])
	{
	   Scanner sca = new Scanner(System.in);
	   byte a;
	   short b;
	   int c;
	   String str;
	   char d;
 	   long e;
	   float f;
	   double g;
	   int age;
	   //System.out.println("��Jbyte�G" );
	   a = sca.nextByte();
	   System.out.println(a);

	   //System.out.println("��Jshort�G" );
	   b = sca.nextShort();
	   System.out.println(b);

	   //System.out.println("��Jint�G" );
	   c = sca.nextInt();
	   System.out.println(c);

	   //System.out.println("��Jchar�G" );
	   str = sca.next();
	   d=str.charAt(0);
	   System.out.println(d);

	   //System.out.println("��Jlong�G" );
	   e = sca.nextLong();
	   System.out.println(e);

	   //System.out.println("��Jfloat�G" );
	   f = sca.nextFloat();
	   System.out.println(f);

	   //System.out.println("��Jdouble�G" );
	   g = sca.nextDouble();
	   System.out.println(g);
	}
}