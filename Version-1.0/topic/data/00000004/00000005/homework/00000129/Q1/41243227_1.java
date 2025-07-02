import java.util.Scanner;
import java.lang.Math;
public class wk1{

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int a1;
		int a2;
		int b1;
		int b2;
		int c,y,m;
 		c=y=m=0;
		System.out.println("input(a1,a2)");
		a1 = sc.nextInt();
		a2 = sc.nextInt();
		System.out.println("input(b1,b2)");
		b1 = sc.nextInt();
		b2 = sc.nextInt();
		
		m=(b2-a2)/(b1-a1);  //斜率
		c=a2 - m*a1;        //截距
		System.out.println("y="+m+"x+"+c); //直線公式
		double p=0;
		p=Math.sqrt(Math.pow(b1-a1, 2) + Math.pow(b2-a2,2)); //歐式距離
		System.out.println("Euckidean Distance: "+p);
		int d=0;
		d=Math.abs(b1-a1)+Math.abs(b2-a2);                    //曼哈頓距離
		System.out.println("Manhattan length: "+d);
		int max=0;                                            //切比雪夫距離
		max = (Math.abs(b1-a1)>Math.abs(b2-a2))?Math.abs(b1-a1):Math.abs(b2-a2);
		System.out.println("Chebyshev Distance: "+max);

		double value=Math.abs(a1*b1+a2*b2)/(Math.sqrt(Math.pow(a1,2)+Math.pow(a2,2))*Math.sqrt(Math.pow(b1,2)+Math.pow(b2,2))) ;       //角度
	 	// 計算反餘弦（以弧度為單位）並轉換成角度
		double radians = Math.acos(value);
		double degrees = Math.toDegrees(radians);
		System.out.println(degrees);
	}
}