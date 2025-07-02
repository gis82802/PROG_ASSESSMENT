import java.util.Scanner;

public class java7_3 {

    public static int[][] MatMultiply(int[][] matrixA, int[][] matrixB) {
        // 初始化結果矩陣
        int[][] result = new int[2][2]; // 固定為 2x2 矩陣

        // 矩陣相乘的計算
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = 0; // 初始化結果矩陣的元素
                for (int k = 0; k < 2; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return result; // 返回計算結果
    }

    // 主程式
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 固定矩陣A和B的大小為2x2
        int[][] matrixA = new int[2][2];
        int[][] matrixB = new int[2][2];

        // 讀取矩陣A的元素
        System.out.println("請輸入矩陣A的 2x2 元素：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrixA[i][j] = scanner.nextInt(); // 讀取每個元素
            }
        }

        // 讀取矩陣B的元素
        System.out.println("請輸入矩陣B的 2x2 元素：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrixB[i][j] = scanner.nextInt(); // 讀取每個元素
            }
        }

        // 計算矩陣相乘
        int[][] result = MatMultiply(matrixA, matrixB);

        // 輸出結果
        System.out.println("乘法結果：");
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        scanner.close(); // 關閉掃描器
    }
}
