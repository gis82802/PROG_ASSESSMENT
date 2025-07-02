/*
filename: hw6_2
function: Print triangle and search number
author: PoXsun
date: 2024/10/18
version: 11.0.12
*/

import java.util.Scanner;

public class hw6_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 提示使用者輸入高度
        System.out.print("請輸入下三角形的高度 (1-20): ");
        int n = scanner.nextInt();
        
        // 確保輸入的高度符合要求
        if (n > 0 && n <= 20) {
            // 建立並顯示下三角形
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print("* ");
                }
                System.out.println(); // 換行
            }
        } else {
            System.out.println("輸入錯誤，請輸入1到20之間的數字。");
            return; // 結束程式
        }
        
        // 建立一個二維陣列來儲存數字，最大行數和列數由 n 決定
        int[][] arr = new int[n][n];

        // 初始化下三角形陣列，計數器從1開始，直到小於100,000
        int count = 1; // 計數器
        for (int i = 0; i < n && count < 100000; i++) {
            for (int j = 0; j <= i && count < 100000; j++) {
                arr[i][j] = count++;
            }
        }

        // 提示使用者要尋找的數字
        System.out.print("請輸入要尋找的小於 100,000 的數字: ");
        int find = scanner.nextInt();

        if (find >= 100000) {
            System.out.println("輸入的數字必須小於 100,000");
            return; // 結束程式
        }

        boolean found = false;
        int row = -1;
        int col = -1;

        // 尋找數字的位置
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr[i][j] == find) {
                    row = i;
                    col = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        // 輸出結果
        if (found) {
            System.out.println("數字 " + find + " 位於: 第 " + (row + 1) + " 行, 第 " + (col + 1) + " 列");
        } else {
            System.out.println("找不到數字 " + find);
        }

        scanner.close();
    }
}
