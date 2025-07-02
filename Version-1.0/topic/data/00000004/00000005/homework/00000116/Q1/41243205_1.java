import java.util.Scanner;
public class ex2{
	public static void main(String args[]){
		//取得使用者輸入
		Scanner sc = new Scanner(System.in);
		int x1, x2, y1, y2;
		System.out.printf("輸入x1: ");
		x1 = sc.nextInt();
		System.out.printf("輸入y1: ");
		y1 = sc.nextInt();
		System.out.printf("輸入x2: ");
		x2 = sc.nextInt();
		System.out.printf("輸入y2: ");
		y2 = sc.nextInt();
		
		// 計算斜率 m
		double m = (double) (y2 - y1) / (x2 - x1);
		double b = y1 - m * x1;
		System.out.printf("直線方程式為: y = %.2fx + %.2f\n", m, b);
		
		// 計算歐式距離
		double euclideanDistance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		System.out.printf("兩點之間的歐式距離為: %.2f\n", euclideanDistance);
		
		// 計算曼哈頓距離
		int manhattanDistance = Math.abs(x2 - x1) + Math.abs(y2 - y1);
		System.out.printf("兩點之間的曼哈頓距離為: %d\n", manhattanDistance);
		
		// 計算切比雪夫距離
		int chebyshevDistance = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
		System.out.printf("兩點之間的切比雪夫距離為: %d\n", chebyshevDistance);
	        
		// 計算向量的內積
		double dot = x1 * x2 + y1 * y2;
        	// 計算向量的長度
		double lengthA = Math.sqrt(x1 * x1 + y1 * y1);
        	double lengthB = Math.sqrt(x2 * x2 + y2 * y2);
        	// 計算餘弦值
		double cosTheta = dot / (lengthA * lengthB);
 	        // 使用 Math.acos 計算角度（以弧度為單位）
		double angleRadians = Math.acos(cosTheta);
                // 如果需要轉換為度數
        	double angleDegrees = Math.toDegrees(angleRadians);
		System.out.printf("兩向量之間的夾角為: %.2f度\n", angleDegrees);
	}
}