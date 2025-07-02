import java.util.Scanner;
import java.lang.Math;
public class hw{
    public static void main(String avgs[]){
    Scanner scn=new Scanner(System.in);
    System.out.println("輸入第一個點的X座標");
    int x1=scn.nextInt();
    System.out.println("輸入第一個點的Y座標");
    int y1=scn.nextInt();
    System.out.println("輸入第二個點的X座標");
    int x2=scn.nextInt();
    System.out.println("輸入第二個點的Y座標");
    int y2=scn.nextInt();
    double h=(y2-y1)/(x2-x1);//斜率
    double inter=y1-h*x1;
    System.out.println("直線方程式為：y="+h+"x +"+inter);
    //歐式距離
        double u1=Math.pow(x1-x2,2);//歐式距離X
        double u2=Math.pow(y1-y2,2);//歐式距離y
        double a1=Math.pow(u1+u2,0.5);//歐式距離結果
        String result=String.format("%.2f",a1);
        System.out.println("歐式距離="+result);
    //曼哈頓距離
    int a2 = Math.abs(x1 - x2) + Math.abs(y1 - y2);//a2為曼哈頓距離的結果
    System.out.println("曼哈頓距離="+a2);
    //切比雪夫距離
    int a3=Math.max(Math.abs(x1-x2),Math.abs(y1-y2));//a3為切比雪夫的結果
    System.out.println("切比雪夫="+a3);
    //向量夾角
    int v=x1*x2+y1*y2;//a向量乘b向量
    double n1=Math.pow(x1*x1+y1*y1,0.5);//cos角度的分母的A
    double n2=Math.pow(x2*x2+y2*y2,0.5);//cos角度的分母的B
    double cos=v/(n1*n2);//角度答案
    String result2=String.format("%.2f",cos);
    System.out.println("cos="+result2);
    scn.close();
      
    }
}