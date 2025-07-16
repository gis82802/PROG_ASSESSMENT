/*
40843102 不同型態輸出
*/

import java.util.Scanner;
public class hw_2
{
   public static void main(String args[])
   {
      Scanner scn=new Scanner(System.in);
      
      byte b;
      short s;
      int i;
      char c;
      long l;
      float f;
      double d;
      
      //System.out.print("輸入 byte = ");
      b=scn.nextByte();

      //System.out.print("輸入 short = ");
      s=scn.nextShort();

      //System.out.print("輸入 int = ");
      i=scn.nextInt();

      //System.out.print("輸入 char = ");
      c=scn.next().charAt(0);

      //System.out.print("輸入 long = ");
      l=scn.nextLong();

      //System.out.print("輸入 float = ");
      f=scn.nextFloat();

      //System.out.print("輸入 double = ");
      d=scn.nextDouble();

      
      //System.out.println("\n"+"輸出");
      System.out.println("byte = "+b+"\n"+"short = "+s+"\n"+"int = "+i+"\n"+"char = "+c+"\n"+"long = "+l+"\n"+"float = "+f+"\n"+"double = "+d);
   }
}
