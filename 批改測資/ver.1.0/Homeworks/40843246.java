//寫程式讓使用者輸入不同原始資料型態的資料
//student name:林峻寬
//student ID 40843246
//date:2020/10/5
import java.util.Scanner;
public class homework1005_2
{
   public static void main (String args[])
   {
      Scanner sc=new Scanner(System.in);
      byte b;
      short s;
      int i;
      String st;
      char c;
      long l;
      float f;
      double d;

      //System.out.print("input byte b=");
      b=sc.nextByte();	

      //System.out.print("input short s=");
      s=sc.nextShort();

      //System.out.print("input int i=");
      i=sc.nextInt();

      //System.out.print("input char c=");
      st=sc.next();
      c=st.charAt(0);

      //System.out.print("input long l=");
      l=sc.nextLong();

      //System.out.print("input float f=");
      f=sc.nextFloat();

      //System.out.print("input double dou=");
      dou=sc.nextDouble();

      System.out.println(b);
      System.out.println(s);
      System.out.println(i);
      System.out.println(c);
      System.out.println(l);
      System.out.println(f);
      System.out.println(d);
   }   
}