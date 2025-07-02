/*
    filename: hw1025_3_1
    function: 撰寫函式計算二維矩陣乘法
    author: 41243204
    datetime: 2024/10/25
    version: 1.0
 */
import java.util.Scanner;

public class hw1025_3_1 {

    public static int[][] MatMultply(int[][] A, int[][] B) {
        if (A[0].length != B.length) {// 檢查矩陣是否可以相乘
            return null;//若長度不相符則回傳null
        }
        int[][] result = new int[A.length][B[0].length];// 建立儲存結果的矩陣
        for (int i = 0; i < A.length; i++) {// 執行矩陣乘法
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result; // 返回結果矩陣
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first matrix row and column (space separated): ");
        int rows1 = scanner.nextInt();
        int cols1 = scanner.nextInt();
        int[][] matrix1 = new int[rows1][cols1];// 讀取第一個矩陣的行和列

        System.out.println("Enter the first array elements (space separated):");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrix1[i][j] = scanner.nextInt();// 讀取第一個矩陣的元素
            }
        }

        System.out.print("Enter the second matrix row and column (space separated): ");
        int rows2 = scanner.nextInt();
        int cols2 = scanner.nextInt();
        int[][] matrix2 = new int[rows2][cols2];// 讀取第二個矩陣的行和列

        System.out.println("Enter the second array elements (space separated):");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                matrix2[i][j] = scanner.nextInt();// 讀取第二個矩陣的元素
            }
        }
        int[][] result = MatMultply(matrix1, matrix2);// 執行矩陣相乘
        if (result != null) {
            System.out.println("The result matrix is: ");
            for (int[] row : result) {
                for (int val : row) {
                    System.out.print(val + " "); // 輸出結果
                }
                System.out.println();
            }
        } else {
            System.out.println("The matrices cannot be multiplied due to size mismatch.");
        }
        scanner.close();
    }
}
//此程式使用 Scanner 讓使用者輸入兩個矩陣的行數、列數以及具體數值。
//檢查兩個矩陣是否可以相乘，若不能相乘則回傳 null，並告知使用者無法相乘。
//若兩個矩陣可以相乘，程式會執行矩陣乘法，並輸出乘積矩陣的結果。
//矩陣乘法公式參考:https://zh.wikipedia.org/zh-tw/%E7%9F%A9%E9%99%A3%E4%B9%98%E6%B3%95