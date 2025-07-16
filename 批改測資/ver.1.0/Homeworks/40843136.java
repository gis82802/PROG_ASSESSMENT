//File Name: hw2
//Function: 輸入型態為(byte, short, int, char, long, float, dobule)
//Date: 2020/10/05
//Name: 40843136 王晟合
//Version: 1.0

import java.util.Scanner;
public class hw2{
   public static void main(String args[]){
   Scanner scn=new Scanner(System.in);
   byte byte1;
   short short1;   
   int int1;
   char char1;
   long long1;
   float float1;
   double double1;
   String str;

   //System.out.print("輸入byte: ");
   byte1=scn.nextByte();

   //System.out.print("輸入short: ");
   short1=scn.nextShort();

   //System.out.print("輸入int: ");
   int1=scn.nextInt();

   //System.out.print("輸入char: ");
   str=scn.next();
   char1=str.charAt(0);

   //System.out.print("輸入long: ");
   long1=scn.nextLong();

   //System.out.print("輸入float: ");
   float1=scn.nextFloat();

   //System.out.print("輸入double: ");
   double1=scn.nextDouble();
   }
}