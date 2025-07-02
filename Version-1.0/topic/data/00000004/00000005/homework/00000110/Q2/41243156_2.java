import java.util.Scanner;
import java.lang.Math;
public class hw1 {
    public static void main(String avgs[]){
    Scanner scn=new Scanner(System.in);
    System.out.println("輸入點的X座標：");
    int x=scn.nextInt();
    System.out.println("輸入點的Y座標：");
    int y=scn.nextInt();
    System.out.println("輸入直線的斜率：");
    int linem=scn.nextInt();//linem為直線斜率
    System.out.println("輸入直線的截距：");
    int b=scn.nextInt();//b為直線得截距
    double d=(Math.abs(linem*x+((-1)*y)+b)/Math.pow(linem*linem,0.5));
    String result=String.format("%.2f",d);
    System.out.println("點到直線的距離為："+result);
    }
}