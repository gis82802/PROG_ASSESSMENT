/*
filename: hw6_3
function: Replace each element with the maximum and minimum values after it (excluding itself)
author: PoXsun
date: 2024/10/18
version: 11.0.12
*/

import java.util.Scanner;

public class hw6_3 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Input the size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        int[] maxArr = new int[n];
        int[] minArr = new int[n];

        // Input array elements
        System.out.println("Input the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Display array before modification
        System.out.print("Before modification: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Replace each element with the maximum value after it (excluding itself)
        for (int i = 0; i < n - 1; i++) {
            int maxAfter = arr[i + 1]; // Initialize maxAfter with the next element
            for (int j = i + 2; j < n; j++) {
                if (arr[j] > maxAfter) {
                    maxAfter = arr[j];
                }
            }
            maxArr[i] = maxAfter;
        }
        maxArr[n - 1] = -1; // The last element has no element after it, so assign -1

        // Replace each element with the minimum value after it (excluding itself)
        for (int i = 0; i < n - 1; i++) {
            int minAfter = arr[i + 1]; // Initialize minAfter with the next element
            for (int j = i + 2; j < n; j++) {
                if (arr[j] < minAfter) {
                    minAfter = arr[j];
                }
            }
            minArr[i] = minAfter;
        }
        minArr[n - 1] = -1; // The last element has no element after it, so assign -1

        // Display maxArr after modification
        System.out.print("Array after replacing with max values: ");
        for (int i = 0; i < n; i++) {
            System.out.print(maxArr[i] + " ");
        }
        System.out.println();

        // Display minArr after modification
        System.out.print("Array after replacing with min values: ");
        for (int i = 0; i < n; i++) {
            System.out.print(minArr[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
