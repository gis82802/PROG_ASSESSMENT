/*
班級: 資工二乙
姓名: 吳樂融
學號: 40843211
檔案名稱: app1_2
功能: 寫程式讓使用者輸入不同原始資料型態的資料(byte, short, int, char, long, float, dobule)
*/
import java.util.Scanner;
import java.util.*;
public class app1_2
{
     public static void main(String args[])             
     {
	  Scanner scn=new Scanner(System.in);
	  byte a;
	  short b;
	  int c;
	  char d;
	  long e;
	  float f;
	  double g;
	  String h;

	  //System.out.println("byte: ");
	  a=scn.nextByte();
	  //System.out.println("short: ");
	  b=scn.nextShort();
	  //System.out.println("int: ");
	  c=scn.nextInt();
	  //System.out.println("char: ");
	  h=scn.next();
	  //System.out.println("long: ");
	  e=scn.nextLong();
	  //System.out.println("float: ");
	  f=scn.nextFloat();
	  //System.out.println("dobule: ");
	  g=scn.nextDouble();
	  
	  d=h.charAt(0);

	  System.out.println(a);
	  System.out.println(b);
	  System.out.println(c);
	  System.out.println(d);
	  System.out.println(e);
	  System.out.println(f);
	  System.out.println(g);

     }
}
