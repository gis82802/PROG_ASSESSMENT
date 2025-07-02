/*
    filename:hw3_3
    function:計算點到直線距離
    author:41243204
    datetime:2024/10/4
    version:1.0
*/
import java.util.Scanner;
	public class hw3_3
	{
		public static void main(String args[])
		{
			Scanner scanner = new Scanner (System.in);
			
			System.out.println("輸入直線方程式ax+by=c的係數a,b,c");
			double a = scanner.nextDouble();
			double b = scanner.nextDouble();
			double c = scanner.nextDouble();

			System.out.println("輸入點座標(x1,y1)");
			double x1 = scanner.nextDouble();
			double y1 = scanner.nextDouble();
			
			double numerator = Math.abs(a*x1+b*y1+c);//分子
			double denominator = Math.sqrt(a*a+b*b);//分母
			double distence = numerator/denominator;//距離運算
			System.out.println("點到直線距離為="+distence);
	}
}
//此程式變數名稱皆有意義，方便閱讀。
/*點到直線距離參考資料；https://www.ehanlin.com.tw/app/keyword/%E9%AB%98%E4%B8%AD/%E6%95%B8%E5%AD%B8/%E9%BB%9E%E5%88%B0%E7%9B%B4%E7%B7%9A%E7%9A%84%E8%B7%9D%E9%9B%A2%E5%85%AC%E5%BC%8F.html*/