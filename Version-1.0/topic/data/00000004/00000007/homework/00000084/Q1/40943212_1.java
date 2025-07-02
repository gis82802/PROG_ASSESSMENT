/*
	filename:Java_1018_01
	function:陣列排序
	author:陳廷威 40943212
	datetime:2024/10/18
	version:1.0
*/

import java.util.Arrays;
import java.util.Scanner;

public class Java_1018_01 {
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("請輸入陣列的長度: ");
        int length = scanner.nextInt();

        int[] array = new int[length];

        System.out.println("請輸入陣列的元素:");
        for (int i = 0; i < length; i++) {
            System.out.print("第 " + (i + 1) + " 個元素: ");
            array[i] = scanner.nextInt();
        }

        System.out.println("排序前的陣列: " + Arrays.toString(array));

        // 使用Arrays.sort進行排序
        Arrays.sort(array);

        System.out.println("排序後的陣列: " + Arrays.toString(array));

        scanner.close();
    }
}



