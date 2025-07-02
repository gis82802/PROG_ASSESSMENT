import java.util.Scanner;

public class hw2 {

    // MatMultiply 函式，用於矩陣相乘
    public static double[][] MatMultiply(double[][] matrix1, double[][] matrix2) {
        int rows1 = matrix1.length;        // matrix1 的行數
        int cols1 = matrix1[0].length;     // matrix1 的列數
        int rows2 = matrix2.length;        // matrix2 的行數
        int cols2 = matrix2[0].length;     // matrix2 的列數

        // 如果 matrix1 的列數不等於 matrix2 的行數，則無法進行矩陣相乘
        if (cols1 != rows2) {
            return null; // 返回 null，表示無法相乘
        }

        // 建立一個新的矩陣來存儲乘積結果
        double[][] result = new double[rows1][cols2];

        // 矩陣相乘的算法
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result; // 返回相乘結果的矩陣
    }

    // 用來打印矩陣的方法
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

    // 讀取使用者輸入的矩陣
    public static double[][] inputMatrix(Scanner scanner, int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        System.out.println("請輸入矩陣的元素:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("matrix[" + i + "][" + j + "] = ");
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入第一個矩陣的大小
        System.out.print("請輸入第一個矩陣的行數: ");
        int rows1 = scanner.nextInt();
        System.out.print("請輸入第一個矩陣的列數: ");
        int cols1 = scanner.nextInt();

        // 輸入第一個矩陣
        double[][] matrix1 = inputMatrix(scanner, rows1, cols1);

        // 輸入第二個矩陣的大小
        System.out.print("請輸入第二個矩陣的行數: ");
        int rows2 = scanner.nextInt();
        System.out.print("請輸入第二個矩陣的列數: ");
        int cols2 = scanner.nextInt();

        // 輸入第二個矩陣
        double[][] matrix2 = inputMatrix(scanner, rows2, cols2);

        // 輸出使用者輸入的矩陣
        System.out.println("第一個矩陣是:");
        printMatrix(matrix1);
        System.out.println("第二個矩陣是:");
        printMatrix(matrix2);

        // 矩陣相乘
        double[][] result = MatMultiply(matrix1, matrix2);

        // 顯示結果或錯誤訊息
        if (result != null) {
            System.out.println("矩陣相乘的結果是:");
            printMatrix(result);
        } else {
            System.out.println("錯誤：矩陣的大小不符合相乘條件。");
        }

        scanner.close();
    }
}
