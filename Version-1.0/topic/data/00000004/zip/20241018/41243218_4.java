import java.util.Scanner;

public class homework101804 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入矩陣大小 n (n <= 4): ");
        int n = scanner.nextInt();
        if (n > 4 || n < 1) {
            System.out.println("n 應該在 1 到 4 之間");
            return;
        }

        int[][] matrix = new int[n][n];

        
        System.out.println("請輸入矩陣內容:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("原始矩陣:");
        printMatrix(matrix);

      
        System.out.print("請輸入要刪除的行 (1 到 " + n + "): ");
        int rowToDelete = scanner.nextInt() - 1;
        System.out.print("請輸入要刪除的列 (1 到 " + n + "): ");
        int colToDelete = scanner.nextInt() - 1;

        if (rowToDelete < 0 || rowToDelete >= n || colToDelete < 0 || colToDelete >= n) {
            System.out.println("超出範圍");
            return;
        }

        int[][] newMatrix = deleteRowCol(matrix, rowToDelete, colToDelete);
        System.out.println("\n刪除第 " + (rowToDelete + 1) + " 行和第 " + (colToDelete + 1) + " 列後的矩陣:");
        printMatrix(newMatrix);

        int determinant = calculateDeterminant(newMatrix);
        System.out.println("\n新矩陣的行列式: " + determinant);
    }

    public static int[][] deleteRowCol(int[][] matrix, int row, int col) {
        int n = matrix.length;
        int[][] newMatrix = new int[n - 1][n - 1];
        int r = 0, c;
        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            c = 0;
            for (int j = 0; j < n; j++) {
                if (j == col) continue;
                newMatrix[r][c] = matrix[i][j];
                c++;
            }
            r++;
        }
        return newMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];//1*1矩陣
        } else if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];//2*2矩陣
        } else if (n == 3) {
            return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) 
                 - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]) 
                 + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);//3*3矩陣
        }
        return 0; 
    }
}
