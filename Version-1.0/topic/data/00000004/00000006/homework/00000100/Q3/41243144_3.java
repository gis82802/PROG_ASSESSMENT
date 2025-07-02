/*
 * project name: Hw03
 * project author: 41243144温博鈞
 * project description: 將用戶輸入數值反轉之後print
 * 
 * project function: 
 * 1. 判斷number是否符合 well-ordered number
 * 2. 判斷number 內共有多少個well-orderded number
 * 
 * latest changed date: 10-11-2024
 */
package October.oct_11;

import java.util.Scanner;

public class Hw03 {
    public static void main(String[] args) {
        // 用戶輸入
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入欲反轉數值: ");
        int number = input.nextInt();

        System.out.println(String.format("%d 反轉之後結果為: %d", number, reverse_number(number)));
        input.close();
    }

    public static int reverse_number(int number){
        /*
         * 將number 反轉之後回傳
         * 
         * @param number 欲反轉數值
         * @return 反轉之後數值
         */

        int reverse_num = 0;

        // 重複將number最後數字丟進reverse_number直到number歸零
        while(number > 0){
            reverse_num = reverse_num * 10 + number % 10;
            number /= 10;
        }

        return reverse_num;
    }
}
