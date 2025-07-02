/**
 * 41243145 黃培峰
 * 
 * Description:
 * 1.輸入2個矩陣，並輸出矩陣相乘結果
 * 
 * Functionality:
 * - matrixMult(): 輸入矩陣1和的行及列及矩陣陣列，並輸出相乘後結果，無回傳
 * - reverse_matrix(): 輸入2x2矩陣，輸出反矩陣
 * 
 */

 package October.oct_25;

 import java.util.Scanner;
 
 public class Hw03 {
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
 
         // 輸入第一個矩陣
         System.out.print("請輸入第一個矩陣的行與列 (中間空格隔開): ");
         int rows1 = input.nextInt();
         int cols1 = input.nextInt();
         int[][] matrix1 = new int[rows1][cols1];
         System.out.println("請輸入第一個矩陣 (用空格隔開或換行): ");
         for (int i = 0; i < rows1; i++) {
             for (int j = 0; j < cols1; j++) {
                 matrix1[i][j] = input.nextInt();
             }
         }
 
         // 輸入第二個矩陣
         System.out.print("請輸入第二個矩陣的行與列 (中間空格隔開): ");
         int rows2 = input.nextInt();
         int cols2 = input.nextInt();
         int[][] matrix2 = new int[rows2][cols2];
         System.out.println("請輸入第二個矩陣 (用空格隔開或換行): ");
         for (int i = 0; i < rows2; i++) {
             for (int j = 0; j < cols2; j++) {
                 matrix2[i][j] = input.nextInt();
             }
         }
 
         // 矩陣相乘
         matrixMult(rows1, cols1, matrix1, rows2, cols2, matrix2);
 
         // 輸入2x2矩陣並計算其反矩陣
         System.out.println("請輸入一個2x2矩陣: ");
         int[] matrix = new int[4];
         for (int i = 0; i < 4; i++) {
             matrix[i] = input.nextInt();
         }
 
         // 計算反矩陣
         reverseMatrix(matrix);
 
         input.close();
     }
 
     /**
      * 矩陣相乘，若無法相乘則輸出null
      */
     public static void matrixMult(int rows1, int cols1, int[][] matrix1, int rows2, int cols2, int[][] matrix2) {
         System.out.print("矩陣相乘結果為: ");
         if (cols1 != rows2) {
             System.out.println("null");
         } else {
             int[][] result = new int[rows1][cols2];
             for (int i = 0; i < rows1; i++) {
                 for (int j = 0; j < cols2; j++) {
                     for (int k = 0; k < cols1; k++) {
                         result[i][j] += matrix1[i][k] * matrix2[k][j];
                     }
                 }
             }
             for (int[] row : result) {
                 System.out.println();
                 for (int element : row) {
                     System.out.print(element + " ");
                 }
             }
         }
     }
 
     /**
      * 輸出輸入矩陣之反矩陣，若det = 0則表示無反矩陣
      */
     public static void reverseMatrix(int[] matrix) {
         int determinant = matrix[0] * matrix[3] - matrix[1] * matrix[2];
         if (determinant == 0) {
             System.out.println("反矩陣不存在");
         } else {
             double invDet = 1.0 / determinant;
             System.out.printf("%.3f %.3f\n", matrix[3] * invDet, -matrix[1] * invDet);
             System.out.printf("%.3f %.3f\n", -matrix[2] * invDet, matrix[0] * invDet);
         }
     }
 }
 