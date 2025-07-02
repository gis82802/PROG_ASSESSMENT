import java.util.Scanner;
import java.lang.Math;
public class hw1_1004 {
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		float[] P1=new float[2];
		float[] P2=new float[2];
		float a,c,absx,absy,slope,intercept,d1,d2;
		System.out.println("輸入P1位置(x,y)");
		for(int i=0;i<2;i++)
			P1[i] = scn.nextFloat();
		System.out.println("輸入P2位置(x,y)");
		for(int i=0;i<2;i++)
			P2[i] = scn.nextFloat();
		if(P1[0]==P2[0]&&P1[1]==P2[1]){
			return ;
		}

		slope=(P2[1]-P1[1])/(P2[0]-P1[0]);					//計算斜率
		intercept=P1[1]-slope*P1[0];						//計算截距
		System.out.println("直線方程式 : y="+slope+"x+"+intercept);	

		double num = Math.pow((double)(P1[0]-P2[0]),2)+Math.pow((double)(P1[1]-P2[1]),2);
		double b = Math.sqrt((double)num);
		System.out.println("歐式距離 = "+b);

		absx = Math.abs(P1[0]-P2[0]);						//x1-x2的絕對值
		absy = Math.abs(P1[1]-P2[1]);						//y1-y2的絕對值
		c = absx+absy;
		System.out.println("曼哈頓距離 = "+c);

		System.out.println("切比雪夫距離 = max("+absx+","+absy+")");

		double L1=Math.sqrt(P1[0]*P1[0]+P1[1]*P1[1]);				//計算x1的平方+y1的平方	
		double L2=Math.sqrt(P2[0]*P2[0]+P2[1]*P2[1]);				//計算x2的平方+y2的平方
		num = (P1[0]*P2[0]+P1[1]*P2[1])/(L1*L2);
		double d = Math.acos(num);
		System.out.println("夾角 = "+Math.toDegrees(d));
		
	}
}