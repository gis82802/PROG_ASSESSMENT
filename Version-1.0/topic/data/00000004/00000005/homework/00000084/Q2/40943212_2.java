/*
	filename:Java_1004_02
	function:計算資料點與方程式的距離
	author:陳廷威 40943212
	datetime:2024/10/04
	version:1.0
*/

import java.util.Scanner;

public class Java_1004_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入二維資料點
        System.out.println("請輸入點的 x 和 y 座標:");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();

        // 輸入直線方程式
        System.out.println("請輸入直線方程式的係數 (A, B, C)，使得 Ax + By + C = 0:");
        double A = scanner.nextDouble();
        double B = scanner.nextDouble();
        double C = scanner.nextDouble();

        // 計算點到直線的距離
        double distance = calculateDistanceToLine(x, y, A, B, C);
        System.out.printf("點 (%.2f, %.2f) 到直線 %.2fx + %.2fy + %.2f = 0 的距離為: %.2f%n", x, y, A, B, C, distance);

        scanner.close();
    }

    // 計算點到直線的距離
    public static double calculateDistanceToLine(double x, double y, double A, double B, double C) {
        // 距離公式
        double numerator = Math.abs(A * x + B * y + C);
        double denominator = Math.sqrt(A * A + B * B);
        return numerator / denominator;
    }
}


