import java.util.Scanner;

public class test3{
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // (a) 建立下三角形，並以符號顯示
        System.out.println("請輸入下三角形的高度 (1 <= n <= 20):");
        int n = scanner.nextInt();
        
        if (n <= 0 || n > 20) {
            System.out.println("無效的高度輸入。請確保 1 <= n <= 20。");
            return;
        }

        System.out.println("下三角形的符號表示如下：");
        // 顯示下三角形
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // (b) 將數字填入下三角形，並找到特定數字的位置
        System.out.println("請輸入一個小於 100000 的數字:");
        int num = scanner.nextInt();
        
        if (num >= 100000) {
            System.out.println("輸入的數字必須小於 100000。");
            return;
        }

        // 計算下三角形矩陣中數字的位置
        int[][] matrix = new int[n][n];
        int count = 1;  // 用來依序填入數字
        int rowPos = -1;
        int colPos = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                matrix[i][j] = count;
                if (count == num) {
                    rowPos = i;
                    colPos = j;
                }
                count++;
            }
        }

        if (rowPos != -1 && colPos != -1) {
            System.out.println("數字 " + num + " 出現在第 " + (rowPos + 1) + " 列, 第 " + (colPos + 1) + " 行.");
        } else {
            System.out.println("數字 " + num + " 不在下三角形矩陣中。");
        }

        scanner.close();
    }
}
