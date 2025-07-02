import java.util.Scanner;
public class xy
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("輸入兩二維座標");
		double x1=sc.nextDouble();
		double y1=sc.nextDouble();
		double x2=sc.nextDouble();
		double y2=sc.nextDouble();//要求使用者輸入兩座標
		System.out.println("p1:("+x1+","+y1+")");
		System.out.println("p2:("+x2+","+y2+")");//顯示座標
		if (x1 == x2){
			if(y1 == y2)
				System.out.println("兩點重疊");
			else
            			System.out.println("這是一條垂直線，方程為:x="+x1);
		}else if (y1 == y2){
            		System.out.println("這是一條平行線，方程為:y="+y1);
        	}else{
			double a=(y1-y2)/(x1-x2);
			double b=y1-a*x1;
			System.out.println("直線方程為:y="+a+"x+"+b);//判斷是否重疊、垂直、平行、並輸出其方程式
		}
		double euclideanDist=Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
        	System.out.println("兩點的歐式距離為:"+euclideanDist);
		System.out.println("兩點的曼哈頓距離為:"+(Math.abs(x2-x1)+Math.abs(y2-y1)));
		double chebyshevDistance=Math.max(Math.abs(x2-x1),Math.abs(y2-y1));
        	System.out.println("兩點的切比雪夫距離為:"+chebyshevDistance);
		double dp=x1*x2+y1*y2;
        	double c=Math.sqrt(x1*x1+y1*y1);
        	double d=Math.sqrt(x2*x2+y2*y2);
        	double angle=Math.acos(dp/(c*d))*(180/Math.PI);
		System.out.println("兩向量的夾角為:"+angle+"度");//計算並顯示各種參數
	}

}