/*
寫程式讓使用者輸入不同原始資料型態的資料(byte, short, int, char, long, float, dobule)

data: 2020/10/05
name: 40843101 盧德霙
*/

import java.util.Scanner;

public class hw2{
   public static void main(String args[]){
      Scanner scn=new Scanner(System.in);

      Byte b;
      //System.out.print("input, byte : ");
      b = scn.nextByte();
      System.out.println(b);

      short s;
      //System.out.print("input, short : ");
      s = scn.nextShort();
      System.out.println(s);

      int i;
      //System.out.print("input, int : ");
      i = scn.nextInt();
      System.out.println(i);

      String str;
      char c;
      //System.out.print("input, char : ");
      str = scn.next();
      c = str.charAt(0);
      System.out.println(c);

      long l;
      //System.out.print("input, long : ");
      l = scn.nextLong();
      System.out.println(l);

      float f;
      //System.out.print("input, float : ");
      f = scn.nextInt();
      System.out.println(f);

      double d;
      //System.out.print("input, double : ");
      d = scn.nextInt();
      System.out.println(d);
   }
}