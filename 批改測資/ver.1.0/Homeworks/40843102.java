/*
40843102 ���P���A��X
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
      
      //System.out.print("��J byte = ");
      b=scn.nextByte();

      //System.out.print("��J short = ");
      s=scn.nextShort();

      //System.out.print("��J int = ");
      i=scn.nextInt();

      //System.out.print("��J char = ");
      c=scn.next().charAt(0);

      //System.out.print("��J long = ");
      l=scn.nextLong();

      //System.out.print("��J float = ");
      f=scn.nextFloat();

      //System.out.print("��J double = ");
      d=scn.nextDouble();

      
      //System.out.println("\n"+"��X");
      System.out.println("byte = "+b+"\n"+"short = "+s+"\n"+"int = "+i+"\n"+"char = "+c+"\n"+"long = "+l+"\n"+"float = "+f+"\n"+"double = "+d);
   }
}
