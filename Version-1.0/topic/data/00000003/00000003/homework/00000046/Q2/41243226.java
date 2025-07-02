import java.util.Scanner;

public class InvMatrix {

    // 2x2矩陣反矩陣函式
    public static double[][] inverseMatrix(double[][] matrix) {
        // 檢查是否為2x2矩陣
        if (matrix.length != 2 || matrix[0].length != 2) {
            return null; // 不是2x2矩陣
        }

        double det = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]; // 計算行列式

        // 如果行列式為0，則反矩陣不存在
        if (det == 0) {
            return null;
        }

        // 計算反矩陣
        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / det;
        inverse[0][1] = -matrix[0][1] / det;
        inverse[1][0] = -matrix[1][0] / det;
        inverse[1][1] = matrix[0][0] / det;

        return inverse;
    }

    // 允許使用者輸入2x2矩陣
    public static double[][] inputMatrix(Scanner sc) {
        double[][] matrix = new double[2][2];
        System.out.println("請輸入2x2矩陣數值:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }
        return matrix;
    }

    // 處理浮點數輸出，避免顯示 -0.0
    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double elem : row) {
                if (elem == -0.0) {
                    elem = 0.0; // 將 -0.0 替換為 0.0
                }
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 允許使用者輸入2x2矩陣
        double[][] matrix = inputMatrix(sc);

        // 計算反矩陣
        double[][] inverse = inverseMatrix(matrix);

        if (inverse != null) {
            System.out.println("反矩陣：");
            printMatrix(inverse); // 使用處理後的輸出方法
        } else {
            System.out.println("反矩陣不存在。");
        }

        sc.close();
    }
}
