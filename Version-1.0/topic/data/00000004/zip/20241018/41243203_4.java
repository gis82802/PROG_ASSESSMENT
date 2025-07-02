import java.util.Scanner;

public class matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入矩陣大小
        System.out.print("請輸入矩陣大小 n: ");
        int n = scanner.nextInt();

        // 初始化 n x n 矩陣
        int[][] matrix = new int[n][n];

        // 輸入矩陣元素
        System.out.println("請輸入矩陣的元素：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // 輸出原始矩陣
        System.out.println("原始矩陣：");
        printMatrix(matrix, n);

        // 進行矩陣轉置（行列互換）
        int[][] transposedMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        // 輸出轉置後的矩陣
        System.out.println("轉置後的矩陣：");
        printMatrix(transposedMatrix, n);

        scanner.close();
    }

    // 打印矩陣的方法
    public static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
