public class ex3 {

    // Function to multiply two matrices
    public static double[][] MatMultiply(double[][] A, double[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        // If the matrices cannot be multiplied, return null
        if (colsA != rowsB) {
            return null;
        }

        // Initialize result matrix
        double[][] result = new double[rowsA][colsB];

        // Perform matrix multiplication
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }

    // Function to calculate the inverse of a 2x2 matrix
    public static double[][] invMatrix(double[][] matrix) {
        if (matrix.length != 2 || matrix[0].length != 2) {
            throw new IllegalArgumentException("Matrix must be 2x2");
        }

        double det = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        // If the determinant is zero, return null (no inverse)
        if (det == 0) {
            return null;
        }

        // Calculate the inverse matrix
        double[][] inv = new double[2][2];
        inv[0][0] = matrix[1][1] / det;
        inv[0][1] = -matrix[0][1] / det;
        inv[1][0] = -matrix[1][0] / det;
        inv[1][1] = matrix[0][0] / det;

        return inv;
    }

    // Function to verify if the inverse matrix is correct
    public static boolean verifyInvMatrix(double[][] matrix) {
        double[][] inv = invMatrix(matrix);
        if (inv == null) {
            return false;
        }

        double[][] identity = MatMultiply(matrix, inv);

        // Check if the result is the identity matrix
        if (identity != null) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (i == j && Math.abs(identity[i][j] - 1) > 1e-9) {
                        return false;
                    } else if (i != j && Math.abs(identity[i][j]) > 1e-9) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    // Function to print a matrix
    public static void printMatrix(String name, double[][] matrix) {
        System.out.println(name + " = ");
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test matrix multiplication
        double[][] A = {
                {1, 2},
                {3, 4}
        };
        double[][] B = {
                {2, 0},
                {1, 2}
        };

        // Print matrices A and B before multiplication
        printMatrix("Matrix A", A);
        printMatrix("Matrix B", B);

        double[][] result = MatMultiply(A, B);
        if (result != null) {
            printMatrix("A * B", result);
        } else {
            System.out.println("Matrices cannot be multiplied");
        }

        // Test inverse matrix
        double[][] matrix = {
                {4, 7},
                {2, 6}
        };

        // Print matrix before calculating the inverse
        printMatrix("Matrix to be inverted", matrix);

        double[][] inverse = invMatrix(matrix);
        if (inverse != null) {
            printMatrix("Inverse matrix", inverse);
        } else {
            System.out.println("Matrix has no inverse");
        }

        // Verify the inverse matrix
        if (verifyInvMatrix(matrix)) {
            System.out.println("Inverse matrix is correct");
        } else {
            System.out.println("Inverse matrix is incorrect");
        }
    }
}
