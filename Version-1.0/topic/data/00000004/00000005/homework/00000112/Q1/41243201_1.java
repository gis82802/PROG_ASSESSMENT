import java.util.Scanner;
public class hw1{
	public static void main(String[] args){
		Scanner snc=new Scanner(System.in);
		System.out.println("請輸入x1座標:");
		double x1=snc.nextDouble();
		System.out.println("請輸入y1座標:");
		double y1=snc.nextDouble();
		System.out.println("請輸入x2座標:");
		double x2=snc.nextDouble();
		System.out.println("請輸入y2座標:");
		double y2=snc.nextDouble();
		//直線方程式
		if(x1==x2){//垂直
		System.out.println("直線方程式 x = "+x1);}
		else{//水平
			double m=(y2-y1)/(x2-x1);
			double c=y1-m*x1;
			System.out.println("直線方程式 y = "+m+"x+"+c);
		}
		//歐式定理(畢氏定理)
		double d;
		d=Math.sqrt(Math.pow((x1-y1),2)+Math.pow((x2-y2),2));
		System.out.println("歐式距離 = "+d);
		//曼哈頓距離
		double d1;
		d1=Math.abs(x1-x2)+Math.abs(y1-y2);
		System.out.println("曼哈頓距離 = "+d1);
		//Minkowski距離
		double d2;
		System.out.println("計算Minkowski距離,請輸入P值:");
		double p=snc.nextDouble();
		d2=Math.pow(Math.pow(Math.abs(x1 - x2), p) + Math.pow(Math.abs(y1 - y2), p), 1/p);
		System.out.println("Minkowski = "+d2);
		//夾角
		double dot=x1*x2+y1*y2;
		double m1=Math.sqrt(x1*x1+y1*y1);
		double m2=Math.sqrt(x2*x2+y2*y2);
		System.out.println("夾角 = "+Math.acos(dot/(m1*m2)));
	}
}