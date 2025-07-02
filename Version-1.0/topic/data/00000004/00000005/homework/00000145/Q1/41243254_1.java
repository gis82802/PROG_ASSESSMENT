//app4_test2
//filename:app4_1
//function:直線方程式,歐式距離,曼哈頓距離,切比雪夫距離,向量之間的夾角
//author:xiao
//date:10/4
//version:11.0.12

import java.util.Scanner;
public class app4_test2
{
 public static void main(String args[])
 {
  Scanner scn=new Scanner(System.in);
  double x1,x2,y1,y2,slope,intercept;
  //設定座標
  System.out.print("輸入p1的x:");
  x1=scn.nextInt();
  System.out.print("輸入p1的y:");
  y1=scn.nextInt();
  System.out.print("輸入p2的x:");
  x2=scn.nextInt();
  System.out.print("輸入p2的y:");
  y2=scn.nextInt();
  
  //計算直線方程式
  slope=(y2-y1)/(x2-x1);
  intercept=y1-slope*x1;
  System.out.println("直線方程式為:y="+slope+"x+"+intercept);
  
  //計算歐式距離
  double Eucdistance=Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
  System.out.println("歐式距離為:"+Eucdistance);
  double Mandistance=Math.abs(x1-x2)+Math.abs(y1-y2);
  
  //計算曼哈頓距離
  System.out.println("曼哈頓距離為:"+Mandistance);
  
  //計算切比雪夫距離
  double Chedistance=Math.max(Math.abs(x1-x2),Math.abs(y1-y2));
  System.out.println("切比雪夫距離為:"+Chedistance);
  
  //計算兩個向量之間的夾角
  double dotProduct = (x1 * x2) + (y1 * y2);
  double magnitudeA = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
  double magnitudeB = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));
  double angleInRadians = Math.acos(dotProduct / (magnitudeA * magnitudeB));
  // 將夾角從弧度轉換為度
  double angleInDegrees = Math.toDegrees(angleInRadians);
  System.out.println("x和y向量之間的夾角為:"+angleInDegrees+"度");

 }

}
