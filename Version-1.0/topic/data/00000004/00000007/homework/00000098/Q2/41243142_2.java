// file name: app6_2
// author: 41243142
// version:
// function: 
// date: 24/10/18

import java.util.Scanner;

public class app6_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("請輸入陣列大小: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        
        System.out.println("請輸入 " + size + " 個整數:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("原始陣列: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] maxArray = new int[size];
        for (int i = 0; i < size; i++) {
            if (i + 1 < size) { 
                int max = arr[i + 1];
                for (int j = i + 1; j < size; j++) {
                    if (arr[j] > max) {
                        max = arr[j];
                    }
                }
                maxArray[i] = max;
            } else {
                maxArray[i] = -1; 
            }
        }
        int[] minArray = new int[size];
        for (int i = 0; i < size; i++) {
            if (i + 1 < size) {
                int min = arr[i + 1];
                for (int j = i + 1; j < size; j++) {
                    if (arr[j] < min) {
                        min = arr[j];
                    }
                }
                minArray[i] = min;
            } else {
                minArray[i] = -1; 
            }
        }

        System.out.print("最大值取代陣列: ");
        for (int num : maxArray) { 
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("最小值取代陣列: ");
        for (int num : minArray) { 
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
