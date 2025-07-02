/**
 * Project Name: Hw01
 * Author: 41243144 温博鈞
 * Description:
 *      輸入一連串的數字，輸出原始陣列，並輸出排序後的陣列
 * Functionality:
 *      - ArrayList<Integer>: 建立動態array
 *      - Scanner: 建立使用者輸入
 *      - Collections: 用來排序陣列
 * 
 * Last Edit Date: 2024-10-18
 */

package October.oct_18;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Hw01 {
    public static void main(String[] args) {
        // 建立使用者輸入
        Scanner input = new Scanner(System.in);
        // 建立動態陣列
        ArrayList<Integer> array = new ArrayList<Integer>();

        System.out.print("請輸入陣列元素(以空格或換行隔開，EOF結束輸入): ");

        // 將使用者輸入存到陣列中
        while(input.hasNextInt()){
            array.add(input.nextInt());
        }

        // 輸出排序前陣列
        System.out.println("排序前: " + array);

        // 排序陣列後輸出
        Collections.sort(array);
        System.out.println("排序後: " + array);

        input.close();
    }
}
