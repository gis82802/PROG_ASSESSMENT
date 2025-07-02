/*
 * project name: hw_0.
 * project author: 41243144温博鈞
 * project description: 判斷3個數字大小
 * 
 * project function: 
 * - 輸入3個數字
 * - 比較3個數字大小
 * 
 * latest changed date: 10-04-2024
 */
package September.oct_04;

import java.util.Scanner;

public class hw03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] number = new double[3];

        // input 
        System.out.print("請輸入3個值: ");
        for (int i = 0; i < number.length; i++) {
            number[i] = input.nextDouble();
        }

        // 輸出結果
        System.out.println(compare(number));

        input.close();
    }
    public static String compare(double[] number){
        String result = number[0] > number[1] 
        ? (number[0] > number[2] 
            ? (number[1] > number[2] 
                ? String.format("%.2f > %.2f > %.2f", number[0], number[1], number[2]) 
                : String.format("%.2f > %.2f > %.2f", number[0], number[2], number[1])) 
            : String.format("%.2f > %.2f > %.2f", number[2], number[0], number[1])) 
        : (number[1] > number[2] 
            ? (number[0] > number[2] 
                ? String.format("%.2f > %.2f > %.2f", number[1], number[0], number[2]) 
                : String.format("%.2f > %.2f > %.2f", number[1], number[2], number[0])) 
            : String.format("%.2f > %.2f > %.2f", number[2], number[1], number[0]));

        return result;
    }

}
