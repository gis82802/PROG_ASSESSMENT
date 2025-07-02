import java.util.Scanner;

public class H63a {

    public static int[][] MatMultiply(int[][] matrixA, int[][] matrixB) {
        // 檢查矩陣是否為 null
        if (matrixA == null || matrixB == null) {
            return null;
        }

        // 獲取矩陣的行列數
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        // 檢查矩陣相乘的條件
        if (colsA != rowsB) {
            return null;
        }

        // 初始化結果矩陣
        int[][] result = new int[rowsA][colsB];

        // 矩陣相乘的計算
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入第一個矩陣
        System.out.println("請輸入第一個矩陣的行數和列數（以空格分隔）：");
        int rowsA = scanner.nextInt();
        int colsA = scanner.nextInt();
        int[][] matrixA = new int[rowsA][colsA];

        System.out.println("請輸入第一個矩陣的元素：");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        // 輸入第二個矩陣
        System.out.println("請輸入第二個矩陣的行數和列數（以空格分隔）：");
        int rowsB = scanner.nextInt();
        int colsB = scanner.nextInt();
        int[][] matrixB = new int[rowsB][colsB];

        System.out.println("請輸入第二個矩陣的元素：");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        // 計算矩陣乘法
        int[][] result = MatMultiply(matrixA, matrixB);

        // 輸出結果
        if (result != null) {
            System.out.println("矩陣相乘的結果：");
            for (int[] row : result) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("無法完成計算，返回 null。");
        }

        scanner.close();
    }
}
