/*
FileName:hw2
Function:��J���P��l��ƫ��A�����
Author:40843112 �B�f�� 
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
     //System.out.println("��Jbyte��=");
     bdata=scn.nextByte();
     //System.out.println("��Jshort��=");
     sdata=scn.nextShort();
     //System.out.println("��Jint��=");
     idata=scn.nextInt();
     //System.out.println("��Jchar��=");
     cdata=scn.next();
     //System.out.println("��Jlong��=");
     ldata=scn.nextLong();
     //System.out.println("��Jfloat��=");
     fdata=scn.nextFloat();
     //System.out.println("��Jdouble��=");
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
