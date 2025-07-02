import java.util.Scanner;

public class hw1 {

    // a. MatMultiply 函式，用於矩陣相乘
    public static double[][] MatMultiply(double[][] matrix1, double[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        if (cols1 != rows2) {
            return null; // 矩陣大小不符合，無法相乘
        }

        double[][] result = new double[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    // b. invMatrix 函式，用於計算 2x2 方陣的反矩陣
    public static double[][] invMatrix(double[][] matrix) {
        if (matrix.length != 2 || matrix[0].length != 2) {
            return null; // 非 2x2 方陣，無法計算反矩陣
        }

        double det = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        if (det == 0) {
            return null; // 矩陣不可逆
        }

        double invDet = 1.0 / det;

        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] * invDet;
        inverse[0][1] = -matrix[0][1] * invDet;
        inverse[1][0] = -matrix[1][0] * invDet;
        inverse[1][1] = matrix[0][0] * invDet;

        return inverse;
    }

    // 打印矩陣的方法
    public static void printMatrix(double[][] matrix) {
        if (matrix == null) {
            System.out.println("矩陣無法計算。");
            return;
        }
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.printf("%10.4f ", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 使用者輸入 2x2 方陣
        System.out.println("請輸入 2x2 矩陣:");
        double[][] matrix = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("matrix[" + i + "][" + j + "] = ");
                matrix[i][j] = scanner.nextDouble();
            }
        }

        // 輸出使用者輸入的矩陣
        System.out.println("你輸入的矩陣是:");
        printMatrix(matrix);

        // 計算反矩陣
        double[][] inverseMatrix = invMatrix(matrix);
        System.out.println("反矩陣:");
        printMatrix(inverseMatrix);

        // 驗證反矩陣：原矩陣 * 反矩陣 是否等於單位矩陣
        if (inverseMatrix != null) {
            double[][] identityMatrix = MatMultiply(matrix, inverseMatrix);
            System.out.println("原矩陣 * 反矩陣的結果:");
            printMatrix(identityMatrix);
        }

        scanner.close();
    }
}
