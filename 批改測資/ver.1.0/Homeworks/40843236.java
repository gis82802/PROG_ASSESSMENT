/*
Copyright:MKCQ
Filename:app1_1
Author:40843236²�l��
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
      //System.out.print("��Jchar���A");
      num = skn.next().charAt(0);
      System.out.println(num);
      //System.out.print("��Jint���A");
      num1 = skn.nextInt();
      System.out.println(num1);
      //System.out.print("��Jbyte���A");
      num2 = skn.nextByte();
      System.out.println(num2);
      //System.out.print("��Jshort���A");
      num3 = skn.nextShort();
      System.out.println(num3);
      //System.out.print("��Jlong���A");
      num4 = skn.nextLong();
      System.out.println(num4);
      //System.out.print("��Jfloat���A");
      num5 = skn.nextFloat();
      System.out.println(num5);
      //System.out.print("��Jdouble���A");
      num6 = skn.nextDouble();
      System.out.println(num6);
   }
}


