//app4_test4
//filename:app4_1
//function:三個數之間排出大中小
//author:xiao
//date:10/4
//version:11.0.12

import java.util.Scanner;
public class app4_test4
{
 public static void main(String arg[])
 {
   Scanner scn=new Scanner(System.in);
   
   //設置abc三個數
   int a,b,c;
   System.out.print("輸入a的數字:");
   a=scn.nextInt();
   System.out.print("輸入b的數字:");
   b=scn.nextInt();
   System.out.print("輸入c的數字:");
   c=scn.nextInt();
   
   //設置大中小
   int max,mid,min;
   //找最大值
   max = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);

   //找最小值
   min = (a < b) ? ((a < c) ? a : c) : ((b < c) ? b : c);

   //找中間值
   mid = (a != max && a != min) ? a : ((b != max && b != min) ? b : c);

   //顯示大中小
   System.out.println("最大值: " + max);
   System.out.println("中間值: " + mid);
   System.out.println("最小值: " + min);


 }



}