//app7_test4
//filename:app7_test4
//function:(a) 計算二維陣列乘法(b)計算反矩陣
//author:xiao
//date:10/25
//version:11.0.12

import java.util.Scanner;

public class app7_test4 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);

        // 輸入 A 矩陣的大小
        System.out.print("請輸入 A 陣列的行: ");
        int rows1 = scn.nextInt();
        System.out.print("請輸入 A 陣列的列: ");
        int cols1 = scn.nextInt();

        // 初始化 A 陣列
        int[][] arr1 = new int[rows1][cols1];

        // 輸入 A 陣列的元素
        System.out.println("請輸入 A 陣列的元素:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                arr1[i][j] = scn.nextInt();
            }
        }

        // 顯示 A 陣列
        System.out.println("A 陣列為:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }

        // 輸入 B 矩陣的大小
        System.out.print("請輸入 B 陣列的行: ");
        int rows2 = scn.nextInt();
        System.out.print("請輸入 B 陣列的列: ");
        int cols2 = scn.nextInt();

        // 初始化 B 陣列
        int[][] arr2 = new int[rows2][cols2];

        // 輸入 B 陣列的元素
        System.out.println("請輸入 B 陣列的元素:");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                arr2[i][j] = scn.nextInt();
            }
        }

        // 顯示 B 陣列
        System.out.println("B 陣列為:");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }

        // 呼叫矩陣相乘方法
        int[][] result = matrixMultiply(arr1, arr2);

        // 顯示矩陣相乘的結果
        if (result != null) {
            System.out.println("矩陣相乘的結果是：");
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("無法進行矩陣相乘，因為矩陣的尺寸不符合相乘條件。");
        }

        // 反矩陣計算示範
        if (rows1 == 2 && cols1 == 2) {
            double[][] invResult = invmatrix(arr1);
            if (invResult != null) {
                System.out.println("A 矩陣的反矩陣是：");
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.printf("%.2f ", invResult[i][j]);
                    }
                    System.out.println();
                }
            } else {
                System.out.println("A 矩陣沒有反矩陣。");
            }
        } else {
            System.out.println("A 矩陣不是 2x2 矩陣，無法計算反矩陣。");
        }

        scn.close();
    }

    // 矩陣相乘方法
    public static int[][] matrixMultiply(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        if (colsA != rowsB) {
            return null; // 如果不符合條件則返回 null
        }

        int[][] C = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                C[i][j] = 0;
                for (int k = 0; k < colsA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    // 計算 2x2 矩陣的反矩陣
    public static double[][] invmatrix(int[][] matrix) {
        if (matrix.length != 2 || matrix[0].length != 2) {
            return null;  // 只有 2x2 矩陣才可以計算反矩陣
        }

        int a = matrix[0][0];
        int b = matrix[0][1];
        int c = matrix[1][0];
        int d = matrix[1][1];

        int det = a * d - b * c;  // 計算行列式 det(A)

        if (det == 0) {
            return null;  // 如果行列式為 0，則矩陣沒有反矩陣
        }

        double invDet = 1.0 / det;  // 計算 1/det(A)

        double[][] inverse = new double[2][2];
        inverse[0][0] = d * invDet;
        inverse[0][1] = -b * invDet;
        inverse[1][0] = -c * invDet;
        inverse[1][1] = a * invDet;

        return inverse;  // 返回反矩陣
    }
}
