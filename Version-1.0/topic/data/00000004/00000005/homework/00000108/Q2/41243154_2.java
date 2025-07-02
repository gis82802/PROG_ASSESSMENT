/*參考資料
點線距離 https://www.ehanlin.com.tw/app/keyword/%E9%AB%98%E4%B8%AD/%E6%95%B8%E5%AD%B8/%E9%BB%9E%E5%88%B0%E7%9B%B4%E7%B7%9A%E7%9A%84%E8%B7%9D%E9%9B%A2%E5%85%AC%E5%BC%8F.html
*/

import java.util.Scanner;
import java.lang.Math;

public class J_1004_1 {
	public  static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.print("x0 y0:"); //輸入座標
		int x0 = s.nextInt();
		int y0 = s.nextInt();
		System.out.print("ax+by+c=0 (a b c):"); //輸入線段
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		
		System.out.println("\n===OUTPUT===");
		
		double ansA = Math.abs(a*x0 + b*y0 + c)/Math.pow((a*a)+(b*b),0.5);
		System.out.println("distance:"+ansA);
		
	}
}
