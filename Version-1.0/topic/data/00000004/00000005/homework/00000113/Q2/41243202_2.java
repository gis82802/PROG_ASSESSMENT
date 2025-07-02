/*
   資工二乙 41243202 林沛慧
   作業二：點與線的距離
   功能：讓使用者輸入一個二維資料點及一個點，計算出點與線之間的距離
*/
import java.util.Scanner;
public class hw2
{
	public static void main(String[] args)
	{
		//輸入
		Scanner sc = new Scanner(System.in);
		//線的輸入
		System.out.println("請輸入一個二維資料點：");
		System.out.println("x1 =");
		int x1 = sc.nextInt();
		System.out.println("x2 =");
		int x2 = sc.nextInt();
		System.out.println("y1 =");
		int y1 = sc.nextInt();
		System.out.println("y2 =");
		int y2 = sc.nextInt();
		//點的輸入
		System.out.println("請輸入一個點：");
		System.out.println("x =");
		int x = sc.nextInt();
		System.out.println("y =");
		int y = sc.nextInt();
		//斜率計算
		double m=(y1-y2)/(x1-x2);
		//距離
		double d=Math.abs(m*x+y+x1+y1)/Math.sqrt(m*m);
		System.out.println("點與線的距離為："+d);
		
	}
}