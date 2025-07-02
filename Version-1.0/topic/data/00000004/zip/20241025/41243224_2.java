import java.util.Scanner;

public class hw5_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 建立2x2矩陣並讓使用者輸入數值
        double[][] matrix = new double[2][2];

        System.out.println("請輸入2x2矩陣的元素 (共4個數值): ");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("元素 [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = scanner.nextDouble();
            }
        }

        // 計算反矩陣
        double[][] invMatrix = invMatrix(matrix);

        if (invMatrix != null) {
            System.out.println("反矩陣:");
            printMatrix(invMatrix);

            // 檢查 A * A^-1 是否為單位矩陣
            double[][] identity = multiplyMatrices(matrix, invMatrix);
            System.out.println("A * A的負一次方:");
            printMatrix(identity);
        } else {
            System.out.println("該矩陣不可逆。");
        }

        scanner.close();
    }

    // 計算2x2矩陣的反矩陣
    public static double[][] invMatrix(double[][] matrix) {
        double determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        // 如果行列式為0，則矩陣不可逆
        if (determinant == 0) {
            return null;
        }

        // 計算反矩陣 (根據2x2矩陣的公式)
        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / determinant;
        inverse[0][1] = -matrix[0][1] / determinant;
        inverse[1][0] = -matrix[1][0] / determinant;
        inverse[1][1] = matrix[0][0] / determinant;

        return inverse;
    }

    // 矩陣乘法
    public static double[][] multiplyMatrices(double[][] a, double[][] b) {
        double[][] result = new double[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    // 輸出矩陣
    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
