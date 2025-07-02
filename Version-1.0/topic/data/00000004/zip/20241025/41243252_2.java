import java.util.Scanner;

public class ch7_1_2 {

    // 矩陣求逆函數 (僅針對2x2矩陣)
    public static double[][] invMatrix(double[][] matrix) {
        if (matrix.length != 2 || matrix[0].length != 2) {
            throw new IllegalArgumentException("僅支持2x2矩陣的逆矩陣計算");
        }

        double determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        // 檢查行列式是否為零（不可逆）
        if (determinant == 0) {
            throw new IllegalArgumentException("該矩陣不可逆");
        }

        // 計算逆矩陣
        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / determinant;
        inverse[0][1] = -matrix[0][1] / determinant;
        inverse[1][0] = -matrix[1][0] / determinant;
        inverse[1][1] = matrix[0][0] / determinant;

        return inverse;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入2x2矩陣
        System.out.println("請輸入一個2x2矩陣的元素：");
        double[][] matrix = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        // 計算反矩陣並輸出
        try {
            double[][] inverse = invMatrix(matrix);

            // 顯示反矩陣
            System.out.println("反矩陣結果:");
            for (int i = 0; i < inverse.length; i++) {
                for (int j = 0; j < inverse[0].length; j++) {
                    System.out.printf("%.2f ", inverse[i][j]);
                }
                System.out.println();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
