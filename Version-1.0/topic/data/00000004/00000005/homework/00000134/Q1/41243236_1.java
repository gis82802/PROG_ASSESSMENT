import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入兩個資料點
        System.out.print("請輸入第一個點的 x 和 y (格式: x y): ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.print("請輸入第二個點的 x 和 y (格式: x y): ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        // (1) 計算通過兩點的直線方程式
        // y = mx + b
        double slope = (y2 - y1) / (x2 - x1); // 斜率 m
        double intercept = y1 - slope * x1;  // y 截距 b
        System.out.printf("直線方程式: y = %.2fx + %.2f%n", slope, intercept);

        // (2) 計算距離
        // 歐式距離
        double euclideanDistance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.printf("歐式距離: %.2f%n", euclideanDistance);

        // 曼哈頓距離
        double manhattanDistance = Math.abs(x2 - x1) + Math.abs(y2 - y1);
        System.out.printf("曼哈頓距離: %.2f%n", manhattanDistance);

        // Minkowski 距離 (使用 p=3)
        double p = 3;
        double minkowskiDistance = Math.pow(Math.pow(Math.abs(x2 - x1), p) + Math.pow(Math.abs(y2 - y1), p), 1.0 / p);
        System.out.printf("Minkowski 距離 (p=3): %.2f%n", minkowskiDistance);

        // (3) 計算兩個向量的夾角
        double dotProduct = x1 * x2 + y1 * y2; // 點積
        double magnitudeA = Math.sqrt(x1 * x1 + y1 * y1); // 向量 A 的大小
        double magnitudeB = Math.sqrt(x2 * x2 + y2 * y2); // 向量 B 的大小

        // 夾角 (以弧度計算)
        double angleRad = Math.acos(dotProduct / (magnitudeA * magnitudeB));
        // 轉換為度
        double angleDeg = Math.toDegrees(angleRad);
        System.out.printf("夾角: %.2f 度%n", angleDeg);

        scanner.close();
    }
}
