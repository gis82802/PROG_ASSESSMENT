// hw_2, 寫程式讓使用者輸入不同原始資料型態的資料(byte, short, int, char, long, float, dobule)

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

    //System.out.print("請輸入byte: ");
    a=scn.nextByte();
    //System.out.print("請輸入short: ");
    b=scn.nextShort();
    //System.out.print("請輸入int: ");
    c=scn.nextInt();
    //System.out.print("請輸入char: ");
    str=scn.next();
    d=str.charAt(0);
    //System.out.print("請輸入long: ");
    e=scn.nextLong();
    //System.out.print("請輸入float: ");
    f=scn.nextFloat();
    //System.out.print("請輸入double: ");
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