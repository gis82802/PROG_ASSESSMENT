import java.util.Scanner;

public class q1025 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        // Input size of matrices
        System.out.println("輸入第一個矩陣的行數和列數:");
        int r1 = scr.nextInt();
        int c1 = scr.nextInt();

        System.out.println("輸入第二個矩陣的行數和列數:");
        int r2 = scr.nextInt();
        int c2 = scr.nextInt();

        if (c1 != r2||c2!=r1) {
            System.out.println("Null");
            return;
        }

        int[][] t = new int[r1][c1];
        int[][] y = new int[r2][c2];
        int[][] result = new int[r1][c2];

        System.out.println("輸入矩陣 t 的值:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                t[i][j] = scr.nextInt();
            }
        }

        System.out.println("輸入矩陣 y 的值:");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                y[i][j] = scr.nextInt();
            }
        }

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    result[i][j] += t[i][k] * y[k][j];
                }
            }
        }

        System.out.println("矩陣相乘的結果:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
