// file name: app6_4
// author: 41243142
// version:
// function: 
// date: 24/10/18

import java.util.Scanner;

public class app6_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入 n (n <= 4): ");
        int n = scanner.nextInt();
        if (n <= 0 || n > 4) {
            System.out.println("n 必須在 1 到 4 之間");
            return;
        }
        
        int[][] a = new int[n][n];
        System.out.println("請輸入 " + n + " * " + n + " 的陣列:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        System.out.println("輸入的陣列:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("請輸入要去掉的行 i (0 到 " + (n - 1) + "): ");
        int ir = scanner.nextInt();
        System.out.print("請輸入要去掉的列 j (0 到 " + (n - 1) + "): ");
        int jr = scanner.nextInt();

        if (ir < 0 || ir >= n || jr < 0 || jr >= n) {
            System.out.println("行和列不在範圍內");
            return;
        }
        if (n == 1) {
            System.out.println("去掉第 " + ir + " 行和第 " + jr + " 列後的新矩陣: 沒有可用的矩陣");
            System.out.println("新矩陣的行列式: 0");
            return;
        }

        int[][] b = new int[n - 1][n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < ir && j < jr) {
                    b[i][j] = a[i][j];
                } else if (i < ir && j > jr) {
                    b[i][j - 1] = a[i][j];
                } else if (i > ir && j < jr) {
                    b[i - 1][j] = a[i][j];
                } else if (i > ir && j > jr) {
                    b[i - 1][j - 1] = a[i][j];
                }
            }
        }

        System.out.println("去掉第 " + ir + " 行和第 " + jr + " 列後的新矩陣:");
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
        int d = ca(b);
        System.out.println("新矩陣的行列式: " + d);
    }

private static int ca(int[][] c) {
    int size = c.length;
    if (size == 1) {
        return c[0][0];
    } else if (size == 2) {
        return c[0][0] * c[1][1] - c[0][1] * c[1][0];
    } else if (size == 3) {
        return c[0][0] * (c[1][1] * c[2][2] - c[1][2] * c[2][1])
             - c[0][1] * (c[1][0] * c[2][2] - c[1][2] * c[2][0])
             + c[0][2] * (c[1][0] * c[2][1] - c[1][1] * c[2][0]);
    } else if (size == 4) {
        return c[0][0] * ca(new int[][] {
                {c[1][1], c[1][2], c[1][3]},
                {c[2][1], c[2][2], c[2][3]},
                {c[3][1], c[3][2], c[3][3]}
        }) - c[0][1] * ca(new int[][] {
                {c[1][0], c[1][2], c[1][3]},
                {c[2][0], c[2][2], c[2][3]},
                {c[3][0], c[3][2], c[3][3]}
        }) + c[0][2] * ca(new int[][] {
                {c[1][0], c[1][1], c[1][3]},
                {c[2][0], c[2][1], c[2][3]},
                {c[3][0], c[3][1], c[3][3]}
        }) - c[0][3] * ca(new int[][] {
                {c[1][0], c[1][1], c[1][2]},
                {c[2][0], c[2][1], c[2][2]},
                {c[3][0], c[3][1], c[3][2]}
        });
    }
    return 0; 
}
}
