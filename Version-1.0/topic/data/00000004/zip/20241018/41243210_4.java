import java.util.Scanner;

public class hw4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入一個 nxn 陣列 (n <= 4): ");
        int n = scanner.nextInt();

        if (n < 1 || n > 4) {
            System.out.println("數字必須在 1 到 4 之間。");
            return;
        }

        int[][] matrix = new int[n][n];
        System.out.println("請輸入陣列的元素:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("原始矩陣:");
        printMatrix(matrix);
        System.out.print("請輸入要刪去的第 i 列和 j 行: ");
        int i = scanner.nextInt() - 1; 
        int j = scanner.nextInt() - 1;
        if (i < 0 || i >= n || j < 0 || j >= n) {
            System.out.println("列或行的索引超出範圍。");
            return;
        }
        int[][] newMatrix = new int[n - 1][n - 1];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row != i && col != j) {
                    newMatrix[row < i ? row : row - 1][col < j ? col : col - 1] = matrix[row][col];
                }
            }
        }

        System.out.println("去掉第 " + (i + 1) + " 列和第 " + (j + 1) + " 行後的新矩陣:");
        printMatrix(newMatrix);
        int determinant = calculateDeterminant(newMatrix);
        System.out.println("新矩陣的行列式為: " + determinant);
    }
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    private static int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        } else if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else if (n == 3) {
            return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) -
                   matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]) +
                   matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
        } else {
            int determinant = 0;
            for (int col = 0; col < n; col++) {
                determinant += matrix[0][col] * cofactor(matrix, 0, col);
            }
            return determinant;
        }
    }
    private static int cofactor(int[][] matrix, int row, int col) {
        int n = matrix.length;
        int[][] minor = new int[n - 1][n - 1];
        for (int i = 0, newRow = 0; i < n; i++) {
            if (i == row) continue;
            for (int j = 0, newCol = 0; j < n; j++) {
                if (j == col) continue;
                minor[newRow][newCol++] = matrix[i][j];
            }
            newRow++;
        }
        return (int) Math.pow(-1, row + col) * calculateDeterminant(minor);
    }
}
