/*
 * project name: Hw01
 * project author: 41243144温博鈞
 * project description: 計算近似的 pi 值，並找出使 pi 值接近 3.14159 的最小 i 值。
 * 
 * project function: 
 * 1. 輸入一個整數 i，計算 pi 的近似值。
 * 2. 使用公式找到使 pi 接近 3.14159 的最小循環次數。
 * 
 * latest changed date: 10-11-2024
 */
package October.oct_11;

import java.util.Scanner;

public class Hw01 {
    public static void main(String[] args) {
        // 使用者輸入 i 值
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入i: ");
        // 計算並顯示 pi 值
        double result = caculate_pi(input.nextInt());

        System.out.println(String.format("pi值為: %.6f", result));

        // 找到使 pi 接近 3.14159 的最小循環次數
        System.out.println("找到3.14159最小i值: " + get_minium());

        input.close();
    }
    
    // 使用循環法計算 pi 值
    public static double caculate_pi(int number){
        /*
         * pi = 4 * (1 - 1/3 + 1/5 - 1/7 + 1/9 - ...)
         * 
         * @param number 用戶指定的循環次數
         * @return 近似 pi 值
         */

        double pi = 0.0;

        // 根據指定的循環次數計算 pi
        for(int i = 0; i <= number; i++){
            pi += Math.pow(-1, i) / (2 * i + 1);
        }

        return pi * 4;
    }

    // 找出使 pi 接近 3.14159 的最小循環次數
    public static int get_minium(){
        /*
         * 函數通過逐步增加 i 值來找到最小循環次數，使 pi 值與 3.14159 足夠接近（誤差小於 0.00001）。
         * 
         * @return 最小的循環次數 i
         */

        double target = 3.14159;
        int number = 0;
        double pi = 0; 

        // 不斷循環直到 pi 值與目標之間的誤差小於 0.00001
        while (Math.abs(4 * pi - target) >= 0.00001){
            pi += Math.pow(-1, number) / (2 * number + 1);
            number++;
        }

        return number;
    }
}
