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
        System.out.print("�п�J�x�}A�����: ");
        int rowsA = scanner.nextInt();
        System.out.print("�п�J�x�}A���C��: ");
        int colsA = scanner.nextInt();
        int[][] matrixA = new int[rowsA][colsA];
        System.out.println("�п�J�x�}A������:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        System.out.print("�п�J�x�}B�����: ");
        int rowsB = scanner.nextInt();
        System.out.print("�п�J�x�}B���C��: ");
        int colsB = scanner.nextInt();

        if (colsA != rowsB) {
            System.out.println("�L�k�i��x�}�ۭ��C");
            return;
        }

        int[][] matrixB = new int[rowsB][colsB];
        System.out.println("�п�J�x�}B������:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        int[][] result = MatMultiply(matrixA, matrixB);

        if (result != null) {
            System.out.println("�x�}���k�����G��:");
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
