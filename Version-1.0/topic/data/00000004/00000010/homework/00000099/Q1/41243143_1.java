import java.util.Scanner;

public class work3{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // (a) �x�}����J�P�p�ⳡ��
        System.out.print("Enter rows and columns for matrix A: ");
        int rowsA = scanner.nextInt();
        int colsA = scanner.nextInt();
        int[][] matrixA = new int[rowsA][colsA];

        System.out.println("Enter elements of matrix A:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter rows and columns for matrix B: ");
        int rowsB = scanner.nextInt();
        int colsB = scanner.nextInt();
        double[][] matrixB = new double[rowsB][colsB];

        System.out.println("Enter elements of matrix B:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        // ����x�}�ۭ�
        double[][] result = MathMultiply(matrixA, matrixB);

        // ��X���G
        if (result != null) {
            System.out.println("Result of multiplication:");
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    System.out.printf("%d ", (int) Math.round(result[i][j]));
                }
                System.out.println();
            }
        } else {
            System.out.println("Matrix multiplication not possible.");
        }

        // (b) �p�� 2x2 ��}���ϯx�}
        System.out.print("Enter elements of a 2x2 matrix for inversion (a11 a12 a21 a22): ");
        int[][] matrixC = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrixC[i][j] = scanner.nextInt();
            }
        }

        // �p��ϯx�}
        double[][] inverse = invMatrix(matrixC);
        if (inverse != null) {
            System.out.println("Inverse of the matrix:");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.printf("%.2f ", inverse[i][j]);
                }
                System.out.println();
            }

            // ���Ҥϯx�}
            double[][] identity = MathMultiply(matrixC, inverse);
            System.out.println("Verification (original matrix * inverse):");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.printf("%.2f ", identity[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("Matrix inversion not possible.");
        }

        scanner.close();
    }

    public static double[][] MathMultiply(int[][] a, double[][] b) {
        if (a[0].length != b.length) {
            return null; // �L�k�ۭ��A��^ null
        }

        int rowsA = a.length;
        int colsA = a[0].length;
        int colsB = b[0].length;

        double[][] result = new double[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result; // ��^���G�x�}
    }

    public static double[][] invMatrix(int[][] matrix) {
        double[][] inverse = new double[2][2];
        double determinant = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);

        if (determinant == 0) {
            return null; // �L�k�p��ϯx�}�A��^ null
        }

        inverse[0][0] = matrix[1][1] / determinant;
        inverse[0][1] = -matrix[0][1] / determinant;
        inverse[1][0] = -matrix[1][0] / determinant;
        inverse[1][1] = matrix[0][0] / determinant;

        return inverse; // ��^�ϯx�}
    }
}
