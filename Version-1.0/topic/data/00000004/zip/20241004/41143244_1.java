/*
 * project name: hw_01
 * project author: 41243144温博鈞
 * project description: 計算兩點之間的各種距離（歐式距離、曼哈頓距離、切比雪夫距離），
 *                      並輸出兩點之間的直線方程式。
 * 
 * project function: 
 * - 輸入兩點的座標
 * - 計算並顯示兩點之間的直線方程式
 * - 計算並顯示兩點之間的歐式距離、曼哈頓距離和切比雪夫距離
 * 
 * latest changed date: 10-04-2024
 */
package September.oct_04;

import java.util.Scanner;
import java.lang.Math;

public class hw_01 {
    public static void main(String[] args) {
        /* 
         * 主要執行區
         */
        Scanner input = new Scanner(System.in);
        double []x = new double[2];
        double []y = new double[2];

        // input
        System.out.print("x1: ");
        x[0] = input.nextDouble();
        System.out.print("y1: ");
        y[0] = input.nextDouble();
        System.out.print("x2: ");
        x[1] = input.nextDouble();
        System.out.print("y2: ");
        y[1] = input.nextDouble();

        // 取得直線方程式  歐式距離 曼哈頓距離 切比雪夫距離
        System.out.println("Line equation: " + get_line_equation(x, y));
        System.out.println("Euclidean distance: " + get_euclidean_distance(x, y));
        System.out.println("Manhattan distance: " + get_manhattan_distance(x, y));
        System.out.println("Chebyshev distance: " + get_chebyshev_distance(x, y));

        input.close();
    }

    public static String get_line_equation(double[] x, double[] y){
        /*
         * 計算兩點直線方程式
         * y = mx + b
         * m = (y2 - y1) / (x2 - x1)
         * b = y1 - m * x1
         */
        if (x[1] == x[0]){
            return String.format("x = %.1f", x[1]);
        }

        double m = (y[1] - y[0]) / (x[1] - x[0]);

        double b = y[0] - m * x[0];
        return String.format("y = %.1f %+.1f", m,b);
    }

    public static double get_euclidean_distance(double[] x, double[] y){
        /*
         * 計算歐式距離 
         * d = qart((x2 - x1) ^ 2 + (y2 - y1) ^ 2)
         */
        return Math.sqrt(Math.pow(x[1] - x[0], 2) + Math.pow(y[1] - y[0], 2));
    }

    public static double get_manhattan_distance(double[] x, double[] y){
        /*
         * 計算曼哈頓距離
         * d = | x2 - x1 | + | y2 - y1 |
         */
        return Math.abs(x[1] - x[0]) + Math.abs(y[1] - y[0]);
    }

    public static double get_chebyshev_distance(double[] x, double[] y){
        /*
         * 計算切比雪夫距離
         * d = max(| x2 - x1 | , | y2 - y1 |)
         */
        return Math.max(Math.abs(x[1] - x[0]), Math.abs(y[1] - y[0]));
    }
    
}
