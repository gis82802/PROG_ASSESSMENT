import java.util.Scanner;

public class MatrixDeterminant {
    
    // 計算行列式
    public static int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];
        if (n == 2) return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        
        int det = 0;
        for (int col = 0; col < n; col++) {
            det += matrix[0][col] * getCofactor(matrix, 0, col);
        }
        return det;
    }

    // 獲取余子式
    public static int getCofactor(int[][] matrix, int row, int col) {
        int n = matrix.length;
        int[][] subMatrix = new int[n - 1][n - 1];

        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            for (int j = 0; j < n; j++) {
                if (j == col) continue;
                subMatrix[i < row ? i : i - 1][j < col ? j : j - 1] = matrix[i][j];
            }
        }
        return calculateDeterminant(subMatrix);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入矩陣大小
        System.out.print("請輸入矩陣的大小 n (n <= 4): ");
        int n = scanner.nextInt();
        if (n <= 0 || n > 4) {
            System.out.println("矩陣大小不在有效範圍內。");
            return;
        }

        // 輸入矩陣
        int[][] matrix = new int[n][n];
        System.out.println("請輸入矩陣的元素:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // 輸出原始矩陣
        System.out.println("輸入的矩陣為:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        // 輸入要去掉的行和列
        System.out.print("請輸入要去掉的行 i (從 0 開始): ");
        int i = scanner.nextInt();
        System.out.print("請輸入要去掉的列 j (從 0 開始): ");
        int j = scanner.nextInt();

        // 驗證行列索引
        if (i < 0 || i >= n || j < 0 || j >= n) {
            System.out.println("行或列的索引不在有效範圍內。");
            return;
        }

        // 創建新矩陣
        int[][] newMatrix = new int[n - 1][n - 1];
        for (int row = 0; row < n; row++) {
            if (row == i) continue; // 跳過要去掉的行
            for (int col = 0; col < n; col++) {
                if (col == j) continue; // 跳過要去掉的列
                newMatrix[row < i ? row : row - 1][col < j ? col : col - 1] = matrix[row][col];
            }
        }

        // 輸出新矩陣
        System.out.println("去掉行 " + i + " 和列 " + j + " 後的新矩陣為:");
        for (int[] row : newMatrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        // 計算並輸出行列式
        int determinant = calculateDeterminant(newMatrix);
        System.out.println("新矩陣的行列式為: " + determinant);

        scanner.close();
    }
}
