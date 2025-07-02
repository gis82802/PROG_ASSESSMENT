/*
filename: hw7_3
function: Matrix multiplication and matrix inversion with user input
author: PoXsun
date: 2024/10/25
version: 11.0.12
*/

import java.util.Scanner;

public class hw7_3 {
    public static void main(String args[]) {
	
        Scanner scanner = new Scanner(System.in);

        // Input Matrix A
        System.out.println("Enter number of rows for Matrix A: ");
        int rowsA = scanner.nextInt();
        System.out.println("Enter number of cols for Matrix A: ");
        int colsA = scanner.nextInt();

        int[][] matrixA = new int[rowsA][colsA];

        System.out.println("Enter elements of Matrix A: ");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        // Input Matrix B
        System.out.println("Enter number of rows for Matrix B: ");
        int rowsB = scanner.nextInt();
        System.out.println("Enter number of cols for Matrix B: ");
        int colsB = scanner.nextInt();

        int[][] matrixB = new int[rowsB][colsB];

        System.out.println("Enter elements of Matrix B: ");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        // Call matrix multiplication function
        if (colsA == rowsB) {
            int[][] result = MatMultiply(matrixA, matrixB);

            // Print matrix multiplication result
            System.out.println("Result of matrix multiplication: ");
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Matrix multiplication is not possible. Number of columns in Matrix A must equal number of rows in Matrix B.");
        }

        // Input Matrix C for inversion
        System.out.println("Now, let's invert a 2x2 matrix.");
        System.out.println("Enter elements for a 2x2 matrix C:");

        int[][] matrixC = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrixC[i][j] = scanner.nextInt();
            }
        }

        // Call matrix inversion function
        double[][] invResult = invMatrix(matrixC);
        if (invResult.length > 0) {
            System.out.println("Inverse of Matrix C:");
            for (int i = 0; i < invResult.length; i++) {
                for (int j = 0; j < invResult[i].length; j++) {
                    System.out.print(invResult[i][j] + " ");
                }
                System.out.println();
            }
        }

        scanner.close();
    }
    
    // Matrix multiplication function
    public static int[][] MatMultiply(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;
        
        int[][] result = new int[rowsA][colsB];
        
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                result[i][j] = 0;
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        
        return result;
    }

    // Matrix inversion for 2x2 matrix
    public static double[][] invMatrix(int[][] matrix) {
        // Ensure the matrix is 2x2
        if (matrix.length != 2 || matrix[0].length != 2) {
            System.out.println("Matrix inversion is only implemented for 2x2 matrices.");
            return new double[0][0]; // Return empty array if not 2x2 matrix
        }

        // Extract elements from matrix
        int a = matrix[0][0];
        int b = matrix[0][1];
        int c = matrix[1][0];
        int d = matrix[1][1];

        // Calculate determinant
        int det = a * d - b * c;

        if (det == 0) {
            System.out.println("Matrix is singular and cannot be inverted.");
            return new double[0][0]; // Return empty array if matrix is singular
        }

        // Create 2x2 inverse matrix
        double[][] inverse = new double[2][2];
        inverse[0][0] = d / (double) det;
        inverse[0][1] = -b / (double) det;
        inverse[1][0] = -c / (double) det;
        inverse[1][1] = a / (double) det;

        return inverse;
    }
}
