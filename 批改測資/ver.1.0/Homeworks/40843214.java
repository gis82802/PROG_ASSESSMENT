// filename: 使用者輸入不同原始資料型態的資料
// auther:鄭宗軒
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
	
	//System.out.println("請輸入byte");
	a=scn.nextByte();
	System.out.println(a);
	//System.out.println("請輸入short");
	b=scn.nextShort();
	System.out.println(b);
	//System.out.println("請輸入int");
	c=scn.nextInt();
	System.out.println(c);
	//System.out.println("請輸入char");
	d=scn.next().charAt(0);
	System.out.println(d);
	//System.out.println("請輸入long");
	e=scn.nextLong();
	System.out.println(e);
	//System.out.println("請輸入float");
	f=scn.nextFloat();
	System.out.println(f);
	//System.out.println("請輸入double");
	g=scn.nextDouble();
	System.out.println(g);
    }
 }
