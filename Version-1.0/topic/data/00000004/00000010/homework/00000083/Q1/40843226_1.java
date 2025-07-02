// (a) 矩陣相乘
import java.util.Scanner;

public class MatrixMultiplication {
    public static double[][] MatMultiply(double[][] matrix1, double[][] matrix2) {
        if (matrix1 == null || matrix2 == null || 
            matrix1.length == 0 || matrix2.length == 0 ||
            matrix1[0].length != matrix2.length) {
            return null;
        }
        
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        
        double[][] result = new double[rows1][cols2];
        
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        
        return result;
    }

    private static double[][] inputMatrix(Scanner scanner, int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("請輸入 [%d][%d] 位置的元素: ", i+1, j+1);
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }

    private static void printMatrix(double[][] matrix) {
        if (matrix == null) {
            System.out.println("NULL");
            return;
        }
        for (double[] row : matrix) {
            for (double num : row) {
                System.out.printf("%.2f\t", num);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("請輸入第一個矩陣的維度：");
            System.out.print("列數: ");
            int rows1 = scanner.nextInt();
            System.out.print("行數: ");
            int cols1 = scanner.nextInt();

            System.out.println("\n請輸入第二個矩陣的維度：");
            System.out.print("列數: ");
            int rows2 = scanner.nextInt();
            System.out.print("行數: ");
            int cols2 = scanner.nextInt();

            System.out.println("\n請輸入第一個矩陣的元素：");
            double[][] matrix1 = inputMatrix(scanner, rows1, cols1);

            System.out.println("\n請輸入第二個矩陣的元素：");
            double[][] matrix2 = inputMatrix(scanner, rows2, cols2);

            System.out.println("\n第一個矩陣：");
            printMatrix(matrix1);

            System.out.println("\n第二個矩陣：");
            printMatrix(matrix2);

            System.out.println("\n相乘結果：");
            printMatrix(MatMultiply(matrix1, matrix2));
            
        } catch (Exception e) {
            System.out.println("NULL");
        } finally {
            scanner.close();
        }
    }
}