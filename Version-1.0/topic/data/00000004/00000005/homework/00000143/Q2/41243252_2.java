/*
日期:2024/10/4
作者:41243252蔡承叡
版本:jdk23
題目:4_2
*/

import java.util.Scanner;

public class ch4_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入直線的係數 Ax + By + C = 0
	System.out.println("直線方程式為Ax + By + C = 0");
        System.out.print("請輸入直線方程式的 A 係數：");
        double A = scanner.nextDouble();
        System.out.print("請輸入直線方程式的 B 係數：");
        double B = scanner.nextDouble();
        System.out.print("請輸入直線方程式的 C 常數：");
        double C = scanner.nextDouble();

        // 輸入點的座標 (x0, y0)
        System.out.print("請輸入點的 x 座標：");
        double x0 = scanner.nextDouble();
        System.out.print("請輸入點的 y 座標：");
        double y0 = scanner.nextDouble();

        // 使用公式計算點到直線的距離
        double distance = 計算距離(A, B, C, x0, y0);

        // 輸出結果
        System.out.printf("點 (%.2f, %.2f) 到直線 %.2fx + %.2fy + %.2f = 0 的距離為：%.4f\n", x0, y0, A, B, C, distance);

        // 關閉掃描器
        scanner.close();
    }

    public static double 計算距離(double A, double B, double C, double x0, double y0) {
        // 使用距離公式：|Ax0 + By0 + C| / sqrt(A^2 + B^2)
        return Math.abs(A * x0 + B * y0 + C) / Math.sqrt(A * A + B * B);
    }
}
