import java.util.Scanner;
import java.lang.Math;
public class hw2_1004 {
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		float a,b,c,x1,y1;
		double num1,num2,length;
		System.out.print("輸入直線方程式:ax+by+c=0 :\na :");
		a = scn.nextFloat();
		System.out.print("b :");
		b = scn.nextFloat();
		System.out.print("c :");
		c = scn.nextFloat();
		System.out.print("輸入座標點:(x1,y1) :\nx1 :");
		x1 = scn.nextFloat();
		System.out.print("y1 :");
		y1 = scn.nextFloat();
		num1 = Math.abs(a*x1+b*y1+c);		//參考公式ax+by+c/a*a+b*b
		num2 = Math.pow(a,2)+Math.pow(b,2);
		num2 = Math.sqrt(num2);
		length = num1/num2;
		System.out.print("點到直線的距離為 :"+length);
	}
}