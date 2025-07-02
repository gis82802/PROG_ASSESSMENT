import java.util.Scanner;
public class hw3{
	public static void main(String args[]){

		float x1,y1,x2,y2,m,b,Mhd,cheby;
		double Euc,Vector,Avec,Bvec,cosT,Deg;

		Scanner sc = new Scanner(System.in);

		System.out.println("點1的 x1 坐標");
		x1 = sc.nextFloat();
		System.out.println("點1的 y1 坐標");
		y1 = sc.nextFloat();
		System.out.println("點2的 x2 坐標");
		x2 = sc.nextFloat();
		System.out.println("點2的 y2 坐標");
		y2 = sc.nextFloat();
		System.out.println("兩座標分別為("+x1+","+y1+") ("+x2+","+y2+")");

		m = (y2-y1)/(x2-x1);	//斜率
		b = y1-m*x1;	//常數
		System.out.println("直線方程式為: y = "+m+"x + "+b);	//y=mx+b

		Euc = Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));	//√((x1-x2)^2+(y1-y2)^2)
		System.out.println("歐式距離為: "+Euc);

		Mhd = Math.abs((x1-x2))+Math.abs((y1-y2));	//|x1-x2|+|y1-y2|
		System.out.println("曼哈頓距離為: "+Mhd);

		//比較(x1-x2)和(y1-y2)，cheby為較大的
		cheby = Math.max(Math.abs((x1-x2)),Math.abs((y1-y2)));	
		System.out.println("切比雪夫距離為: "+cheby);
		
		Vector = x1*x2 + y1*y2;	//向量內積
		Avec = Math.sqrt(x1*x1+y1*y1);	//A模長
		Bvec = Math.sqrt(x2*x2+y2*y2);	//B模長
		cosT = Vector/(Avec*Bvec);
		Deg = Math.toDegrees(Math.acos(cosT));	//將餘弦值cosT轉換為對應的角度（以度數表示）
		System.out.println("兩個向量夾角為: "+Deg+"度");
	}
}