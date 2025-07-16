/*
Filename:InputType
Author:40843212 高學安
Date:20201005
Function:讓使用者輸入各型態資料
Version:1.0
*/

import java.util.Scanner;
public class InputType
{
   public static void main(String args[]){
      Scanner scn = new Scanner(System.in);
      byte b;
      short s;
      int i;
      char c;
      long l;
      float f;
      double d;

      //System.out.println("Input int:");
      i = scn.nextInt();
      System.out.println(i);

      //System.out.println("Input byte:");
      b = scn.nextByte();
      System.out.println(b);

      //System.out.println("Input short:");
      s = scn.nextShort();
      System.out.println(s);

      //System.out.println("Input char:");
      c = scn.next().charAt(0);
      System.out.println(c);

      //System.out.println("Input long:");
      l = scn.nextLong();
      System.out.println(l);

      //System.out.println("Input float:");
      f = scn.nextFloat();
      System.out.println(f);

      //System.out.println("Input double:");
      d = scn.nextDouble();
      System.out.println(d);
      }
}