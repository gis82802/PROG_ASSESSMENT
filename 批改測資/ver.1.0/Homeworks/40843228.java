/*
fileName:app2_2
name:40843228 盧奕勳
time:10/05
讀取各種不同型態資料
*/
import java.util.Scanner;
public class app2_2
{
   public static void main(String[] args)
   {
      //System.out.println("Enter the byte : ");
      Scanner b=new Scanner(System.in);
      byte b_in=b.nextByte();

      //System.out.println("Enter the int : ");
      Scanner i=new Scanner(System.in);
      int i_in=i.nextInt();

      //System.out.println("Enter the char : ");
      Scanner c=new Scanner(System.in);
      char c_in=c.next().charAt(0);

      //System.out.println("Enter the long : ");
      Scanner l=new Scanner(System.in);
      long l_in=l.nextLong();

      //System.out.println("Enter the float : ");
      Scanner f=new Scanner(System.in);
      float f_in=f.nextFloat();

      //System.out.println("Enter the double : ");
      Scanner d=new Scanner(System.in);
      double d_in=d.nextDouble();

      System.out.println(b_in);
      System.out.println(i_in);
      System.out.println(c_in);
      System.out.println(l_in);
      System.out.println(f_in);
      System.out.println(d_in);
      //System.out.println("byte : "+b_in+" int : "+i_in+" char :"+c_in+" long : "+l_in+" float : "+f_in+" double : "+d_in);
      
   }
}

