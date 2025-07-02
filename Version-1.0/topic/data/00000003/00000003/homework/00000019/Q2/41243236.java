import java.util.Scanner;

public class MatInverse {

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%8.4f ", value);
            }
            System.out.println();
        }
    }

    public static double[][] invertMatrix(double[][] matrix) {
        int n = matrix.length;
        double[][] augmentedMatrix = new double[n][2 * n];

        // 初始化擴展矩陣 (原始矩陣 | 單位矩陣)
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, augmentedMatrix[i], 0, n);
            augmentedMatrix[i][i + n] = 1; // 對角線為1
        }

        // 高斯-喬丹消元法
        for (int i = 0; i < n; i++) {
            double diagElement = augmentedMatrix[i][i];
            if (Math.abs(diagElement) < 1e-10) {
                throw new ArithmeticException("矩陣不可逆");
            }
            for (int j = 0; j < 2 * n; j++) {
                augmentedMatrix[i][j] /= diagElement; // 將對角線元素化為1
            }

            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = augmentedMatrix[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        augmentedMatrix[k][j] -= factor * augmentedMatrix[i][j]; // 消元
                    }
                }
            }
        }

        double[][] inverseMatrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(augmentedMatrix[i], n, inverseMatrix[i], 0, n);
        }

        return inverseMatrix;
    }

    public static double[][] readMatrix(Scanner scanner) {
        System.out.println("請輸入矩陣的行/列數 (方陣)：");
        int n = scanner.nextInt();
        
        double[][] matrix = new double[n][n];
        System.out.println("請輸入矩陣的元素 (以空格分隔)：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取矩陣
        double[][] A = readMatrix(scanner);

        try {
            // 計算矩陣的逆
            double[][] inverse = invertMatrix(A);
            System.out.println("矩陣的逆矩陣是：");
            printMatrix(inverse);

            // 進行矩陣乘法
            double[][] identity = multiplyMatrices(A, inverse);
            System.out.println("矩陣 A 和其逆矩陣的乘積是：");
            printMatrix(identity);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double[][] multiplyMatrices(double[][] A, double[][] B) {
        int n = A.length;
        double[][] result = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }
}
