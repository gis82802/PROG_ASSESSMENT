import java.util.Scanner;

public class MatrixInverse {

    public static double[][] invMatrix(double[][] A) {
        // Ensure the matrix is 2x2
        if (A.length != 2 || A[0].length != 2) {
            return null;
        }

        // Calculate the determinant
        double determinant = A[0][0] * A[1][1] - A[0][1] * A[1][0];

        // If the determinant is 0, return null (not invertible)
        if (determinant == 0) {
            return null;
        }

        // Calculate the inverse matrix
        double[][] inverse = new double[2][2];
        inverse[0][0] = A[1][1] / determinant;
        inverse[0][1] = -A[0][1] / determinant;
        inverse[1][0] = -A[1][0] / determinant;
        inverse[1][1] = A[0][0] / determinant;

        return inverse;
    }

    public static double[][] multiplyMatrices(double[][] A, double[][] B) {
        double[][] result = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = A[i][0] * B[0][j] + A[i][1] * B[1][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] A = new double[2][2];

        // Input 2x2 matrix
        System.out.println("Please enter the elements of a 2x2 matrix (separated by spaces):");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                A[i][j] = scanner.nextDouble();
            }
        }

        double[][] inverse = invMatrix(A);

        if (inverse != null) {
            System.out.println("Inverse Matrix:");
            for (double[] row : inverse) {
                for (double value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }

            // Validate the result of the inverse matrix
            double[][] identity = multiplyMatrices(A, inverse);
            System.out.println("Validation Result (A * A^-1):");
            for (double[] row : identity) {
                for (double value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("The matrix is not invertible, returning null.");
        }

        scanner.close();
    }
}
