import java.util.Scanner;

public class hw4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取矩陣的大小
        System.out.print("請輸入矩陣大小 n (n <= 4): ");
        int n = scanner.nextInt();

        // 確認 n 不超過 4
        if (n > 4 || n < 1) {
            System.out.println("n 必須在 1 到 4 之間");
            return;
        }

        // 讀取 n x n 矩陣
        int[][] matrix = new int[n][n];
        System.out.println("請輸入矩陣的元素:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // 顯示輸入的矩陣
        System.out.println("輸入的矩陣是:");
        printMatrix(matrix);

        // 讀取欲去掉的列和行
        System.out.print("請輸入要去掉的列 (i): ");
        int row = scanner.nextInt() - 1;
        System.out.print("請輸入要去掉的行 (j): ");
        int col = scanner.nextInt() - 1;

        // 檢查輸入是否有效
        if (row < 0 || row >= n || col < 0 || col >= n) {
            System.out.println("列或行的值不合法");
            return;
        }

        // 建立去掉 i 列和 j 行後的新矩陣
        int[][] newMatrix = createSubMatrix(matrix, row, col);

        // 顯示新矩陣
        System.out.println("去掉第 " + (row + 1) + " 列和第 " + (col + 1) + " 行後的新矩陣是:");
        printMatrix(newMatrix);

        // 計算行列式
        int determinant = calculateDeterminant(newMatrix);
        System.out.println("新矩陣的行列式是: " + determinant);
    }

    // 列印矩陣
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    // 創建去掉指定列和行後的新矩陣
    public static int[][] createSubMatrix(int[][] matrix, int rowToRemove, int colToRemove) {
        int n = matrix.length - 1;
        int[][] subMatrix = new int[n][n];
        int r = 0, c;

        for (int i = 0; i < matrix.length; i++) {
            if (i == rowToRemove) continue;
            c = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (j == colToRemove) continue;
                subMatrix[r][c] = matrix[i][j];
                c++;
            }
            r++;
        }

        return subMatrix;
    }

    // 計算行列式
    public static int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;

        if (n == 1) {
            return matrix[0][0];
        } else if (n == 2) {
            // 2x2 矩陣的行列式計算
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else if (n == 3) {
            // 3x3 矩陣的行列式計算
            return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
                 - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                 + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
        }
        return 0; // 本範例只支援 1x1, 2x2 和 3x3 的行列式計算
    }
}
