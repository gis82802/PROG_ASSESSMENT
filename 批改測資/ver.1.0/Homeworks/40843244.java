//homework2
//寫程式讓使用者輸入不同原始資料型態的資料
//student name:何基銘
//student ID 40843244
//date:2020/10/5
import java.util.Scanner;
public class homework2
{
   public static void main (String args[])
   {
      Scanner sca=new Scanner(System.in);
      byte by;
      short sh;
      int in;
      String str;
      char ch;
      long lo;
      float fl;
      double dou;

      //System.out.print("input byte by=");
      by=sca.nextByte();	

      //System.out.print("input short sh=");
      sh=sca.nextShort();

      //System.out.print("input int in=");
      in=sca.nextInt();

      //System.out.print("input char ch=");
      str=sca.next();
      ch=str.charAt(0);

      //System.out.print("input long lo=");
      lo=sca.nextLong();

      //System.out.print("input float fl=");
      fl=sca.nextFloat();

      //System.out.print("input double dou=");
      dou=sca.nextDouble();

      System.out.println(by);
      System.out.println(sh);
      System.out.println(in);
      System.out.println(ch);
      System.out.println(lo);
      System.out.println(fl);
      System.out.println(dou);
   }   
}