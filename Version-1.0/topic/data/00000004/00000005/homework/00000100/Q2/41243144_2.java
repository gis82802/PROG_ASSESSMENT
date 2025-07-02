/*
 * project name: hw_02
 * project author: 41243144温博鈞
 * project description: 計算兩點之間的距離
 * 
 * project function: 
 * - 輸入兩點的座標
 * - 計算並顯示兩點之間的距離
 * 
 * latest changed date: 10-04-2024
 */
package September.oct_04;

import java.util.Scanner;

public class hw02 {
    public static void main(String[] args) {
        /*
         * 程式主要執行區
         */
        double[] x = new double[2];
        double[] y = new double[2];

        //input
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter two point: ");
        x[0] = input.nextDouble();
        y[0] = input.nextDouble();
        x[1] = input.nextDouble();
        y[1] = input.nextDouble();

        // get euclidean distance
        System.out.println("Distance: " + get_euclidean_distance(x, y));

        input.close();
    }
    public static double get_euclidean_distance(double[] x, double[] y){
        /*
         * 計算歐式距離(兩膽之間距離)
         * d = qart((x2 - x1) ^ 2 + (y2 - y1) ^ 2)
         */
        return Math.sqrt(Math.pow(x[1] - x[0], 2) + Math.pow(y[1] - y[0], 2));
    }
}
