/*
FileName:hw2
Fuction:輸入不同原始資料型態的資料
Author:40843152 陳治宏
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

      //System.out.print("請輸入byte的值:");
      btx=scn.nextByte();

      //System.out.print("請輸入short的值:");
      shx=scn.nextShort();

      //System.out.print("請輸入int的值:");
      ix=scn.nextInt();

      //System.out.print("請輸入char的值:");
      temp=scn.next();
      chx=temp.charAt(0);

      //System.out.print("請輸入long的值:");
      Lnx=scn.nextLong();

      //System.out.print("請輸入float的值:");
      fLx=scn.nextFloat();

      //System.out.print("請輸入double的值:");
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