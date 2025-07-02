/*
   資工二乙 林沛慧 41243202
   作業一：兩個二維資料點
   功能：讓使用者輸入兩個二維資料點，並算出直線方程式、歐式距離、曼哈頓距離、切比雪夫距離、兩向量的夾角
*/
import java.util.Scanner;
public class hw1
{
	public static void main(String[] args)
	{
		//輸入
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入兩個二維資料點：\n");
		System.out.println("x1=");
		int x1 = sc.nextInt();
		System.out.println("x2=");
		int x2 = sc.nextInt();
		System.out.println("y1=");
		int y1 = sc.nextInt();
		System.out.println("y2=");
		int y2 = sc.nextInt();
		//直線方程式	
		System.out.println("直線方程式：");
		double m=(y1-y2)/(x1-x2);	//先求斜率
		System.out.println("y-"+y1+"="+m+"(x-"+x1+")");
		//歐式距離
		System.out.println("歐式距離："+Math.pow(Math.pow(x1-x2,2)+Math.pow(y1-y2,2),0.5));
		//曼哈頓距離
		double mh=Math.abs(x1-x2)+Math.abs(y1-y2);
		System.out.println("曼哈頓距離："+mh);
		//切比雪夫
		System.out.println("切比雪夫："+Math.max(Math.abs(x1-x2),Math.abs(y1-y2)));
		//夾角
		int point = x1*x2+y1*y2;
		double lx = Math.sqrt(x1*x1+x2*x2);
		double ly = Math.sqrt(y1*y1+y2*y2);
		double angle =Math.toDegrees( Math.acos(point / (lx*ly)));
		System.out.println("夾角："+angle);
		
	}
}