/*
FileName:hw2
Fuction:��J���P��l��ƫ��A�����
Author:40843152 ���v��
DataTime:2020,10,05
*/

import java.util.Scanner;
public class hw2
{
   public static void main(String args[])
   {
      Scanner scn=new Scanner(System.in);
      byte btx;
      short shx;
      int ix;
      char chx;
      long Lnx;
      float fLx;
      double dux;
      String temp;

      //System.out.print("�п�Jbyte����:");
      btx=scn.nextByte();

      //System.out.print("�п�Jshort����:");
      shx=scn.nextShort();

      //System.out.print("�п�Jint����:");
      ix=scn.nextInt();

      //System.out.print("�п�Jchar����:");
      temp=scn.next();
      chx=temp.charAt(0);

      //System.out.print("�п�Jlong����:");
      Lnx=scn.nextLong();

      //System.out.print("�п�Jfloat����:");
      fLx=scn.nextFloat();

      //System.out.print("�п�Jdouble����:");
      dux=scn.nextDouble();
      
      System.out.println(btx);
      System.out.println(shx);
      System.out.println(ix);
      System.out.println(chx);
      System.out.println(Lnx);
      System.out.println(fLx);
      System.out.println(dux);


   }
}