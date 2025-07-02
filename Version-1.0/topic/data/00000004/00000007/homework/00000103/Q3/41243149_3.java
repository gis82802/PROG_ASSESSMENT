import java.util.Scanner;

public class hw3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 輸入矩陣大小 N (1 <= N <= 4)
        int N = sc.nextInt();
        if (N < 1 || N > 4) return;

        // 輸入矩陣元素
        int[][] m = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                m[i][j] = sc.nextInt();
            }
        }
        
        // 輸出原矩陣
        System.out.println("原矩陣:");
        printMatrix(m, N);

        // 輸入要刪除的行列
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;

        // 構建新矩陣，刪除指定的行列
        int[][] nm = new int[N - 1][N - 1];
        for (int i = 0, nr = 0; i < N; i++) {
            if (i == r) continue;  // 跳過要刪除的行
            for (int j = 0, nc = 0; j < N; j++) {
                if (j == c) continue;  // 跳過要刪除的列
                nm[nr][nc++] = m[i][j];
            }
            nr++;
        }

        // 輸出新矩陣
        System.out.println("新矩陣:");
        printMatrix(nm, N - 1);

        // 計算新矩陣的行列式
        int det = cal(nm, N - 1);
        System.out.println("新矩陣的行列式值: " + det);

        sc.close();
    }

    // 矩陣輸出
    public static void printMatrix(int[][] m, int s) {
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 計算行列式
    public static int cal(int[][] m, int s) {
        if (s == 1) {
            return m[0][0];
        } else if (s == 2) {
            return m[0][0] * m[1][1] - m[0][1] * m[1][0];
        } else {
            int det = 0;
            for (int i = 0; i < s; i++) {
                int[][] minor = new int[s - 1][s - 1];  // 創建子矩陣
                for (int j = 0, nr = 0; j < s; j++) {
                    if (j == i) continue;  // 跳過要刪除的列
                    for (int k = 1; k < s; k++) {
                        minor[nr][j < i ? j : j - 1] = m[k][j];  // 填充子矩陣
                    }
                    if (j < i) nr++;
                }
                det += Math.pow(-1, i) * m[0][i] * cal(minor, s - 1);  // 遞迴計算行列式
            }
            return det;
        }
    }
}
