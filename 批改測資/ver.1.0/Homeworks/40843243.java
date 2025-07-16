/*
學號:40843243
姓名:王亭喦
作業:寫程式讓使用者輸入不同原始資料型態的資料
日期:10/5
*/
import java.util.Scanner;
public class  app3_13
{
   public static void main (String args[])
   {
	Scanner scn=new Scanner(System.in);
 	int i;
	double d;
	short s;
	byte b;
	long l;
	float f;
	String ch;	
	//System.out.println("請輸入byte:");
	b=scn.nextByte();
	System.out.println(b);
	//System.out.println("請輸入short:");
	s=scn.nextShort();
	System.out.println(s);
	//System.out.println("請輸入int:");
	i=scn.nextInt();
	System.out.println(i);
	//System.out.println("請輸入char:");
	ch=scn.next();
	System.out.println(ch.charAt(0));
	//System.out.println("請輸入long:");
	l=scn.nextLong();
	System.out.println(l);
	//System.out.println("請輸入float:");
	f=scn.nextFloat();
	System.out.println(f);
	//System.out.println("請輸入double:");
     	d=scn.nextDouble();
	System.out.println(d);			
   }			

}