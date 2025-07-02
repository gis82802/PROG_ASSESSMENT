import java.util.Scanner;

public class matwork2 {

    public static double[][] MatMultiply(double[][] a, double[][] b) {
        if (a[0].length != b.length) {
            return null; 
        }

        double[][] result = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    public static double[][] invMatrix(double[][] matrix) {
        if (matrix.length != 2 || matrix[0].length != 2) {
            return null; 
        }

        double determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        if (determinant == 0) {
            return null; 
        }

        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / determinant;
        inverse[0][1] = -matrix[0][1] / determinant;
        inverse[1][0] = -matrix[1][0] / determinant;
        inverse[1][1] = matrix[0][0] / determinant;

        return inverse; 
    }

    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                if (val == (int) val) {
                    System.out.printf("%d ", (int) val);
                } else {
                    System.out.printf("%.2f ", val);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number of rows for Matrix A: ");
        int rowsA = scanner.nextInt();
        System.out.print("Enter the number of columns for Matrix A: ");
        int colsA = scanner.nextInt();
        double[][] matrixA = new double[rowsA][colsA];

        
        System.out.println("Enter the values for Matrix A:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                matrixA[i][j] = scanner.nextDouble();
            }
        }

        
        System.out.print("Enter the number of rows for Matrix B: ");
        int rowsB = scanner.nextInt();
        System.out.print("Enter the number of columns for Matrix B: ");
        int colsB = scanner.nextInt();
        double[][] matrixB = new double[rowsB][colsB];

        System.out.println("Enter the values for Matrix B:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matrixB[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Matrix A:");
        printMatrix(matrixA);
        System.out.println("Matrix B:");
        printMatrix(matrixB);

        double[][] productAB = MatMultiply(matrixA, matrixB);
        if (productAB != null) {
            System.out.println("Product of A and B:");
            printMatrix(productAB);
        } else {
            System.out.println("Matrices cannot be multiplied.");
        }

        double[][] inverseA = invMatrix(matrixA);
        if (inverseA != null) {
            System.out.println("Inverse of Matrix A:");
            printMatrix(inverseA);

            double[][] productAI = MatMultiply(matrixA, inverseA);
            System.out.println("Product of A and Inverse of A:");
            printMatrix(productAI);
        } else {
            System.out.println("Matrix A is not invertible.");
        }

        scanner.close();
    }
}
