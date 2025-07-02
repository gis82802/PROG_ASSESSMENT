import java.util.Scanner;

public class H63b {

    public static double[][] invMatrix(double[][] matrix) {
        if (matrix == null || matrix.length != 2 || matrix[0].length != 2) {
            return null;
        }

        double determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        if (determinant == 0) {
            return null;
        }

        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / determinant;
        inverse[0][1] = -matrix[0][1] / determinant;
        inverse[1][0] = -matrix[1][0] / determinant;
        inverse[1][1] = matrix[0][0] / determinant;

        return inverse;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[][] matrix = new double[2][2];
        System.out.println("請輸入 2x2 矩陣的元素（以空格分隔）：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        double[][] inverse = invMatrix(matrix);

        if (inverse != null) {
            System.out.println("反矩陣為：");
            for (double[] row : inverse) {
                for (double value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("該矩陣不可逆，返回 null。");
        }

        scanner.close();
    }
}
