/*
FileName:hw2
Function:輸入不同原始資料型態的資料
Author:40843112 劉宸佑 
DataTime:2020.10.05
*/
import java.util.Scanner;
public class hw2
{
  public static void main(String args[])
  {
     Scanner scn=new Scanner(System.in);
     byte bdata;
     short sdata;
     int idata;
     String cdata;
     long ldata;
     float fdata;
     double ddata;
     //System.out.println("輸入byte值=");
     bdata=scn.nextByte();
     //System.out.println("輸入short值=");
     sdata=scn.nextShort();
     //System.out.println("輸入int值=");
     idata=scn.nextInt();
     //System.out.println("輸入char值=");
     cdata=scn.next();
     //System.out.println("輸入long值=");
     ldata=scn.nextLong();
     //System.out.println("輸入float值=");
     fdata=scn.nextFloat();
     //System.out.println("輸入double值=");
     ddata=scn.nextDouble();
     System.out.println(bdata);
     System.out.println(sdata);
     System.out.println(idata);
     System.out.println(cdata);
     System.out.println(ldata);
     System.out.println(fdata);
     System.out.println(ddata);
  }
}
