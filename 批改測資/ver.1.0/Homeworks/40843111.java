/*
FileName:hw2
Fuction:輸入資料型態數字並輸出所填寫的數字
Author:40843111 卓宏旭
DataTime:2020,10,05
*/
import java.util.Scanner;
public class hw2
{
   public static void main(String args[])
   {
       Scanner scn=new Scanner(System.in);
       byte b;
       short s;
       int i;
       String c;
       long l;
       float f;
       double d;

       //System.out.print("byte:");
       b=scn.nextByte();
       //System.out.print("short:");
       s=scn.nextShort();
       //System.out.print("int:");
       i=scn.nextInt();
       //System.out.print("char:");
       c=scn.next();
       //System.out.print("long:");
       l=scn.nextLong();
       //System.out.print("float:");
       f=scn.nextFloat();
       //System.out.print("double:");
       d=scn.nextDouble();

      System.out.println(b);
      System.out.println(s);
      System.out.println(i);
      System.out.println(c);
      System.out.println(l);
      System.out.println(f);
      System.out.println(b);
   }
}