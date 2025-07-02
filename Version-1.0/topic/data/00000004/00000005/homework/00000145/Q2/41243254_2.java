//app4_test3
//filename:app4_1
//function:計算點到直線的距離
//author:xiao
//date:10/4
//version:11.0.12

import java.util.Scanner;
public class app4_test3
{

 public static void main(String args[])
 {
  Scanner scn=new Scanner(System.in);
  double x,y;
  
  //設定點的x,y座標
  System.out.print("輸入x的座標:");
  x=scn.nextInt();
  System.out.print("輸入y的座標:");
  y=scn.nextInt();
  
  //設定直線方程式
  System.out.println("直線方程式為ax+by+c=0");
  System.out.print("設定a=");
  double a=scn.nextInt();
  System.out.print("設定b=");
  double b=scn.nextInt();
  System.out.print("設定c=");
  double c=scn.nextInt();
  
  //說明目前的座標和直線方程式
  System.out.println("您的點x座標為:"+x+" y座標為:"+y);
  System.out.println("您的直線L方程式為:"+a+"x+"+b+"y+"+c+"=0");
  
  //計算點到線之距離並呈現
  double distance=(Math.abs(a*x+b*y+c))/Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
  System.out.println("點到線的距離為:"+distance);
 }


}