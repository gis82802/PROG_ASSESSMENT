import java.util.Scanner;
public class hw2{
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
	}
}