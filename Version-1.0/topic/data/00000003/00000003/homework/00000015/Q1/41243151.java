import java.util.Scanner;

public class Main {

    // 計算兩個 2x2 矩陣的乘積，並返回結果
    public static int[][] matMultiply(int[][] array1, int[][] array2) {
        int[][] result = new int[2][2];
        result[0][0] = array1[0][0] * array2[0][0] + array1[0][1] * array2[1][0];
        result[0][1] = array1[0][0] * array2[0][1] + array1[0][1] * array2[1][1];
        result[1][0] = array1[1][0] * array2[0][0] + array1[1][1] * array2[1][0];
        result[1][1] = array1[1][0] * array2[0][1] + array1[1][1] * array2[1][1];
        return result;
    }

    // 計算 2x2 矩陣的反矩陣，並返回結果
    public static double[][] inverseMatrix(int[][] a) {
        double det = a[0][0] * a[1][1] - a[0][1] * a[1][0]; // 行列式

        if (det == 0) {
            System.out.println("矩陣不可逆");
            return null;
        }

        double invDet = 1.0 / det;
        double[][] inv = new double[2][2];
        inv[0][0] = invDet * a[1][1];
        inv[0][1] = invDet * -a[0][1];
        inv[1][0] = invDet * -a[1][0];
        inv[1][1] = invDet * a[0][0];
        return inv;
    }

    // 輸出 2x2 矩陣
    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.printf("%.2f ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    // 輸出 2x2 矩陣
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讓使用者輸入兩個 2x2 矩陣
        int[][] array1 = new int[2][2];
        int[][] array2 = new int[2][2];

        System.out.println("請輸入第1個矩陣的元素 (2x2):");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                array1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("請輸入第2個矩陣的元素 (2x2):");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                array2[i][j] = scanner.nextInt();
            }
        }

        // 計算矩陣乘法
        int[][] result = matMultiply(array1, array2);
        System.out.println("相乘後的矩陣為:");
        printMatrix(result);

        // 計算反矩陣
        double[][] inverse = inverseMatrix(result);
        if (inverse != null) {
            System.out.println("相乘後的矩陣的反矩陣為:");
            printMatrix(inverse);
        }

        scanner.close();
    }
}
