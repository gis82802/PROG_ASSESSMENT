/*
    filename: hw1025_3_2
    function: 撰寫函式計算反二維矩陣
    author: 41243204
    datetime: 2024/10/25
    version: 1.0
 */
import java.util.Scanner;
public class hw1025_3_2 {

    public static double[][] MatMultply(double[][] A, double[][] B) {
        if (A[0].length != B.length) {// 檢查矩陣是否可以相乘
            return null;//若長度不相符則回傳null
        }
        double[][] result = new double[A.length][B[0].length];// 建立儲存結果的矩陣
        for (int i = 0; i < A.length; i++) {// 執行矩陣乘法
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result; // 返回結果矩陣
    }
    public static double[][] inMatrix(double[][] matrix) {// 計算反矩陣的函式
        double det = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]; // 計算行列式
        if (det == 0) {
            return null; // 若行列式為0，則矩陣不可逆
        }
        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / det;
        inverse[0][1] = -matrix[0][1] / det;
        inverse[1][0] = -matrix[1][0] / det;
        inverse[1][1] = matrix[0][0] / det;
        return inverse;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取2x2矩陣
        double[][] matrix = new double[2][2];
        System.out.println("Enter the elements of the 2x2 matrix (space separated):");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        // 計算反矩陣
        double[][] inverse = inMatrix(matrix);
        if (inverse == null) {
            System.out.println("The matrix is not invertible.");
            return;
        }

        // 驗證反矩陣是否正確
        double[][] result = MatMultply(matrix, inverse);
        System.out.println("The result of multiplying the matrix and its inverse:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.printf("%.2f ", result[i][j]);
            }
            System.out.println();
        }

        scanner.close();
    }
}
//此程式使用 Scanner 讓使用者輸入2*2矩陣的具體數值。
//檢查2*2矩陣是否有反矩陣。
// 矩陣乘法公式參考:https://zh.wikipedia.org/zh-tw/%E7%9F%A9%E9%99%A3%E4%B9%98%E6%B3%95
