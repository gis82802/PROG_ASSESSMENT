//File Name: hw2
//Function: ��J���A��(byte, short, int, char, long, float, dobule)
//Date: 2020/10/05
//Name: 40843136 ���ԦX
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

   //System.out.print("��Jbyte: ");
   byte1=scn.nextByte();

   //System.out.print("��Jshort: ");
   short1=scn.nextShort();

   //System.out.print("��Jint: ");
   int1=scn.nextInt();

   //System.out.print("��Jchar: ");
   str=scn.next();
   char1=str.charAt(0);

   //System.out.print("��Jlong: ");
   long1=scn.nextLong();

   //System.out.print("��Jfloat: ");
   float1=scn.nextFloat();

   //System.out.print("��Jdouble: ");
   double1=scn.nextDouble();
   }
}