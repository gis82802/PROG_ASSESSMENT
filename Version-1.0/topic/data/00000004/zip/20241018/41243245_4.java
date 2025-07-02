import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the matrix n (n <= 4): ");
        int n = scanner.nextInt();
        
        // Check if n is within the valid range
        if (n > 4 || n < 1) {
            System.out.println("The value of n is out of range. Please enter a number between 1 and 4.");
            return;
        }
        
        int[][] matrix = new int[n][n];

        // Input the elements of the matrix
        System.out.println("Enter the elements of the " + n + "x" + n + " matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("matrix[" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Output the original matrix
        System.out.println("The original matrix is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Input the row (i) and column (j) to remove
        System.out.print("Enter the row to remove (i): ");
        int rowToRemove = scanner.nextInt();
        System.out.print("Enter the column to remove (j): ");
        int colToRemove = scanner.nextInt();

        // Check if the row and column indices are valid
        if (rowToRemove < 0 || rowToRemove >= n || colToRemove < 0 || colToRemove >= n) {
            System.out.println("Invalid row or column index.");
            return;
        }

        // Create the new matrix by removing row i and column j
        int newSize = n - 1;
        int[][] newMatrix = new int[newSize][newSize];
        
        int newRow = 0, newCol;
        for (int i = 0; i < n; i++) {
            if (i == rowToRemove) continue;  // Skip the removed row
            newCol = 0;
            for (int j = 0; j < n; j++) {
                if (j == colToRemove) continue;  // Skip the removed column
                newMatrix[newRow][newCol] = matrix[i][j];
                newCol++;
            }
            newRow++;
        }

        // Output the new matrix
        System.out.println("The new matrix after removing row " + rowToRemove + " and column " + colToRemove + " is:");
        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // Calculate and print the determinant of the new matrix (only for 2x2 or 3x3 matrices)
        if (newSize == 2) {
            int determinant = newMatrix[0][0] * newMatrix[1][1] - newMatrix[0][1] * newMatrix[1][0];
            System.out.println("The determinant of the new 2x2 matrix is: " + determinant);
        } else if (newSize == 3) {
            int determinant = newMatrix[0][0] * (newMatrix[1][1] * newMatrix[2][2] - newMatrix[1][2] * newMatrix[2][1])
                            - newMatrix[0][1] * (newMatrix[1][0] * newMatrix[2][2] - newMatrix[1][2] * newMatrix[2][0])
                            + newMatrix[0][2] * (newMatrix[1][0] * newMatrix[2][1] - newMatrix[1][1] * newMatrix[2][0]);
            System.out.println("The determinant of the new 3x3 matrix is: " + determinant);
        } else {
            System.out.println("The determinant calculation is only supported for 2x2 and 3x3 matrices.");
        }

        scanner.close();
    }
}
