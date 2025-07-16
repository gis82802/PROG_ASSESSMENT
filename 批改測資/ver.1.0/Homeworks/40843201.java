//輸出中文萬國碼
//班級:資工二乙
//姓名:温庭儀
//檔案名稱:app3_6

import java.util.Scanner;
public class app3_13
{
 public static void main (String args[])
  {
    Scanner scn=new Scanner(System.in);
   int one;
   double q;
   char a;
   byte b;
   float c;
   short d;
   long e;
    //System.out.println("請輸入int");
    one=scn.nextInt();
    System.out.println(one);

   //System.out.println("請輸入double");
    q=scn.nextDouble();
    System.out.println(q);
    
    //System.out.println("請輸入char");
     a=scn.next().charAt(0);
    System.out.println(a);
   
   //System.out.println("請輸入byte");
   b=scn.nextByte();
   System.out.println(b);

    //System.out.println("請輸入float");
   c=scn.nextFloat();
   System.out.println(c);
   
    //System.out.println("請輸入short");
   d=scn.nextShort();
   System.out.println(d);
   
    //System.out.println("請輸入long");
   e=scn.nextLong();
   System.out.println(e);


    
    
  }
}