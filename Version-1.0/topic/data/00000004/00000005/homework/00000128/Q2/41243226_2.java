import java.util.Scanner;
public class pl {
    public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	System.out.println("定義一直線ax+by+c=0:");
	double a=sc.nextDouble();
	double b=sc.nextDouble();
	double c=sc.nextDouble();//要求使用者輸入直線方程式
	System.out.println("輸入二維座標");
	double x=sc.nextDouble();
	double y=sc.nextDouble();//要求使用者輸入座標
	System.out.println("距離="+(Math.abs((a*x)+(b*y)+c)/Math.sqrt((Math.pow(a,2))+(Math.pow(b,2)))));//計算並輸出結果
    }
}
