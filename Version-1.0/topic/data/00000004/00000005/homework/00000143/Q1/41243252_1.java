/*
日期: 2024/10/4
作者: 41243252蔡承叡
版本: jdk23
題目: 4_1
*/

import java.util.Scanner;  // 引入 Scanner 類

public class ch4_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // 使用 Scanner 進行輸入

        // 輸入兩個二維資料點
        System.out.print("請輸入第一個點的座標 (x1 y1): ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.print("請輸入第二個點的座標 (x2 y2): ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        // 計算直線方程式
        calculateLineEquation(x1, y1, x2, y2);

        // 計算各種距離
        calculateDistances(x1, y1, x2, y2);

        // 計算夾角
        calculateAngle(x1, y1, x2, y2);

        // 關閉掃描器
        scanner.close();
    }

    // 計算直線方程式
    private static void calculateLineEquation(double x1, double y1, double x2, double y2) {
        // 檢查兩個點是否相同
        if (x1 == x2 && y1 == y2) {
            System.out.println("兩個點相同，無法定義直線方程式。");
        } else if (x1 == x2) {  // 垂直線的特殊情況
            System.out.printf("通過此二點的直線方程式為：x = %.2f\n", x1);
        } else {
            double m = (y2 - y1) / (x2 - x1);  // 斜率
            double b = y1 - m * x1;  // 截距
            System.out.printf("通過此二點的直線方程式為：y = %.2fx + %.2f\n", m, b);
        }
    }

    // 計算歐式距離、曼哈頓距離、切比雪夫距離
    private static void calculateDistances(double x1, double y1, double x2, double y2) {
        // 歐式距離
        double euclideanDistance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.printf("歐式距離：%.2f\n", euclideanDistance);

        // 曼哈頓距離
        double manhattanDistance = Math.abs(x2 - x1) + Math.abs(y2 - y1);
        System.out.printf("曼哈頓距離：%.2f\n", manhattanDistance);

        // 切比雪夫距離
        double chebyshevDistance = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
        System.out.printf("切比雪夫距離：%.2f\n", chebyshevDistance);
    }

    // 計算兩向量的夾角
    private static void calculateAngle(double x1, double y1, double x2, double y2) {
        // 向量 a = (x1, y1), 向量 b = (x2, y2)
        double dotProduct = (x1 * x2) + (y1 * y2);  // 內積
        double magnitudeA = Math.sqrt(x1 * x1 + y1 * y1);  // 向量 a 的長度
        double magnitudeB = Math.sqrt(x2 * x2 + y2 * y2);  // 向量 b 的長度

        // 檢查是否為零向量
        if (magnitudeA == 0 && magnitudeB == 0) {
            System.out.println("兩個向量均為零向量，無法計算夾角。");
        } else if (magnitudeA == 0) {
            System.out.println("向量 a 為零向量，無法計算夾角。");
        } else if (magnitudeB == 0) {
            System.out.println("向量 b 為零向量，無法計算夾角。");
        } else {
            double cosTheta = dotProduct / (magnitudeA * magnitudeB);
            // 確保 cosTheta 的值在 -1 到 1 之間，以避免計算錯誤
            cosTheta = Math.min(1, Math.max(-1, cosTheta));
            double angle = Math.acos(cosTheta);  // 夾角 (弧度制)
            double angleDegrees = Math.toDegrees(angle);  // 轉換為角度制
            System.out.printf("兩向量的夾角：%.2f 度\n", angleDegrees);
        }
    }
}
