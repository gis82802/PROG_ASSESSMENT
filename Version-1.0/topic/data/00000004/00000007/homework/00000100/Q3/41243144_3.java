/**
 * Project Name: Hw03
 * Author: 41243144 温博鈞
 * Description:
 *      輸入一連串的數字，輸出原始陣列，並輸出排序後的陣列
 * Functionality:
 *      - ArrayList<Integer>: 建立動態array
 *      - Scanner: 建立使用者輸入
 * 
 * Last Edit Date: 2024-10-18
 */
package October.oct_18;

import java.util.Scanner;
import java.util.ArrayList;

public class Hw03 {
    public static void main(String[] args) {
        // 建立使用者輸入
        Scanner input = new Scanner(System.in);
        // 初始化動態陣列
        ArrayList<Integer> array = new ArrayList<Integer>();

        System.out.print("請輸入陣列，以空格隔開(結束EOF): ");

        // 讀取使用者輸入放到動態陣列中
        while (input.hasNextInt()) {
            array.add(input.nextInt());
        }

        ArrayList<Integer> array_copy = new ArrayList<Integer>(array);

        // 輸出原始陣列
        System.out.print("原始陣列: ");
        System.out.println(array);


        // s = 陣列長度，初始max = -1
        int s = array.size();
        int max = -1;

        // 替換array[index]，並更新最大值
        for(int index = s-1; index >= 0; index--){
            int current_number = array.get(index);
            array.set(index, max);

            if(current_number > max){
                max = current_number;
            }
        }

        System.out.print("替換最大值陣列: ");
        System.out.println(array);

        int min = array_copy.get(s - 1);
        array_copy.set(s - 1, -1);

        // 替換array[index]，並更新最小值
        for(int index = s-2; index >= 0; index--){
            int current_number = array_copy.get(index);
            array_copy.set(index, min);

            if(current_number < min){
                min = current_number;
            }
        }

        System.out.print("替換最小值陣列: ");
        System.out.println(array_copy);

        input.close();
    }
}
