import java.util.Scanner;

public class hw3 {
    public static int[][] invMatrix(int a1[][]) {
        // 檢查行列式
        int a = a1[0][0];
        int b = a1[0][1];
        int c = a1[1][0];
        int d = a1[1][1];

        int determinant = a * d - b * c;

        if (determinant == 0) {
            System.out.println("該矩陣不可逆。");
            return null; // 返回 null 表示無反矩陣
        }

        // 計算反矩陣
        int[][] inverse = new int[2][2];
        inverse[0][0] = d / determinant; // d / (ad - bc)
        inverse[0][1] = -b / determinant; // -b / (ad - bc)
        inverse[1][0] = -c / determinant; // -c / (ad - bc)
        inverse[1][1] = a / determinant; // a / (ad - bc)

        return inverse;
    }

    public static int[][] MatMultply(int a[][], int b[][]) {
        int m1 = a.length;        // 第一個矩陣的行數
        int n1 = a[0].length;     // 第一個矩陣的列數
        int n2 = b[0].length;     // 第二個矩陣的列數
        int c[][] = new int[m1][n2];

        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n2; j++) {
                c[i][j] = 0; 
                for (int k = 0; k < n1; k++) {
                    c[i][j] += a[i][k] * b[k][j]; // 矩陣相乘計算
                }
            }
        }
        return c; // 返回結果矩陣
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("功能矩陣相乘:");
        
        // 輸入第一個矩陣
        System.out.print("輸入第一個矩陣大小 m x n: ");
        int m1 = scn.nextInt();
        int n1 = scn.nextInt();
        int[][] a = new int[m1][n1];
        System.out.print("輸入第一個矩陣內容: ");
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                a[i][j] = scn.nextInt();
            }
        }

        // 輸入第二個矩陣
        System.out.print("輸入第二個矩陣大小 m x n: ");
        int m2 = scn.nextInt();
        int n2 = scn.nextInt();
        int[][] b = new int[m2][n2];
        System.out.print("輸入第二個矩陣內容: ");
        for (int i = 0; i < m2; i++) {
            for (int j = 0; j < n2; j++) {
                b[i][j] = scn.nextInt();
            }
        }

        if (n1 != m2) {
            System.out.println("null");
        } else {
            int result[][] = MatMultply(a, b);
            System.out.println("結果矩陣:");
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n2; j++) {
                    System.out.print(result[i][j] + " "); 
                }
                System.out.println();
            }
        }

        System.out.println("功能反矩陣2 x 2:");
        // 輸入反矩陣
        int[][] a1 = new int[2][2];
        System.out.print("輸入矩陣內容: ");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                a1[i][j] = scn.nextInt();
            }
        }

        // 計算反矩陣
        int[][] inverse = invMatrix(a1);
        if (inverse != null) {
            System.out.println("反矩陣:");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.print(inverse[i][j] + " "); 
                }
                System.out.println();
            }
        }

        scn.close(); 
    }
}
