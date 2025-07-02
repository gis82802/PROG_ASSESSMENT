import java.util.*;

public class Main {
    public static void main(String[] args) {
        double [][] mat1 = {{1, 2}, {3, 4}};
        double [][] mat2 = {{2, 0}, {1, 2}};
        
        double [][] result = matMultiply(mat1, mat2);
        if (result != null) {
            for (double[] row : result) {
                for (double val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Matrix multiplication is not possible.");
        }
        
        double [][] mat3 = {{4, 7}, {2, 6}};
        double [][] inverse = inverseMatrix(mat3);
        if (inverse != null) {
            for (double[] row : inverse) {
                for (double val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Matrix is not invertible.");
        }
    }

    public static double [][] matMultiply(double [][] mat1, double [][] mat2) {
        int r1 = mat1.length;
        int c1 = mat1[0].length;
        int r2 = mat2.length;
        int c2 = mat2[0].length;

        if (c1 != r2) {
            return null; 
        }

        double [][] result = new double[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return result;
    }

    public static double [][] inverseMatrix(double [][] mat) {
        if (mat.length != 2 || mat[0].length != 2) {
            return null;
        }

        double deter = mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
        if (deter == 0) {
            return null; 
        }

        double [][] inverse = new double[2][2];
        inverse[0][0] = mat[1][1] / deter;
        inverse[0][1] = -mat[0][1] / deter;
        inverse[1][0] = -mat[1][0] / deter;
        inverse[1][1] = mat[0][0] / deter;
        return inverse;
    }
}
