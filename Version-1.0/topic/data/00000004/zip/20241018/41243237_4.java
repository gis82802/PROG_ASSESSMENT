/*
filename: hw6_4
function: Calculation of matrices
author: PoXsun
date: 2024/10/18
version: 11.0.12
*/

import java.util.Scanner;

public class hw6_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 提示使用者輸入矩陣高度
        System.out.print("請輸入矩陣高度 (n<=4): ");
        int n = scanner.nextInt();
        
        // 確保輸入的高度符合要求
        if (n > 4) {
            System.out.println("輸入的矩陣高度已超過範圍");
            return;
        }
        
        int[][] matrix = new int[n][n];

        // 提示使用者輸入矩陣內容
        System.out.println("請輸入矩陣的內容 " + n + " x " + n + ":");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // 打印輸入的矩陣內容
        System.out.println("輸入的矩陣內容:");
        for (int i = 0; i < n; i++) {
            System.out.print("| ");
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
	
        // 提示使用者要刪去的行和列
        System.out.print("輸入要刪去掉的列 行: ");
        int ri = scanner.nextInt();
        int rj = scanner.nextInt();

        // 創建新的矩陣，用來存取刪減過的矩陣
        int[][] rmatrix = new int[n-1][n-1];
        int newRow = 0, newCol = 0;

        // 將舊矩陣中的元素複製到新矩陣中，跳過指定的行和列
        for (int i = 0; i < n; i++) {
            if (i+1 == ri) continue;  // 跳過指定的行
            newCol = 0;
            for (int j = 0; j < n; j++) {
                if (j+1 == rj) continue;  // 跳過指定的列
                rmatrix[newRow][newCol] = matrix[i][j];
                newCol++;
            }
            newRow++;
        }

        // 打印刪除行和列後的矩陣
        System.out.println("刪除後的矩陣內容:");
        for (int i = 0; i < n-1; i++) {
            System.out.print("| ");
            for (int j = 0; j < n-1; j++) {
                System.out.print(rmatrix[i][j] + " ");
            }
            System.out.println("|");
        }

	if (n-1 == 2) {
            // 若是2x2矩陣，使用直接公式
            int determinant = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
            System.out.println("刪除行列後的矩陣行列式為: " + determinant);
        } else if (n-1 == 3) {
            // 若是3x3矩陣，使用3x3行列式公式
            int determinant = matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
             - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
             + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
            System.out.println("刪除行列後的矩陣行列式為: " + determinant);
        }
	
        scanner.close();
    }
}
