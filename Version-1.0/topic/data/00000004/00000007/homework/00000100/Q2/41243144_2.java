/**
 * Project Name: Hw02
 * Author: 41243144 温博鈞
 * Description:
 *      輸入三角形高度，輸出三角形，接著輸出使用者指定數字座標
 * Functionality:
 *      - Scanner: 建立使用者輸入
 *      - Math: 計算開根號sqrt()以及Ceil()無條件捨去
 * 
 * Last Edit Date: 2024-10-18
 */

package October.oct_18;

import java.util.Scanner;
import java.lang.Math;

public class Hw02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入三角形高度: ");
        int height = input.nextInt();

        // S = (1 + height) * height / 2
        String[][] array = new String[height][(1 + height) * height / 2];

        for(int i=0; i < array.length; i++){
            for(int j=0; j < i + 1; j++){
                array[i][j] = "*";
            }
            for(int j= i + 1; j < array[i].length; j++){
                array[i][j] = "";
            }
            System.out.println(String.join("", array[i]));
        }

        System.out.print("請輸入欲尋找數字: ");
        int number = input.nextInt();

        // (1 + height) * height / 2 < number
        // height + height^2 < 2 * number
        // height^2 + height - 2 * number < 0
        // ( -b + sqrt(b^2 - 4ac) / 2a
        // a = 1 b = 1 c = -2*number

        int row = (int) Math.ceil((-1 + Math.sqrt(1 + 8 * (double) number)) / 2);

        System.out.println(String.format("row: %d\ncol: %d", row - 1, number - (row - 1) * (row - 2) / 2 - 1));

        input.close();
    }
}