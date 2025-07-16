/*
file name: app2
content: 把使用者輸入的東西輸出
author name: 40843202 劉姝辰
date: 2020/10/05
version: 1.0
*/
import java.util.Scanner;
public class app2
{
   public static void main(String args[])
   {
      Scanner scn=new Scanner(System.in);

      byte byte1;
      short short1;
      int int1;
      char char1;
      long long1;
      float float1;
      double double1;
      
      //System.out.print("Please input byte: ");
      byte1=scn.nextByte();
      System.out.println(byte1);
      
      //System.out.print("Please input short: ");
      short1=scn.nextShort();
      System.out.println(short1);

      //System.out.print("Please input int: ");
      int1=scn.nextInt();
      System.out.println(int1);

      //System.out.print("Please input char: ");
      char1=scn.next().charAt(0);
      System.out.println(char1);

      //System.out.print("Please input long: ");
      long1=scn.nextLong();
      System.out.println(byte1);

      //System.out.print("Please input float: ");
      float1=scn.nextFloat();
      System.out.println(float1);

      //System.out.print("Please input double: ");
      double1=scn.nextDouble();
      System.out.println(double1);
   }
}