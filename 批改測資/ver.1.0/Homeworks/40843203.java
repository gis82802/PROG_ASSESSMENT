/*
name:w2
anthor:劉雯瑄40843203
content:輸入各種型態都要可以輸出
date:2020/10/5
version:1.0
*/

import java.util.Scanner;
public class w2
{
   public static void main (String args[])
   {

      Scanner scn=new Scanner(System.in);

      byte b;
      short s;
      int i;
      char c;
      long l;
      float f;
      double d;

      //System.out.print("byte : ");
      b=scn.nextByte();
      System.out.println(b);

      //System.out.print("short : ");
      s=scn.nextShort();
      System.out.println(s);

      //System.out.print("int : ");
      i=scn.nextInt();
      System.out.println(i);

      //System.out.print("char : ");
      c=scn.next().charAt(0);
      System.out.println(c);

      //System.out.print("long : ");
      l=scn.nextLong();
      System.out.println(l);

      //System.out.print("float : ");
      f=scn.nextFloat();
      System.out.println(f);

      //System.out.print("double : ");
      d=scn.nextDouble();
      System.out.println(d);

      
   }

}