import java.util.Scanner;

public class MatrixMultiplication {

    // 矩陣相乘方法，接受 double 類型的矩陣
    public static double[][] matMultiply(double[][] A, double[][] B) {
        int rowsA = A.length;    // A矩陣的行數
        int colsA = A[0].length; // A矩陣的列數
        int rowsB = B.length;    // B矩陣的行數
        int colsB = B[0].length; // B矩陣的列數

        // 檢查矩陣維度是否符合矩陣乘法的要求
        if (colsA != rowsB) {
            throw new IllegalArgumentException("矩陣的列數和行數不匹配，無法進行乘法運算。");
        }

        // 建立結果矩陣
        double[][] result = new double[rowsA][colsB];

        // 矩陣相乘計算
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }

    // 打印矩陣方法
    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%8.2f ", value); // 保留2位小數
            }
            System.out.println();
        }
    }

    // 從鍵盤輸入矩陣
    public static double[][] inputMatrix(Scanner scanner, String matrixName) {
        System.out.println("輸入 " + matrixName + " 矩陣的行數和列數：");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        double[][] matrix = new double[rows][cols];

        System.out.println("請輸入 " + matrixName + " 矩陣的元素（以空格分隔）：");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入矩陣 A 和 B
        double[][] A = inputMatrix(scanner, "A");
        double[][] B = inputMatrix(scanner, "B");

        // 執行矩陣相乘
        try {
            double[][] result = matMultiply(A, B);

            // 打印結果
            System.out.println("矩陣 A 和 矩陣 B 的乘積結果：");
            printMatrix(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
