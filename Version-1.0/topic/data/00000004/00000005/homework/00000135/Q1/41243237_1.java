/*
filename: app4_2
function:This program calculates the slope, intercept, distances (Euclidean, Manhattan, Chebyshev), and angle between two points in a 2D plane based on user input. 
author: PoXsun
date: 2024/10/04
version: 11.0.12
*/

import java.util.Scanner;

public class app4_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 讀取兩個點的座標
        System.out.println("輸入x1座標:");
        int x1 = sc.nextInt();
        System.out.println("輸入y1座標:");
        int y1 = sc.nextInt();
        System.out.println("輸入x2座標:");
        int x2 = sc.nextInt();
        System.out.println("輸入y2座標:");
        int y2 = sc.nextInt();

        // 計算斜率 (m) 和截距 (c) 
        double m = (double)(y2 - y1) / (x2 - x1); // 確保斜率為浮點數
        double c = y1 - m * x1; // 直線方程式中的常數項
        System.out.println("直線方程式: y = " + m + " x + " + c);

        // 計算歐式距離
        double euclideanDistance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        System.out.println("歐式距離: " + euclideanDistance);
        
        // 計算曼哈頓距離
        double manhattanDistance = Math.abs(x1 - x2) + Math.abs(y1 - y2);
        System.out.println("曼哈頓距離: " + manhattanDistance);

        // 計算切比雪夫距離
        double chebyshevDistance = Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
        System.out.println("切比雪夫距離: " + chebyshevDistance);

        // 計算點 (x1, y1) 和 (x2, y2) 的點積
        double dotProduct = (x1 * x2 + y1 * y2);
        
        // 計算向量的大小
        double magnitude1 = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
        double magnitude2 = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));
        
        // 防止除以零的情況
        if (magnitude1 == 0 || magnitude2 == 0) {
            System.out.println("無法計算夾角，因為一個向量的大小為零。");
        } 
	else {
            // 計算兩個向量的夾角
            double cosTheta = dotProduct / (magnitude1 * magnitude2);
            double angle = Math.acos(cosTheta) * (180 / Math.PI); // 將弧度轉換為度
            System.out.println("兩個向量的夾角: " + angle + "度");
        }

        // 關閉掃描器
        sc.close();
    }
}
