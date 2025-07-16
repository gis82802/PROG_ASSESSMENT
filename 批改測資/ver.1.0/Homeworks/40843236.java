/*
Copyright:MKCQ
Filename:app1_1
Author:40843236簡子昕
Datatime:20201005
Version:1.0.0
*/
import java.util.Scanner;
public class app1_2
{
   public static void main (String args[])
   {
      Scanner skn = new Scanner(System.in);
      char num ;
      int num1;
      byte num2;
      short num3;
      long num4;
      float num5;
      double num6;
      //System.out.print("輸入char型態");
      num = skn.next().charAt(0);
      System.out.println(num);
      //System.out.print("輸入int型態");
      num1 = skn.nextInt();
      System.out.println(num1);
      //System.out.print("輸入byte型態");
      num2 = skn.nextByte();
      System.out.println(num2);
      //System.out.print("輸入short型態");
      num3 = skn.nextShort();
      System.out.println(num3);
      //System.out.print("輸入long型態");
      num4 = skn.nextLong();
      System.out.println(num4);
      //System.out.print("輸入float型態");
      num5 = skn.nextFloat();
      System.out.println(num5);
      //System.out.print("輸入double型態");
      num6 = skn.nextDouble();
      System.out.println(num6);
   }
}


