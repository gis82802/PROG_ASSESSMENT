/**
 * Project Name: Hw04
 * Author: 41243144 温博鈞
 * Description:
 *      輸入一連串的數字，輸出原始陣列，並輸出排序後的陣列
 * Functionality:
 *      - Scanner: 建立使用者輸入
 * 
 * Last Edit Date: 2024-10-18
 */
package October.oct_18;

import java.util.Scanner;

public class Hw04 {
    public static void main(String[] args) {
        //使用者輸入
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入矩陣大小: ");
        int n = input.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("請輸入矩陣，由上至下，由左至右");

        //讀取陣列
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        System.out.print("請輸入去掉的行(row)及列(col): ");
        int remove_row = input.nextInt();
        int remove_col = input.nextInt();

        // 移除指定行和列，建立新矩陣
        int[][] matrix_2 = new int[n - 1][n - 1];

        int matrix_row_count = 0;

        for (int i = 0; i < n; i++) {
            if (i == remove_row) continue;
            int matrix_col_count = 0;
            for (int j = 0; j < n; j++) {
                if (j == remove_col) continue;
                matrix_2[matrix_row_count][matrix_col_count] = matrix[i][j];
                matrix_col_count++;
            }
            matrix_row_count++;
        }

        // 計算行列式
        int determinant = calculate_determinant(matrix_2);
        System.out.println("行列式的值為: " + determinant);

        input.close();
    }

    // 計算行列式的遞迴方法
    public static int calculate_determinant(int[][] matrix) {
        int len = matrix.length;

        // 當矩陣為 2x2 時直接計算
        if (len == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            // 生成子矩陣
            int[][] sub_matrix = create_sub_matrix(matrix, 0, i);
            // 遞迴計算子矩陣的行列式，並乘以對應的符號與值
            sum += Math.pow(-1, i) * matrix[0][i] * calculate_determinant(sub_matrix);
        }

        return sum;
    }

    // 建立子矩陣，去掉指定的行與列
    public static int[][] create_sub_matrix(int[][] matrix, int exclude_row, int exclude_col) {
        int len = matrix.length;
        int[][] sub_matrix = new int[len - 1][len - 1];

        int r = -1;
        for (int i = 0; i < len; i++) {
            if (i == exclude_row) continue;
            r++;
            int c = -1;
            for (int j = 0; j < len; j++) {
                if (j == exclude_col) continue;
                c++;
                sub_matrix[r][c] = matrix[i][j];
            }
        }

        return sub_matrix;
    }
}
