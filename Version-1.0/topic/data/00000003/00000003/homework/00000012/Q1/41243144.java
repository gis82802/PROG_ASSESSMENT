/**
 * Project Name: Hw03
 * 
 * Author: 41243144 温博鈞
 * 
 * Description:
 *      1.輸入2個矩陣，並輸出矩陣相乘結果
 * 
 * Functionality:
 *      - matrixMult(): 輸入矩陣1和的行及列及矩陣陣列，並輸出相乘後結果，無回傳
 *      - reverse_matrix(): 輸入2x2矩陣，輸出反矩陣
 * 
 * Last Edit Date: 2024-10-25
 */
package October.oct_25;

import java.util.Scanner;

public class Hw03 {
    public static void main(String[] args) {
        // 創建輸入初始化
        Scanner input = new Scanner(System.in);

        // 定義矩陣1、2初始行列
        int row_1, col_1, row_2, col_2;

        // 輸入第一個矩陣
        System.out.print("請輸入第一個矩陣的長及寬(中間空格隔開):");
        col_1 = input.nextInt();
        row_1 = input.nextInt();

        int[][] matrix_1 = new int[col_1][row_1];

        System.out.print("請輸入第一個矩陣(用空格隔開或換行):");
        
        for(int i=0; i < col_1; i++){
            for(int j=0; j < row_1; j++){
                matrix_1[i][j] = input.nextInt();
            }
        }

        //輸入第2個矩陣

        System.out.print("請輸入第二個矩陣的長及寬(中間空格隔開):");
        col_2 = input.nextInt();
        row_2 = input.nextInt();

        int[][] matrix_2 = new int[col_2][row_2];

        System.out.print("請輸入第二個矩陣(用空格隔開或換行):");
        
        for(int i=0; i < col_2; i++){
            for(int j=0; j < row_2; j++){
                matrix_2[i][j] = input.nextInt();
            }
        }

        // 矩陣相乘函式
        matrixMult(row_1, col_1, matrix_1, row_2, col_2, matrix_2);

        // 輸入2x2矩陣

        System.out.println("請輸入一2x2矩陣: ");

        int [] matrix = new int[4];

        for(int i=0; i < 4; i++){
            matrix[i] = input.nextInt();
        }

        // 反矩陣函式
        reverse_matrix(matrix);


        input.close();
    }

    public static void matrixMult(int row_1, int col_1, int[][] matrix_1, int row_2, int col_2, int[][] matrix_2){
        /*
         * 將矩陣相乘後並輸出，若矩陣無法相乘則輸出null
         * 
         * args:
         *      - row_1: 第一個矩陣列數
         *      - col_1: 第一個矩陣行數
         *      - matrix_1: 第一個矩陣陣列
         *      - row_2: 第二個矩陣列數
         *      - col_2: 第二個矩陣行數
         *      - matrix_2: 第二個矩陣陣列
         * 
         * return: null
         */
        System.out.print("矩陣相乘結果為: ");

        if(row_1 != col_1){
            System.out.println("null");
        }else{
            int[][] result = new int[row_1][col_2];

            for (int i = 0; i < row_1; i++) {
                for (int j = 0; j < col_2; j++) {
                    for (int k = 0; k < row_2; k++)
                        result[i][j] += matrix_1[i][k] * matrix_2[k][j];
                }
            }
            
            for(int[] i: result){
                System.out.println();
                for(int j: i){
                    System.out.print(j + " ");
                }
            }
        }
    }
    public static void reverse_matrix(int[] matrix){
        /*
         * 輸出輸入矩陣之反矩陣，若det = 0代表沒有反矩陣
         * 
         * args:
         *      - matrix: 矩陣
         * 
         * return: null
         */
        int det = matrix[0] * matrix[3] - matrix[1] * matrix[2];

        if(det == 0){
            System.out.println("反矩陣不存在");
        }else{
            double reverse_det = 1.0 / det;
            System.out.print(String.format("%.3f ", matrix[0] * reverse_det));
            System.out.println(String.format("%.3f ", matrix[1] * reverse_det));
            System.out.print(String.format("%.3f ", matrix[2] * reverse_det));
            System.out.println(String.format("%.3f ", matrix[3] * reverse_det));
        }
    }

}
