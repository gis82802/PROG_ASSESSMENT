import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the size of the matrix
        System.out.print("Input a number, and number <= 4: ");
        int n = sc.nextInt();

        // Ensure the user input does not exceed 4
        if (n > 4) {
            System.out.println("Number must be <= 4");
            return;
        }

        int[][] arr = new int[n][n];

        // Input n*n numbers
        System.out.printf("Input %d numbers: ", n * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // Print the matrix
        System.out.println("\nThe matrix is: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }

        // Print the determinant result
        System.out.printf("Answer is: %d\n", Determinant(arr));

        // user input two numbers
        System.out.printf("\nInput one number (row to delete, number <= %d): ", n - 1);
        int row = sc.nextInt();
        System.out.printf("Input one number (column to delete, number <= %d): ", n - 1);
        int col = sc.nextInt();

        if (row >= n || col >= n || row < 0 || col < 0) {
            System.out.println("Invalid input. Row and column must be within the matrix size.");
            return;
        }

        int[][] newMatrix = new int[n - 1][n - 1];
        int new_row = 0;

        // Create the new matrix by skipping the selected row and column
        for (int i = 0; i < n; i++) { // Fix the range to n
            if (i == row) continue; // Skip the selected row
            int new_col = 0;
            for (int j = 0; j < n; j++) { // Fix the range to n
                if (j == col) continue; // Skip the selected column
                newMatrix[new_row][new_col] = arr[i][j];
                new_col++;
            }
            new_row++;
        }

        // Print the new matrix after deletion
        System.out.println("\nThe new matrix is: ");
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.printf("%d ", newMatrix[i][j]);
            }
            System.out.println();
        }

        System.out.printf("The new matrix answer is: %d\n", Determinant(newMatrix));
    }

    // Determinant calculation
    public static int Determinant(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];
        if (n == 2) return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        int det = 0;
        for (int i = 0; i < n; i++) {
            int[][] subMatrix = new int[n - 1][n - 1];
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k < i) subMatrix[j - 1][k] = matrix[j][k];
                    else if (k > i) subMatrix[j - 1][k - 1] = matrix[j][k];
                }
            }
            det += Math.pow(-1, i) * matrix[0][i] * Determinant(subMatrix);
        }
        return det;
    }
}
