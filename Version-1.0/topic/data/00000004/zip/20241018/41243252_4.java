import java.util.Scanner;

public class ch6_4 { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讓使用者輸入矩陣大小 n
        System.out.print("請輸入矩陣大小 n (n<=4): ");
        int n = scanner.nextInt();
        if (n > 4 || n <= 0) {
            System.out.println("n 必須小於或等於 4，且大於 0");
            return;
        }

        // 建立 n x n 的矩陣
        int[][] matrix = new int[n][n];
        System.out.println("請輸入矩陣元素:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // 輸出原矩陣
        System.out.println("輸入的矩陣為:");
        printMatrix(matrix, n);

        // (b) 輸入 i, j 並生成新矩陣
        System.out.print("請輸入欲去掉的列 i (0 <= i < " + n + "): ");
        int rowToRemove = scanner.nextInt();
        System.out.print("請輸入欲去掉的行 j (0 <= j < " + n + "): ");
        int colToRemove = scanner.nextInt();

        // 驗證行列的有效性
        if (rowToRemove < 0 || rowToRemove >= n || colToRemove < 0 || colToRemove >= n) {
            System.out.println("i 或 j 的值無效");
            return;
        }

        // 生成新的 (n-1) x (n-1) 矩陣
        int[][] newMatrix = new int[n - 1][n - 1];
        for (int i = 0, newI = 0; i < n; i++) {
            if (i == rowToRemove) continue; // 跳過要去掉的列
            for (int j = 0, newJ = 0; j < n; j++) {
                if (j == colToRemove) continue; // 跳過要去掉的行
                newMatrix[newI][newJ++] = matrix[i][j];
            }
            newI++;
        }

        // 輸出新矩陣
        System.out.println("去掉第 " + rowToRemove + " 列和第 " + colToRemove + " 行後的矩陣為:");
        printMatrix(newMatrix, n - 1);

        // 計算新矩陣的行列式
        int determinant = calculateDeterminant(newMatrix);
        System.out.println("新矩陣的行列式為: " + determinant);

        scanner.close();
    }

    // 輔助函數：輸出矩陣
    public static void printMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 輔助函數：計算 n x n 矩陣的行列式
    public static int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0]; // 單一元素矩陣的行列式是元素本身
        }
        if (n == 2) {
            // 2x2 矩陣行列式: |A| = a*d - b*c
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        // 對於 3x3 和 4x4，使用 Laplace 展開法
        int determinant = 0;
        for (int j = 0; j < n; j++) {
            determinant += Math.pow(-1, j) * matrix[0][j] * calculateDeterminant(minor(matrix, 0, j));
        }
        return determinant;
    }

    // 輔助函數：生成矩陣的某個元素的子矩陣 (minor)
    public static int[][] minor(int[][] matrix, int rowToRemove, int colToRemove) {
        int n = matrix.length;
        int[][] minorMatrix = new int[n - 1][n - 1];
        for (int i = 0, newI = 0; i < n; i++) {
            if (i == rowToRemove) continue; // 跳過行
            for (int j = 0, newJ = 0; j < n; j++) {
                if (j == colToRemove) continue; // 跳過列
                minorMatrix[newI][newJ++] = matrix[i][j];
            }
            newI++;
        }
        return minorMatrix;
    }
}
