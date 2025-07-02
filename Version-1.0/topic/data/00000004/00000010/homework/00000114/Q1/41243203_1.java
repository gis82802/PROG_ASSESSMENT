import java.util.Scanner;

public class MatrixOperations {

    // 矩陣相乘的函式
    public static double[][] MatMultiply(double[][] matrixA, double[][] matrixB) {
        // 確認兩個矩陣的大小是否符合相乘條件
        if (matrixA[0].length != matrixB.length) {
            return null; // 無法相乘
        }

        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        double[][] result = new double[rowsA][colsB];

        // 計算矩陣相乘
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result; // 回傳相乘的結果
    }

    // 計算 2x2 矩陣的反矩陣的函式
    public static double[][] invMatrix(double[][] matrix) {
        // 確保矩陣是 2x2
        if (matrix.length != 2 || matrix[0].length != 2) {
            return null;
        }

        double determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        // 檢查行列式是否為 0
        if (determinant == 0) {
            return null; // 無法計算反矩陣
        }

        // 計算反矩陣
        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / determinant;
        inverse[0][1] = -matrix[0][1] / determinant;
        inverse[1][0] = -matrix[1][0] / determinant;
        inverse[1][1] = matrix[0][0] / determinant;

        return inverse; // 回傳反矩陣
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取矩陣A的大小
        System.out.print("請輸入矩陣A的行數和列數（格式：行 列）：");
        int rowsA = scanner.nextInt();
        int colsA = scanner.nextInt();
        double[][] matrixA = new double[rowsA][colsA];

        // 讀取矩陣A的數值
        System.out.println("請輸入矩陣A的數值：");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                matrixA[i][j] = scanner.nextDouble();
            }
        }

        // 讀取矩陣B的大小
        System.out.print("請輸入矩陣B的行數和列數（格式：行 列）：");
        int rowsB = scanner.nextInt();
        int colsB = scanner.nextInt();
        double[][] matrixB = new double[rowsB][colsB];

        // 讀取矩陣B的數值
        System.out.println("請輸入矩陣B的數值：");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                System.out.print("B[" + i + "][" + j + "] = ");
                matrixB[i][j] = scanner.nextDouble();
            }
        }

        // 矩陣相乘
        double[][] product = MatMultiply(matrixA, matrixB);

        // 顯示相乘的結果
        if (product != null) {
            System.out.println("矩陣相乘的結果:");
            for (double[] row : product) {
                for (double value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("無法完成相乘運算");
        }

        // 如果矩陣A是2x2，則計算反矩陣
        if (rowsA == 2 && colsA == 2) {
            double[][] inverse = invMatrix(matrixA);

            // 顯示反矩陣的結果
            if (inverse != null) {
                System.out.println("反矩陣A:");
                for (double[] row : inverse) {
                    for (double value : row) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }

                // 驗證反矩陣的正確性
                double[][] identity = MatMultiply(matrixA, inverse);
                System.out.println("原矩陣A與其反矩陣的相乘結果（應為單位矩陣）:");
                for (double[] row : identity) {
                    for (double value : row) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("無法計算反矩陣");
            }
        } else {
            System.out.println("矩陣A不是2x2，無法計算反矩陣。");
        }

        // 關閉掃描器
        scanner.close();
    }
}
