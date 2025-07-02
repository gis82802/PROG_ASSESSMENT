// file name: app6_3
// author: 41243142
// version:
// function: 
// date: 24/10/18

import java.util.Scanner;

public class app6_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入三角形高度 (0 < n <= 20): ");
        int n = scanner.nextInt();
        
        if (n <= 0 || n > 20) {
            System.out.println("高度必須在 1 到 20 之間");
            return;
        }

        System.out.println("下三角形：");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.print("請輸入特定數字 (num < 100000): ");
        int num = scanner.nextInt();
        
        if (num >= 100000) {
            System.out.println("數字必須小於 100000");
            return;
        }
        int rows = (int) Math.ceil((Math.sqrt(1 + 8 * num) - 1) / 2);
        int[][] tri = new int[rows][];
        int count = 1;

        for (int i = 0; i < rows; i++) {
            tri[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                tri[i][j] = count++;
            }
        }

        int ccount = 0;  
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                if (tri[i][j] == num) {
                    System.out.println("數字 " + num + " 出現在位置 (" + (i + 1) + ", " + (j + 1) + ")");
                    ccount++;
                }
            }
        }

        if (ccount == 0) {
            System.out.println("數字 " + num + " 在下三角形中找不到。");
        }
    }
}
