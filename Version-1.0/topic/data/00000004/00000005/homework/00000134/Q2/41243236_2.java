import java.util.Scanner;

public class PointLineDistance {

    // 計算點到直線的距離的函數
    public static double calculateDistance(double A, double B, double C, double x1, double y1) {
        // 公式: |Ax1 + By1 + C| / sqrt(A^2 + B^2)
        return Math.abs(A * x1 + B * y1 + C) / Math.sqrt(A * A + B * B);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入直線方程式的係數
        System.out.print("輸入直線的係數 A (Ax + By + C = 0): ");
        double A = scanner.nextDouble();

        System.out.print("輸入直線的係數 B (Ax + By + C = 0): ");
        double B = scanner.nextDouble();

        System.out.print("輸入直線的常數 C (Ax + By + C = 0): ");
        double C = scanner.nextDouble();

        // 輸入點的座標
        System.out.print("輸入點的 x 座標: ");
        double x1 = scanner.nextDouble();

        System.out.print("輸入點的 y 座標: ");
        double y1 = scanner.nextDouble();

        // 計算並輸出距離
        double distance = calculateDistance(A, B, C, x1, y1);
        System.out.printf("點與直線之間的距離為: %.4f\n", distance);

        scanner.close();
    }
}
