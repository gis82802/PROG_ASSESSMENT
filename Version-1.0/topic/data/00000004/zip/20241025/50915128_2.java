import java.util.Scanner;

public class java7_4 {

    // 矩陣乘法
    public static int[][] MatMultiply(int[][] matrixA, int[][] matrixB) {
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

    // 計算反矩陣
    public static double[][] invMatrix(int[][] matrix) {
        double determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        // 如果行列式為零，返回 null，表示不可逆
        if (determinant == 0) {
            return null;
        }

        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / determinant; // d / (ad - bc)
        inverse[0][1] = -matrix[0][1] / determinant; // -b / (ad - bc)
        inverse[1][0] = -matrix[1][0] / determinant; // -c / (ad - bc)
        inverse[1][1] = matrix[0][0] / determinant; // a / (ad - bc)

        return inverse; // 返回反矩陣
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

        // 輸出乘法結果
        System.out.println("乘法結果：");
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        // 計算反矩陣並驗證
        double[][] inverse = invMatrix(matrixA);

        // 檢查反矩陣是否存在
        if (inverse != null) {
            System.out.println("反矩陣：");
            for (double[] row : inverse) {
                for (double val : row) {
                    System.out.printf("%.2f ", val); // 格式化輸出
                }
                System.out.println();
            }

            // 驗證反矩陣的正確性
            int[][] identityMatrix = MatMultiply(matrixA, new int[][] {
                {(int)inverse[0][0], (int)inverse[0][1]},
                {(int)inverse[1][0], (int)inverse[1][1]}
            });

            // 輸出驗證結果
            System.out.println("乘法結果（應為單位矩陣）：");
            for (int[] row : identityMatrix) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("該矩陣不可逆，無法計算反矩陣。");
        }

        scanner.close(); // 關閉掃描器
    }
}
