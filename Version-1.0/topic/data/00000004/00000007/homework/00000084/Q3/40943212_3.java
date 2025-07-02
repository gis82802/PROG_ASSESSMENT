/*
	filename:Java_1018_03
	function:陣列排序
	author:陳廷威 40943212
	datetime:2024/10/18
	version:1.0
*/

import java.util.Arrays;
import java.util.Scanner;

public class Java_1018_03 {
    public static void main(String[] args) {
        // 建立Scanner物件來讀取輸入
        Scanner scanner = new Scanner(System.in);

        // 請使用者輸入陣列的長度
        System.out.print("請輸入陣列的長度: ");
        int length = scanner.nextInt();

        // 建立一個指定長度的陣列
        int[] array = new int[length];

        // 讓使用者輸入陣列的每個元素
        System.out.println("請輸入陣列的元素:");
        for (int i = 0; i < length; i++) {
            System.out.print("第 " + (i + 1) + " 個元素: ");
            array[i] = scanner.nextInt();
        }

        // 印出原始陣列
        System.out.println("原始陣列: ");
        printArray(array);

        // 以後面元素的最大值替換當前元素
        int[] maxArray = replaceWithMax(array);

        // 印出以後面的最大值取代後的陣列
        System.out.println("以後面的最大值取代後的陣列: ");
        printArray(maxArray);

        // 以後面元素的最小值替換當前元素
        int[] minArray = replaceWithMin(array);

        // 印出以後面的最小值取代後的陣列
        System.out.println("以後面的最小值取代後的陣列: ");
        printArray(minArray);

        // 關閉Scanner物件
        scanner.close();
    }

    // 將陣列元素替換為後面的最大值
    public static int[] replaceWithMax(int[] array) {
        int length = array.length;
        int[] result = new int[length];

        // 最後一個元素設為 -1
        result[length - 1] = -1;

        // 從倒數第二個元素開始替換
        int max = array[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            result[i] = max;
            if (array[i] > max) {
                max = array[i];
            }
        }

        return result;
    }

    // 將陣列元素替換為後面的最小值
    public static int[] replaceWithMin(int[] array) {
        int length = array.length;
        int[] result = new int[length];

        // 最後一個元素設為 -1
        result[length - 1] = -1;

        // 從倒數第二個元素開始替換
        int min = array[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            result[i] = min;
            if (array[i] < min) {
                min = array[i];
            }
        }

        return result;
    }

    // 輸出陣列
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
