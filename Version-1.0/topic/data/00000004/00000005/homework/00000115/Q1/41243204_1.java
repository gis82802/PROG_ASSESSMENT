/*
    filename:hw3_2
    function:計算各公式
    author:41243204
    datetime:2024/10/4
    version:1.0
*/
import java.util.Scanner;
	public class hw3_2
	{
		public static void main(String args[])
		{
			Scanner scanner = new Scanner (System.in);
			System.out.println("輸入第一個點座標(x1,y1)");
			double x1 = scanner.nextDouble();
			double y1 = scanner.nextDouble();
			System.out.println("輸入第二個點座標(x2,y2)");
			double x2 = scanner.nextDouble();
			double y2 = scanner.nextDouble();
			
			double slope = (y2-y1)/(x2-x1);//斜率
			double intercept = y1 - slope *x1;//截距
			System.out.println("y = "+slope+"x+"+intercept);

			double euclideanDistance = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));//計算歐式距離
			System.out.println("歐式距離="+euclideanDistance);
			
			double manhattanDistence = Math.abs(x2-x1)+Math.abs(y2-y1);//計算曼哈頓距離
			System.out.println("曼哈頓距離="+manhattanDistence);

			double chebyshevDistence = Math.max(Math.abs(x2-x1),Math.abs(y2-y1));//計算切比雪夫距離
			System.out.println("切比雪夫距離="+chebyshevDistence);
	}
}
/*此程式將四種不同計算式使用空格隔開，並且變數名稱皆有意義，更方便閱讀。
歐式距離參考資料:https://medium.com/qiubingcheng/%E6%AD%90%E6%B0%8F%E8%B7%9D%E9%9B%A2%E8%88%87%E9%A4%98%E5%BC%A6%E7%9B%B8%E4%BC%BC%E5%BA%A6%E7%9A%84%E6%AF%94%E8%BC%83-c78163ad51b
曼哈頓距離參考資料:https://zh.wikipedia.org/zh-tw/%E6%9B%BC%E5%93%88%E9%A0%93%E8%B7%9D%E9%9B%A2
切比雪夫距離參考資料:https://blog.csdn.net/hy592070616/article/details/121728668*/
