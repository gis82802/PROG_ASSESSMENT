import java.util.Scanner;

public class Hwab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  
        System.out.println("請輸入矩陣 A 的行數和列數：");
        int rowsA = scanner.nextInt();
        int colsA = scanner.nextInt();
        int[][] A = new int[rowsA][colsA]; 
        System.out.println("請輸入矩陣 A 的元素：");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                A[i][j] = scanner.nextInt();
            }
        }
        System.out.println("請輸入矩陣 B 的行數和列數：");
        int rowsB = scanner.nextInt();
        int colsB = scanner.nextInt();
        int[][] B = new int[rowsB][colsB]; 
        System.out.println("請輸入矩陣 B 的元素：");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                B[i][j] = scanner.nextInt();
            }
        }
        int[][] C = MatMultiply(A, B);
        if (C != null) {
            System.out.println("結果矩陣 C：");
            for (int[] row : C) {
                System.out.print("[ ");
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println("]");
            }
        }
        int[][] D = new int[2][2]; 
        System.out.println("請輸入矩陣 D 的元素：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                D[i][j] = scanner.nextInt();
            }
        }
        double[][] inverseD = intMatrix(D);
        if (inverseD != null) {
            System.out.println("反矩陣 D：");
            for (double[] row : inverseD) {
                System.out.print("[ ");
                for (double value : row) {
                    System.out.print(value + " ");
                }
                System.out.println("]");
            }
        } else {
            System.out.println("矩陣 D 不能反轉（行列式為零）");
        }

        scanner.close(); 
    }
    public static int[][] MatMultiply(int[][] A, int[][] B) {
        if (A[0].length != B.length) {
            System.out.println("NULL"); 
            return null;
        }
        int[][] C = new int[A.length][B[0].length]; 
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    C[i][j] += A[i][k] * B[k][j]; 
                }
            }
        }
        return C; 
    }
    public static double[][] intMatrix(int[][] matrix) {
        if (matrix.length != 2 || matrix[0].length != 2) {
            return null; 
        }

        int a = matrix[0][0];
        int b = matrix[0][1];
        int c = matrix[1][0];
        int d = matrix[1][1];

        int determinant = a * d - b * c;

        if (determinant == 0) {
            return null; 
        }
        double[][] inverse = new double[2][2];
        inverse[0][0] = (double) d / determinant;
        inverse[0][1] = (double) -b / determinant;
        inverse[1][0] = (double) -c / determinant;
        inverse[1][1] = (double) a / determinant;

        return inverse;
    }
}
