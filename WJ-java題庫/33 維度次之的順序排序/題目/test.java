import java.util.Arrays;
import java.util.Scanner;

public class test {

    /**
     * 對二維陣列進行排序，優先依據第一維度，次要依據第二維度。
     * @param matrix 待排序的二維陣列。
     * @return 排序後的二維陣列。
     */
    public static int[][] twoDimSort(int[][] matrix) {
        // 使用 Arrays.sort() 配合 Lambda 表達式來定義客製化排序規則
        Arrays.sort(matrix, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // 比較第一維度
            } else {
                return Integer.compare(a[1], b[1]); // 第一維度相同，比較第二維度
            }
        });
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("請輸入資料數量: ");
        int n = scanner.nextInt();
        
        int[][] matrix = new int[n][2];
        //System.out.println("請輸入 " + n + " 筆資料 (每筆兩個數字):");
        for (int i = 0; i < n; i++) {
            matrix[i][0] = scanner.nextInt();
            matrix[i][1] = scanner.nextInt();
        }
        scanner.close();

        System.out.println("排序前:");
        printMatrix(matrix);

        // 呼叫排序函式
        int[][] sortedMatrix = twoDimSort(matrix);

        System.out.println("\n排序後:");
        printMatrix(sortedMatrix);
    }
}