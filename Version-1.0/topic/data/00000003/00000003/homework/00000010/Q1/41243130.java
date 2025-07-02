import java.util.Scanner;

public class a1025_1 {
    public static void main(String arg[]) {
        Scanner scn = new Scanner(System.in);

        // 輸入陣列1
        System.out.print("請輸入陣列1大小(M和N):");
        int m = scn.nextInt(), n = scn.nextInt();
        double arr[][] = new double[m][n];
        System.out.print("請輸入陣列1內容:");
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = scn.nextDouble();

        // 輸入陣列2
        System.out.print("請輸入陣列2大小(M和N):");
        int m1 = scn.nextInt(), n1 = scn.nextInt();
        double arr1[][] = new double[m1][n1];
        System.out.print("請輸入陣列2內容:");
        for (int i = 0; i < m1; i++)
            for (int j = 0; j < n1; j++)
                arr1[i][j] = scn.nextDouble();

        // 呼叫矩陣乘法副程式
        double arr_OUT[][] = f(arr, arr1);
        if (arr_OUT != null) {
            for (int i = 0; i < arr_OUT.length; i++) {
                for (int j = 0; j < arr_OUT[i].length; j++)
                    System.out.printf("%.2f ", arr_OUT[i][j]);
                System.out.println();
            }
        } else {
            System.out.println("這兩個矩陣不能相乘");
        }

        // 反矩陣測試
        double arr2[][] = new double[2][2];
        System.out.print("請輸入矩陣(2x2)內容:");
        for (int i = 0; i < arr2.length; i++)
            for (int j = 0; j < arr2[i].length; j++)
                arr2[i][j] = scn.nextDouble();

        double arr_inverse[][] = f1(arr2);
        if (arr_inverse != null) {
            System.out.println("此矩陣的反矩陣為:");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++)
                    System.out.printf("%.2f ", arr_inverse[i][j]);
                System.out.println();
            }
        } else {
            System.out.println("此矩陣不可逆");
        }
    }

    public static double[][] f(double[][] arr, double[][] arr1) {
        // 檢查矩陣是否可以相乘
        if (arr[0].length != arr1.length) {
            return null;
        }

        // 定義結果矩陣大小
        int rows = arr.length;
        int cols = arr1[0].length;
        double[][] result = new double[rows][cols];

        // 執行矩陣相乘
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = 0;
                for (int k = 0; k < arr[0].length; k++) {
                    result[i][j] += arr[i][k] * arr1[k][j];
                }
            }
        }
        return result;
    }

    public static double[][] f1(double[][] matrix) {
        int n = matrix.length;
        double det = determinant(matrix, n);

        if (det == 0) {
            return null; // 矩陣不可逆
        }

        // 計算伴隨矩陣
        double[][] adj = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 計算每個元素的余子矩陣
                double[][] temp = new double[n - 1][n - 1];
                for (int row = 0, tempRow = 0; row < n; row++) {
                    if (row == i)
                        continue;
                    for (int col = 0, tempCol = 0; col < n; col++) {
                        if (col == j)
                            continue;
                        temp[tempRow][tempCol++] = matrix[row][col];
                    }
                    tempRow++;
                }
                adj[j][i] = Math.pow(-1, i + j) * determinant(temp, n - 1);
            }
        }

        // 計算反矩陣
        double[][] inverse = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverse[i][j] = adj[i][j] / det;
            }
        }
        return inverse;
    }

    private static double determinant(double[][] matrix, int n) {
        double det = 0;
        if (n == 1) {
            return matrix[0][0];
        }

        for (int f = 0; f < n; f++) {
            double[][] temp = new double[n - 1][n - 1];
            for (int i = 1; i < n; i++) {
                int tempColIndex = 0;
                for (int j = 0; j < n; j++) {
                    if (j != f) {
                        temp[i - 1][tempColIndex++] = matrix[i][j];
                    }
                }
            }
            det += Math.pow(-1, f) * matrix[0][f] * determinant(temp, n - 1);
        }
        return det;
    }
}
