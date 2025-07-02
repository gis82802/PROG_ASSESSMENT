import java.util.Scanner;
import java.util.Random;

public class  owoblue_java15 {

    // (a) 矩陣相乘
    public static double[][] MatMultiply(double[][] mat1, double[][] mat2) {
        int rows1 = mat1.length, cols1 = mat1[0].length;
        int rows2 = mat2.length, cols2 = mat2[0].length;
        
        // 確認矩陣是否可相乘
        if (cols1 != rows2) return null;

        // 初始化結果矩陣
        double[][] result = new double[rows1][cols2];
        
        // 矩陣相乘
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return result;
    }

    // (b) 2x2 矩陣反矩陣
    public static double[][] invMatrix(double[][] mat) {
        if (mat.length != 2 || mat[0].length != 2) return null;

        double det = mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
        if (det == 0) return null;  // 不可逆
        
        double[][] inv = new double[2][2];
        inv[0][0] = mat[1][1] / det;
        inv[0][1] = -mat[0][1] / det;
        inv[1][0] = -mat[1][0] / det;
        inv[1][1] = mat[0][0] / det;
        
        return inv;
    }

    // 顯示矩陣
    public static void printMatrix(double[][] mat) {
        if (mat == null) {
            System.out.println("null");
            return;
        }
        for (double[] row : mat) {
            for (double elem : row) {
                System.out.printf("%.2f ", elem);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 1. 使用者輸入矩陣大小，並隨機生成矩陣
        System.out.print("輸入矩陣1的行數和列數: ");
        int rows1 = scanner.nextInt();
        int cols1 = scanner.nextInt();
        double[][] mat1 = new double[rows1][cols1];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                mat1[i][j] = random.nextInt(10);
            }
        }

        System.out.print("輸入矩陣2的行數和列數: ");
        int rows2 = scanner.nextInt();
        int cols2 = scanner.nextInt();
        double[][] mat2 = new double[rows2][cols2];
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                mat2[i][j] = random.nextInt(10);
            }
        }

        System.out.println("矩陣1:");
        printMatrix(mat1);
        System.out.println("矩陣2:");
        printMatrix(mat2);

        // 2. 計算矩陣乘積
        double[][] product = MatMultiply(mat1, mat2);
        System.out.println("矩陣相乘的結果:");
        printMatrix(product);

        // 3. 驗證反矩陣的正確性
        System.out.println("請輸入 2x2 矩陣:");
        double[][] mat = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                mat[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("原始矩陣:");
        printMatrix(mat);

        // 計算反矩陣
        double[][] invMat = invMatrix(mat);
        System.out.println("反矩陣:");
        printMatrix(invMat);

        // 使用 (a) 的矩陣乘法進行驗證
        double[][] identity = MatMultiply(mat, invMat);
        System.out.println("原矩陣乘以反矩陣的結果:");
        printMatrix(identity);

        scanner.close();
    }
}
