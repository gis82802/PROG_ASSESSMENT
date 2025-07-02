public class MatrixMultiplier {

    public static int[][] matMultiply(int[][] A, int[][] B) {
        // Check if the matrices can be multiplied
        if (A[0].length != B.length) {
            return null;
        }

        // Initialize the result matrix
        int rowsA = A.length;
        int colsB = B[0].length;
        int[][] result = new int[rowsA][colsB];

        // Perform matrix multiplication
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test example
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] B = {
            {7, 8 ,9},
            {10, 11 ,12}
        };

        int[][] result = matMultiply(A, B);

        if (result != null) {
            for (int[] row : result) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("null");
        }
    }
}
