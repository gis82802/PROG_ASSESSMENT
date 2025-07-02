import java.util.Scanner;
import java.lang.Math;

public class test1{
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int[] pt1 = new int[2];
		int[] pt2 = new int[2];
		System.out.println("輸入兩筆二維資料");
		for(int i=0;i<2;i++){
			pt1[i]=s.nextInt();
		}
		for(int i=0;i<2;i++){
			pt2[i]=s.nextInt();
		}
	//===================使用者輸入結果顯示	
		for(int element: pt1){
			System.out.print(element+",");
		}
		System.out.println(" ");
		for(int element: pt2){
			System.out.print(element+",");
		}
		System.out.println(" ");
	//====================歐式距離
		double Eu_ans;
		Eu_ans=Euclidean(pt1,pt2);
		System.out.println("歐式距離為: "+Eu_ans);
	//====================曼哈頓距離
		int  Manha_ans; 		
		Manha_ans = Manhattan(pt1,pt2);
		System.out.println("曼哈頓距離為: "+Manha_ans);
	//====================明可夫斯基距離
		System.out.println("p=1時 明可夫斯基距離為: "+Eu_ans);
		System.out.println("p=2時 明可夫斯基距離為: "+Manha_ans);

	//====================向量夾角
		double vect_angle;
		vect_angle = vect(pt1, pt2);
		System.out.println("向量夾角為: "+vect_angle);

	}//主程式結束


	//=========================================2點直線(歐式距離)

	public static double Euclidean(int[] a,int[] b){
		double ans;
		double x,y;
		x = Math.pow((b[0]-a[0]),2);
		y= Math.pow((b[1]-a[1]),2);
		ans = Math.sqrt(x+y);
		return ans;
	}//2點直線(歐式距離)結束
	//=========================================2點直線(曼哈頓距離)

	public static int Manhattan(int[] a,int[] b){
		int x;
		int y;
		int ans;
		x = Math.abs(b[0]-a[0]);
		y = Math.abs(b[1]-a[1]);
		ans = x+y;
		return ans;
	}//2點直線(曼哈頓距離)結束
	//=========================================向量夾角

	public static double vect(int[] a,int[] b){
		//向量長 = Math.sqrt(x * x + y * y)
		double length_1;
		double length_2;
		length_1 = Math.sqrt(a[0]*a[0]+a[1]*a[1]);
		length_2 = Math.sqrt(b[0]*b[0]+b[1]*b[1]);
		//点积 = Ax * Bx + Ay * By
		double dot;
		dot = a[0]*b[0] + a[1]*b[1];
		//夹角 = Math.acos(点积 / (模长A * 模长B))
		double angle = Math.acos(dot/(length_1 * length_2));
		return angle;
	}
	
}//test1結束