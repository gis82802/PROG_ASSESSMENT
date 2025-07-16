//homework2 
//寫程式讓使用者輸入不同原始資料型態的資料
//studer ID:40843216
//date:2020/10/05
import java.util.Scanner;
public class homework2
{
   public static void main(String args[])
   {
      Scanner scm =new Scanner(System.in);
      int in;
      byte by;
      short sh;
      String str;
      char ch;
      long lo;
      float fl;
      double dou;
      //System.out.println("input int:");
      in=scm.nextInt();
      //System.out.println("input byte:");
      by=scm.nextByte();
      //System.out.println("input short:");
      sh=scm.nextShort();
      //System.out.println("input char:");
      str=scm.next();
      ch=str.charAt(0);
      //System.out.println("input long:");
      lo=scm.nextLong();
      //System.out.println("input float:");
      fl=scm.nextFloat();
      //System.out.println("input double:");
      dou=scm.nextDouble();
      System.out.println(in);
      System.out.println(by);
      System.out.println(sh);
      System.out.println(ch);
      System.out.println(lo);
      System.out.println(fl);
      System.out.println(dou);
   }
}