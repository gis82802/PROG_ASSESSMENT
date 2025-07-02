import java.util.Scanner;

public class matrixa {

    // 矩陣相乘函式
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;       // matrix1的列數
        int cols1 = matrix1[0].length;    // matrix1的行數
        int rows2 = matrix2.length;       // matrix2的列數
        int cols2 = matrix2[0].length;    // matrix2的行數

        // 檢查矩陣是否可以相乘 (matrix1的行數必須等於matrix2的列數)
        if (cols1 != rows2) {
            return null; // 無法相乘，返回null
        }

        int[][] result = new int[rows1][cols2]; // 乘積結果的矩陣大小

        // 計算矩陣相乘
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

    // 允許使用者輸入矩陣
    public static int[][] inputMatrix(Scanner sc, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        System.out.println("請輸入矩陣數值 (" + rows + "x" + cols + "):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 輸入矩陣1的大小
        System.out.print("請輸入矩陣1的列數: ");
        int rows1 = sc.nextInt();
        System.out.print("請輸入矩陣1的行數: ");
        int cols1 = sc.nextInt();
        int[][] matrix1 = inputMatrix(sc, rows1, cols1);

        // 輸入矩陣2的大小
        System.out.print("請輸入矩陣2的列數: ");
        int rows2 = sc.nextInt();
        System.out.print("請輸入矩陣2的行數: ");
        int cols2 = sc.nextInt();
        int[][] matrix2 = inputMatrix(sc, rows2, cols2);

        // 矩陣相乘
        int[][] result = multiplyMatrices(matrix1, matrix2);

        if (result != null) {
            System.out.println("矩陣相乘結果：");
            for (int[] row : result) {
                for (int elem : row) {
                    System.out.print(elem + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("矩陣大小無法相乘。");
        }

        sc.close();
    }
}
