/*
File name:homework02
ID number:40843225
Name:���ۻ�
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

      //System.out.print("��Jbyte���A���=");
      a=scn.nextByte();

      //System.out.print("��Jshort���A���=");
      b=scn.nextShort();

      //System.out.print("��Jint���A���=");
      c=scn.nextInt();

      //System.out.print("��Jchar���A���=");
      d=scn.next();

      //System.out.print("��Jlong���A���=");
      e=scn.nextLong();

      //System.out.print("��Jfloat���A���=");
      f=scn.nextFloat();

      //System.out.print("��Jdouble���A���=");
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