/*
File name:homework02
ID number:40843225
Name:黃彥豪
Date time:2020/10/05
Ver:1
*/
import java.util.Scanner;
public class homework2
{
   public static void main(String args[])
   {
      Scanner scn=new Scanner(System.in);
      byte a;
      short b;
      int c;
      String d;
      long e;
      float f;
      double g;

      //System.out.print("輸入byte型態資料=");
      a=scn.nextByte();

      //System.out.print("輸入short型態資料=");
      b=scn.nextShort();

      //System.out.print("輸入int型態資料=");
      c=scn.nextInt();

      //System.out.print("輸入char型態資料=");
      d=scn.next();

      //System.out.print("輸入long型態資料=");
      e=scn.nextLong();

      //System.out.print("輸入float型態資料=");
      f=scn.nextFloat();

      //System.out.print("輸入double型態資料=");
      g=scn.nextDouble();

      System.out.println(a);
      System.out.println(b);
      System.out.println(c);
      System.out.println(d);
      System.out.println(e);
      System.out.println(f);
      System.out.println(g);

   }
}