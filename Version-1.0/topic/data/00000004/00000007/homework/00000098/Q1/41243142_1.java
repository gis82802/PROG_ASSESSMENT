// file name: app6_1
// author: 41243142
// version:
// function: 
// date: 24/10/18

import java.util.Scanner;

public class app6_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("�п�J�}�C�j�p: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        
        System.out.println("�п�J " + size + " �Ӿ��:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("�Ƨǫe���}�C: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.print("�Ƨǫ᪺�}�C: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}