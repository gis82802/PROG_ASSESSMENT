/*
FileName:InputDataType
Function:��J���P����ƫ��A
Date:2020/10/05
Version:1.0
Author:40843119 ��u�G�� �i�q�{
*/
import java.util.Scanner;
public class InputDataType{
   public static void main(String args[]){
      Scanner scn = new Scanner(System.in);
      int i; byte b; short s; String str; float f; double d; char c;
      i = scn.nextInt();
      s = scn.nextShort();
      b = scn.nextByte();
      str = scn.next();
      f = scn.nextFloat();
      d = scn.nextDouble();
      c = str.charAt(0);
      System.out.println(i);
      System.out.println(s);
      System.out.println(b);
      System.out.println(c);
      System.out.println(f);
      System.out.println(d);
      //System.out.println("integer = "+i+" ,short = "+s+" ,byte = "+b);
      //System.out.println("char = "+c+" ,float = "+f+" ,double = "+d);
   }
}