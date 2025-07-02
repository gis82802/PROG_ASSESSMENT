/*
	filename:Java_1018_04
	function:二維陣列
	author:陳廷威 40943212
	datetime:2024/10/18
	version:1.0
*/

import java.util.Scanner;

public class Java_1018_04 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入矩陣大小 n (n <= 4): ");
        int n = scanner.nextInt();

        if (n <= 0 || n > 4) {
            System.out.println("請輸入 1 到 4 之間的 n 值。");
            return;
        }

        int[][] matrix = new int[n][n];

        System.out.println("請輸入矩陣的元素:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("請輸入 matrix[" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("輸入的矩陣是:");
        printMatrix(matrix, n);

        System.out.print("請輸入要移除的行號 (1-" + n + "): ");
        int removeRow = scanner.nextInt() - 1; // 將 1-based 轉換為 0-based
        System.out.print("請輸入要移除的列號 (1-" + n + "): ");
        int removeCol = scanner.nextInt() - 1; // 將 1-based 轉換為 0-based


        if (removeRow < 0 || removeRow >= n || removeCol < 0 || removeCol >= n) {
            System.out.println("行號或列號不在範圍內。");
            return;
        }

        int[][] newMatrix = createSubMatrix(matrix, n, removeRow, removeCol);

        System.out.println("移除第 " + (removeRow + 1) + " 行和第 " + (removeCol + 1) + " 列後的矩陣是:");
        printMatrix(newMatrix, n - 1);

        int determinant = calculateDeterminant(newMatrix, n - 1);
        System.out.println("新矩陣的行列式是: " + determinant);

        scanner.close();
    }

    public static void printMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 創建子矩陣，去掉第 removeRow 行和 removeCol 列
    public static int[][] createSubMatrix(int[][] matrix, int size, int removeRow, int removeCol) {
        int[][] subMatrix = new int[size - 1][size - 1];
        int subRow = 0, subCol = 0;

        for (int i = 0; i < size; i++) {
            if (i == removeRow) continue; // 跳過移除的行
            subCol = 0;
            for (int j = 0; j < size; j++) {
                if (j == removeCol) continue; // 跳過移除的列
                subMatrix[subRow][subCol] = matrix[i][j];
                subCol++;
            }
            subRow++;
        }

        return subMatrix;
    }

    // 計算矩陣的行列式 (遞迴)
    public static int calculateDeterminant(int[][] matrix, int size) {
        if (size == 1) {
            return matrix[0][0];
        }

        if (size == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int determinant = 0;

        for (int col = 0; col < size; col++) {
            // 創建子矩陣
            int[][] subMatrix = createSubMatrix(matrix, size, 0, col);
            // 計算行列式 (遞迴)
            determinant += Math.pow(-1, col) * matrix[0][col] * calculateDeterminant(subMatrix, size - 1);
        }

        return determinant;
    }
}

