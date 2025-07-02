import java.util.Scanner;

public class test4{
    // 計算2x2矩陣的行列式
    public static int determinant2x2(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    // 計算3x3矩陣的行列式
    public static int determinant3x3(int[][] matrix) {
        return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
                - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入n的值，確保n<=4
        System.out.print("請輸入矩陣的維度n (n<=4): ");
        int n = scanner.nextInt();
        if (n > 4 || n <= 0) {
            System.out.println("n值必須在1到4之間。");
            return;
        }

        // 初始化n x n矩陣
        int[][] matrix = new int[n][n];
        System.out.println("請輸入 " + n + "x" + n + " 矩陣的元素:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // 輸出原始矩陣
        System.out.println("輸入的矩陣是:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // 輸入要移除的行和列
        System.out.print("請輸入要去掉的行(i)和列(j) (從0開始計數): ");
        int i = scanner.nextInt();
        int j = scanner.nextInt();

        // 創建新矩陣，去掉第i行和第j列
        int[][] newMatrix = new int[n - 1][n - 1];
        int newRow = 0, newCol = 0;

        for (int row = 0; row < n; row++) {
            if (row == i) continue; // 跳過第i行
            newCol = 0;
            for (int col = 0; col < n; col++) {
                if (col == j) continue; // 跳過第j列
                newMatrix[newRow][newCol] = matrix[row][col];
                newCol++;
            }
            newRow++;
        }

        // 輸出新矩陣
        System.out.println("去掉第" + i + "行和第" + j + "列後的新矩陣是:");
        for (int row = 0; row < n - 1; row++) {
            for (int col = 0; col < n - 1; col++) {
                System.out.print(newMatrix[row][col] + " ");
            }
            System.out.println();
        }

        // 計算新矩陣的行列式
        int determinant = 0;
        if (n - 1 == 2) {
            determinant = determinant2x2(newMatrix);
        } else if (n - 1 == 3) {
            determinant = determinant3x3(newMatrix);
        }

        // 輸出行列式
        System.out.println("新矩陣的行列式是: " + determinant);

        scanner.close();
    }
}
