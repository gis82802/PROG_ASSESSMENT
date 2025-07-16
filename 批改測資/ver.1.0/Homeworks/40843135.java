import java.util.Scanner;//20201005 , 40843135 , 陳冠呈 ,輸入不同原始資料型態的資料
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
	   //System.out.println("輸入byte：" );
	   a = sca.nextByte();
	   System.out.println(a);

	   //System.out.println("輸入short：" );
	   b = sca.nextShort();
	   System.out.println(b);

	   //System.out.println("輸入int：" );
	   c = sca.nextInt();
	   System.out.println(c);

	   //System.out.println("輸入char：" );
	   str = sca.next();
	   d=str.charAt(0);
	   System.out.println(d);

	   //System.out.println("輸入long：" );
	   e = sca.nextLong();
	   System.out.println(e);

	   //System.out.println("輸入float：" );
	   f = sca.nextFloat();
	   System.out.println(f);

	   //System.out.println("輸入double：" );
	   g = sca.nextDouble();
	   System.out.println(g);
	}
}