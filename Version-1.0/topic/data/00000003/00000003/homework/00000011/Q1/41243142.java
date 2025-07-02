// file name: app7_1
// author: 41243142
// version:
// function: 
// date: 24/10/25

import java.util.Scanner;

public class app7_1 {

    public static int[][] MatMultiply(int[][] matrixA, int[][] matrixB) {
        if (matrixA[0].length != matrixB.length) {
            return null; 
        }
        int[][] result = new int[matrixA.length][matrixB[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                for (int k = 0; k < matrixA[0].length; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return result; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入矩陣A的行數: ");
        int rowsA = scanner.nextInt();
        System.out.print("請輸入矩陣A的列數: ");
        int colsA = scanner.nextInt();
        int[][] matrixA = new int[rowsA][colsA];
        System.out.println("請輸入矩陣A的元素:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        System.out.print("請輸入矩陣B的行數: ");
        int rowsB = scanner.nextInt();
        System.out.print("請輸入矩陣B的列數: ");
        int colsB = scanner.nextInt();

        if (colsA != rowsB) {
            System.out.println("無法進行矩陣相乘。");
            return;
        }

        int[][] matrixB = new int[rowsB][colsB];
        System.out.println("請輸入矩陣B的元素:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        int[][] result = MatMultiply(matrixA, matrixB);

        if (result != null) {
            System.out.println("矩陣乘法的結果為:");
            for (int[] row : result) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("null");
        }

        scanner.close();
    }
}
