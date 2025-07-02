import java.util.Scanner;

public class owoblue_java14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // (a) 輸入矩陣大小 n (n <= 4)
        System.out.print("請輸入矩陣大小 n (n <= 4): ");
        int n = scanner.nextInt();

        if (n <= 0 || n > 4) {
            System.out.println("n 必須在 1 到 4 之間");
            return;
        }

        // 輸入 n x n 矩陣
        int[][] matrix = new int[n][n];
        System.out.println("請輸入矩陣元素：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // 輸出輸入的矩陣
        System.out.println("您輸入的矩陣是：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // (b) 輸入要刪除的列和行
        System.out.print("請輸入要刪除的列號 i (1到 " + n + "): ");
        int rowToRemove = scanner.nextInt() - 1;

        System.out.print("請輸入要刪除的行號 j (1到 " + n + "): ");
        int colToRemove = scanner.nextInt() - 1;

        // 建立新矩陣，刪除第 i 列和第 j 行
        int newSize = n - 1;
        int[][] newMatrix = new int[newSize][newSize];
        int newRow = 0, newCol;

        for (int i = 0; i < n; i++) {
            if (i == rowToRemove) continue;  // 跳過要刪除的列
            newCol = 0;
            for (int j = 0; j < n; j++) {
                if (j == colToRemove) continue;  // 跳過要刪除的行
                newMatrix[newRow][newCol] = matrix[i][j];
                newCol++;
            }
            newRow++;
        }

        // 輸出刪除第 i 列和第 j 行後的新矩陣
        System.out.println("刪除第 " + (rowToRemove + 1) + " 列和第 " + (colToRemove + 1) + " 行後的新矩陣是：");
        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // 計算新矩陣的行列式
        if (newSize == 1) {
            // 1x1 矩陣的行列式就是唯一的元素
            System.out.println("新矩陣的行列式是：" + newMatrix[0][0]);
        } else if (newSize == 2) {
            // 2x2 矩陣的行列式計算
            int determinant = newMatrix[0][0] * newMatrix[1][1] - newMatrix[0][1] * newMatrix[1][0];
            System.out.println("新矩陣的行列式是：" + determinant);
        } else if (newSize == 3) {
            // 3x3 矩陣的行列式計算，根據你提供的公式
            int a = newMatrix[0][0], b = newMatrix[0][1], c = newMatrix[0][2];
            int d = newMatrix[1][0], e = newMatrix[1][1], f = newMatrix[1][2];
            int g = newMatrix[2][0], h = newMatrix[2][1], i = newMatrix[2][2];

            int determinant = a * e * i 
                            + a * f * h 
                            + b * d * i 
                            - c * e * g 
                            - c * d * h 
                            - b * f * g;

            System.out.println("新矩陣的行列式是：" + determinant);
        } else {
            System.out.println("無法計算更大矩陣的行列式。");
        }
    }
}
