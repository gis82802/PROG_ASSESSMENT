/*
Filename: ex2
Function: �����ϥΪ̿�J���P���A�����
Author: 40843114 �P����
Date:2 020/10/5
Version: 1.0
*/
import java.util.Scanner;
public class ex2
{
   public static void main(String args[])
   {
      Scanner scn = new Scanner(System.in);

      byte type_byte;
      short type_short;
      int type_int;
      String tmp;
      char type_char;
      long type_long;
      float type_float;
      double type_double;

      //System.out.print("�п�J�@��byte���A����� ");
      type_byte = scn.nextByte();

      //System.out.print("�п�J�@��short���A����� ");
      type_short = scn.nextShort();

      //System.out.print("�п�J�@��int���A����� ");
      type_int = scn.nextInt();

      //System.out.print("�п�J�@��char���A����� ");
      tmp = scn.next();
      type_char=tmp.charAt(0);

      //System.out.print("�п�J�@��long���A����� ");
      type_long = scn.nextLong();

      //System.out.print("�п�J�@��float���A����� ");
      type_float = scn.nextFloat();

      //System.out.print("�п�J�@��double���A����� ");
      type_double = scn.nextDouble();
      
      System.out.println(type_byte);
      System.out.println(type_short);
      System.out.println(type_int);
      System.out.println(type_char);
      System.out.println(type_long);
      System.out.println(type_float);
      System.out.println(type_double);

   }
}