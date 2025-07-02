/*
	filename:Java_0927_01
	function:資料點求方程式、距離、向量
	author:陳廷威 40943212
	datetime:2024/10/04
	version:1.0
*/

import java.util.Scanner;

public class Java_1004_01 {

    // 輸入兩個點的座標
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("輸入第一個點的 x 和 y:");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.println("輸入第二個點的 x 和 y:");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        //計算通過兩個點的直線方程式
        calculateLineEquation(x1, y1, x2, y2);

        //計算距離
        double euclideanDist = euclideanDistance(x1, y1, x2, y2);
        double manhattanDist = manhattanDistance(x1, y1, x2, y2);
        double minkowskiDist = minkowskiDistance(x1, y1, x2, y2, 3);

        System.out.printf("歐式距離: %.2f%n", euclideanDist);
        System.out.printf("曼哈頓距離: %.2f%n", manhattanDist);
        System.out.printf("Minkowski距離 (p=3): %.2f%n", minkowskiDist);

        //計算兩個向量之間的夾角
        double angle = calculateAngleBetweenVectors(x1, y1, x2, y2);
        System.out.printf("向量之間的夾角 (以度數表示): %.2f 度%n", Math.toDegrees(angle));

        scanner.close();
    }

    //計算通過兩個點的直線方程式
    public static void calculateLineEquation(double x1, double y1, double x2, double y2) {
        if (x1 == x2) {
            System.out.println("這是一條垂直線，方程式為 x = " + x1);
        } else {
            double slope = (y2 - y1) / (x2 - x1);
            double intercept = y1 - slope * x1;
            System.out.println("直線方程式為: y = " + slope + "x + " + intercept);
        }
    }

    //計算歐式距離
    public static double euclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    //計算曼哈頓距離
    public static double manhattanDistance(double x1, double y1, double x2, double y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }

    //計算 Minkowski 距離
    public static double minkowskiDistance(double x1, double y1, double x2, double y2, int p) {
        return Math.pow(Math.pow(Math.abs(x2 - x1), p) + Math.pow(Math.abs(y2 - y1), p), 1.0 / p);
    }

    //計算兩個向量的夾角
    public static double calculateAngleBetweenVectors(double x1, double y1, double x2, double y2) {
        double dotProduct = x1 * x2 + y1 * y2;
        double magnitudeA = Math.sqrt(x1 * x1 + y1 * y1);
        double magnitudeB = Math.sqrt(x2 * x2 + y2 * y2);

        return Math.acos(dotProduct / (magnitudeA * magnitudeB));
    }
}

