import java.util.Scanner;

public class app7_1 {

    // 矩陣相乘
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        // 檢查矩陣是否可以相乘 (A 的列數必須等於 B 的行數)
        if (colsA != rowsB) {
            throw new IllegalArgumentException("A 的列數必須等於 B 的行數！");
        }

        // 初始化結果矩陣，尺寸為 rowsA x colsB
        int[][] result = new int[rowsA][colsB];

        // 執行矩陣相乘
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }

    // 顯示矩陣
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    // 輸入矩陣
    public static int[][] inputMatrix(Scanner scanner, String name) {
        System.out.println("輸入矩陣 " + name + " 的行數: ");
        int rows = scanner.nextInt();
        System.out.println("輸入矩陣 " + name + " 的列數: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("輸入矩陣 " + name + " 的元素 (依次輸入每一列元素):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入矩陣 A
        int[][] A = inputMatrix(scanner, "A");

        // 輸入矩陣 B
        int[][] B = inputMatrix(scanner, "B");

        try {
            // 相乘並顯示結果
            int[][] result = multiplyMatrices(A, B);
            System.out.println("相乘結果：");
            printMatrix(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
