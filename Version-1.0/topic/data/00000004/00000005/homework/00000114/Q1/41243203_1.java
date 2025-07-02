import java.util.Scanner;

public class hw1 {

    // 計算直線方程式
    public static void lineEquation(double[] point1, double[] point2) {
        if (point1[0] == point2[0]) {
            // 垂直線的情況，x = constant
            System.out.println("直線方程式為：x = " + point1[0]);
        } else {
            double slope = (point2[1] - point1[1]) / (point2[0] - point1[0]); // 計算斜率
            double intercept = point1[1] - slope * point1[0]; // b = y1 - m * x1
            System.out.println("直線方程式為：y = " + slope + "x + " + intercept);
        }
    }

    // 計算歐式距離
    public static double euclideanDistance(double[] point1, double[] point2) {
        return Math.sqrt(Math.pow(point2[0] - point1[0], 2) + Math.pow(point2[1] - point1[1], 2));
    }

    // 計算曼哈頓距離
    public static double manhattanDistance(double[] point1, double[] point2) {
        return Math.abs(point2[0] - point1[0]) + Math.abs(point2[1] - point1[1]);
    }

    // 計算 Minkowski 距離，這裡設 p=3
    public static double minkowskiDistance(double[] point1, double[] point2, double p) {
        return Math.pow(Math.pow(Math.abs(point2[0] - point1[0]), p) + Math.pow(Math.abs(point2[1] - point1[1]), p), 1.0 / p);
    }

    // 計算向量之間的夾角 (使用餘弦定理)
    public static double calculateAngle(double[] point1, double[] point2) {
        double dotProduct = point1[0] * point2[0] + point1[1] * point2[1]; // 向量點積
        double magnitude1 = Math.sqrt(point1[0] * point1[0] + point1[1] * point1[1]); // 向量1的大小
        double magnitude2 = Math.sqrt(point2[0] * point2[0] + point2[1] * point2[1]); // 向量2的大小
        double cosTheta = dotProduct / (magnitude1 * magnitude2); // 計算 cosθ
        return Math.toDegrees(Math.acos(cosTheta)); // 返回夾角（角度制）
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 輸入兩個二維點
        System.out.println("輸入點1的座標（x1, y1）：");
        double[] point1 = {sc.nextDouble(), sc.nextDouble()};

        System.out.println("輸入點2的座標（x2, y2）：");
        double[] point2 = {sc.nextDouble(), sc.nextDouble()};

        // 1. 計算直線方程式
        lineEquation(point1, point2);

        // 2. 計算歐式距離、曼哈頓距離、Minkowski 距離
        double euclidean = euclideanDistance(point1, point2);
        double manhattan = manhattanDistance(point1, point2);
        double minkowski = minkowskiDistance(point1, point2, 3); // Minkowski 距離 p=3

        System.out.println("歐式距離: " + euclidean);
        System.out.println("曼哈頓距離: " + manhattan);
        System.out.println("Minkowski 距離 (p=3): " + minkowski);

        // 3. 計算兩向量之間的夾角
        double angle = calculateAngle(point1, point2);
        System.out.println("兩向量之間的夾角 (度數): " + angle);

        sc.close();
    }
}
