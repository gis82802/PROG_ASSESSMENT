/*
Filename: ex2
Function: 能讓使用者輸入不同型態的資料
Author: 40843114 周昀陞
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

      //System.out.print("請輸入一個byte型態的資料 ");
      type_byte = scn.nextByte();

      //System.out.print("請輸入一個short型態的資料 ");
      type_short = scn.nextShort();

      //System.out.print("請輸入一個int型態的資料 ");
      type_int = scn.nextInt();

      //System.out.print("請輸入一個char型態的資料 ");
      tmp = scn.next();
      type_char=tmp.charAt(0);

      //System.out.print("請輸入一個long型態的資料 ");
      type_long = scn.nextLong();

      //System.out.print("請輸入一個float型態的資料 ");
      type_float = scn.nextFloat();

      //System.out.print("請輸入一個double型態的資料 ");
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