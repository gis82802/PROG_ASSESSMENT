/*參考資料
標準輸入    https://yubin551.gitbook.io/java-note/basic_java_programming/standard_input_scanner
Java.Math  https://codegym.cc/tw/groups/posts/tw.351.zai-java-zhong-shi-yong-math-pow-fang-fa
直線方程式  https://www.liveism.com/live-concept.php?q=%E5%B7%B2%E7%9F%A5%E7%9B%B4%E7%B7%9A%E4%B8%8A%E5%85%A9%E9%BB%9E%E6%B1%82%E7%9B%B4%E7%B7%9A%E6%96%B9%E7%A8%8B%E5%BC%8F
歐式距離    https://zh.wikipedia.org/zh-tw/%E6%AC%A7%E5%87%A0%E9%87%8C%E5%BE%97%E8%B7%9D%E7%A6%BB
曼哈頓距離  https://zh.wikipedia.org/zh-tw/%E6%9B%BC%E5%93%88%E9%A0%93%E8%B7%9D%E9%9B%A2
明式距離    https://zh.wikipedia.org/zh-tw/%E6%98%8E%E6%B0%8F%E8%B7%9D%E7%A6%BB
切比雪夫距離 https://zh.wikipedia.org/zh-tw/%E5%88%87%E6%AF%94%E9%9B%AA%E5%A4%AB%E8%B7%9D%E7%A6%BB
*/

import java.util.Scanner;
import java.lang.Math;

public class J_1004_1 {
	public  static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.print("x1 y1:"); //輸入座標1
		int x1 = s.nextInt();
		int y1 = s.nextInt();
		System.out.print("x2 y2:"); //輸入座標2
		int x2 = s.nextInt();
		int y2 = s.nextInt();
		
		System.out.println("\n===OUTPUT===");
		int a = x1-x2; //求未知數a,b
		a = (y1-y2)/a;
		int b = y1- a*x1;
		//System.out.println("y = ax +b");
		System.out.println("y = "+a+"x +"+b); //輸出直線方程式
		//int testA = (int)Math.pow(2,3);
		double ansA = Math.pow(Math.pow(x1-x2,2)+Math.pow(y1-y2,2),0.5);
		int ansB = Math.abs(x1-x2)+Math.abs(y1-y2);
		int ansC = Math.max(Math.abs(x1-x2),Math.abs(y1-y2));
		System.out.println("歐式距離: "+ansA);
		System.out.println("曼哈頓距離: "+ansB);
		System.out.println("明式距離(切比雪夫): "+ansC); //明可夫斯基距離 Minkowski distance
		double ansD = Math.pow((x1*x1)+(y1*y1),0.5)*Math.pow((x2*x2)+(y2*y2),0.5);
		System.out.println("向量夾角: "+ansD);
		
	}
}
