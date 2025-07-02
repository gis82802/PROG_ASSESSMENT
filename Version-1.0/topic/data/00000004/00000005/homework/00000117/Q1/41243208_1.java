import java.util.Scanner;

public class hw10041 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
	// 輸入兩個平面座標點
        System.out.print("輸入點A的x座標: ");
        double x1 = sc.nextDouble();
        System.out.print("輸入點A的y座標: ");
        double y1 = sc.nextDouble();
        
        System.out.print("輸入點B的x座標: ");
        double x2 = sc.nextDouble();
        System.out.print("輸入點B的y座標: ");
        double y2 = sc.nextDouble();
        
	// 計算直線方程式
        if (x1 == x2) {
            System.out.println("通過這兩點的直線為x = " + x1);
        } else {
            double slope = (y2 - y1) / (x2 - x1); // 斜率
            double intercept = y1 - slope * x1;	   // 截距
            System.out.println("直線方程式為: y = " + slope + "x + " + intercept);
        }
        
	// 計算歐式距離
        double euclideanDistance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("歐式距離: " + euclideanDistance);
        
	// 計算曼哈頓距離
        double manhattanDistance = Math.abs(x2 - x1) + Math.abs(y2 - y1);
        System.out.println("曼哈頓距離: " + manhattanDistance);
        
	// 計算切比雪夫距離
        double chebyshevDistance = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
        System.out.println("切比雪夫距離: " + chebyshevDistance);
        
	// 計算兩點向量的夾角
        double dotProduct = x1 * x2 + y1 * y2; // 內積
        double magnitudeA = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2)); // 向量A的模
        double magnitudeB = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2)); // 向量B的模
        double cosTheta = dotProduct / (magnitudeA * magnitudeB); // 餘弦值
        double angle = Math.acos(cosTheta); // 夾角（弧度）
        System.out.println("兩點向量的夾角(弧度): " + angle);
        System.out.println("兩點向量的夾角(度數): " + Math.toDegrees(angle));
        
        sc.close();
    }
}
