import java.util.Scanner;

public class LineEquation {

    // 計算兩點之間的直線方程式
    public static void lineEquation(double[] point1, double[] point2) {
        if (point1[0] == point2[0]) {
            // 垂直線的情況，x = constant
            System.out.println("直線方程式為：x = " + point1[0]);
        } else {
            double slope = (point2[1] - point1[1]) / (point2[0] - point1[0]); // 計算斜率
            double intercept = point1[1] - slope * point1[0]; // b = y1 - m * x1
            
            // 輸出結果包含斜率和截距
            System.out.println("直線方程式為：y = " + slope + "x + " + intercept);
            System.out.println("斜率： " + slope);
            System.out.println("截距： " + intercept);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 輸入兩個二維點
        System.out.println("輸入點1的座標（x1, y1）：");
        double[] point1 = {sc.nextDouble(), sc.nextDouble()};

        System.out.println("輸入點2的座標（x2, y2）：");
        double[] point2 = {sc.nextDouble(), sc.nextDouble()};

        // 計算直線方程式，並顯示斜率與截距
        lineEquation(point1, point2);

        sc.close();
    }
}
