/*
檔名:test1
功能:可自行輸入兩個座標且輸出兩點距離和直線方程式
作者:周奕辰
學號:40843237
日期:2020/10/05
版本:1.0
*/
import java.util.Scanner;
public class test1
{
   public static void main(String args[])
   {
      Scanner scn=new Scanner(System.in);
      double x1,x2,y1,y2,a,b;
      //System.out.println("請輸入x1座標:");
      x1=scn.nextDouble();
      //System.out.println("請輸入y1座標:");
      y1=scn.nextDouble();
      //System.out.println("請輸入x2座標:");
      x2=scn.nextDouble();
      //System.out.println("請輸入y2座標:");
      y2=scn.nextDouble();
      System.out.println(Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2)));
      a=(y1-y2)/(x1-x2);
      b=y1-(a*x1);
      System.out.println(a);
      System.out.println(b);
   }
}