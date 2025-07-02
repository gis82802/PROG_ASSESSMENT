// file name: app7_2
// author: 41243142
// version:
// function: 
// date: 24/10/25

import java.util.Scanner;
import java.text.DecimalFormat;

public class app7_2{

    public static double[][] invMultiply(double[][] matrix) {
        if (matrix.length != 2 || matrix[0].length != 2) {
            return null;
        }

        double a = matrix[0][0];
        double b = matrix[0][1];
        double c = matrix[1][0];
        double d = matrix[1][1];

        double determinant = a * d - b * c;

        if (determinant == 0) {
            return null; 
        }

        double[][] inverse = {
            {d / determinant, -b / determinant},
            {-c / determinant, a / determinant}
        };

        return inverse; 
    }

    public static double[][] MatMultiply(double[][] matrixA, double[][] matrixB) {
        if (matrixA[0].length != matrixB.length) {
            return null; 
        }

        double[][] result = new double[matrixA.length][matrixB[0].length];

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                for (int k = 0; k < matrixA[0].length; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return result; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] matrixA = new double[2][2];
        
        System.out.println("請輸入2x2矩陣的元素:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrixA[i][j] = scanner.nextDouble();
            }
        }

        double[][] inverse = invMultiply(matrixA);

        if (inverse != null) {
            System.out.println("反方陣為:");
            printMatrix(inverse);

            double[][] identityMatrix = MatMultiply(matrixA, inverse);
            System.out.println("驗證結果:");
            printMatrix(identityMatrix);
        } else {
            System.out.println("反方陣不存在，行列式為0。");
        }

        scanner.close();
    }

    private static void printMatrix(double[][] matrix) {
        DecimalFormat df = new DecimalFormat("#.##");
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.print(df.format(value) + " ");
            }
            System.out.println();
        }
    }
}
