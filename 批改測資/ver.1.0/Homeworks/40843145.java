// hw_2, �g�{�����ϥΪ̿�J���P��l��ƫ��A�����(byte, short, int, char, long, float, dobule)

import java.util.Scanner;
public class hw_2 
{
  public static void main(String args[])
  {
    Scanner scn=new Scanner(System.in);
    String str;
    byte a;
    short b;
    int c;
    char d;
    long e;
    float f;
    double g;

    //System.out.print("�п�Jbyte: ");
    a=scn.nextByte();
    //System.out.print("�п�Jshort: ");
    b=scn.nextShort();
    //System.out.print("�п�Jint: ");
    c=scn.nextInt();
    //System.out.print("�п�Jchar: ");
    str=scn.next();
    d=str.charAt(0);
    //System.out.print("�п�Jlong: ");
    e=scn.nextLong();
    //System.out.print("�п�Jfloat: ");
    f=scn.nextFloat();
    //System.out.print("�п�Jdouble: ");
    g=scn.nextDouble();
    
    //System.out.println("-------------------------");
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
    System.out.println(d);
    System.out.println(e);
    System.out.println(f);
    System.out.println(g);
  }
}