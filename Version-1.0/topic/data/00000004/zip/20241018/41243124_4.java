import java.util.Scanner;

public class HW10184{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("請輸入 n (n <= 4): ");
        int n = scn.nextInt();

        if (n > 4) {
            System.out.println("n 小於等於 4");
            return;
        }

        int[][] mat = new int[n][n];
        System.out.println("輸入矩陣元素: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        System.out.println("輸入的矩陣為: ");
        printMat(mat, n);

        System.out.print("輸入要去掉的列 i: ");
        int r = scn.nextInt();

        System.out.print("輸入要去掉的行 j: ");
        int c = scn.nextInt();

        int[][] newMat = rmRowCol(mat, n, r, c);
        System.out.println("去掉第 " + r + " 列與第 " + c + " 行後的新矩陣: ");
        printMat(newMat, n - 1);

        int det = calcDet(newMat, n - 1);
        System.out.println("新矩陣的行列式為: " + det);

        scn.close();
    }

    public static void printMat(int[][] mat, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] rmRowCol(int[][] mat, int size, int r, int c) {
        int[][] newMat = new int[size - 1][size - 1];
        int newRow = 0, newCol;

        for (int i = 0; i < size; i++) {
            if (i == r) continue;
            newCol = 0;
            for (int j = 0; j < size; j++) {
                if (j == c) continue;
                newMat[newRow][newCol] = mat[i][j];
                newCol++;
            }
            newRow++;
        }
        return newMat;
    }

    public static int calcDet(int[][] mat, int size) {
        if (size == 1) {
            return mat[0][0];
        }
        if (size == 2) {
            return mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
        }

        int det = 0;
        for (int col = 0; col < size; col++) {
            int[][] subMat = new int[size - 1][size - 1];
            for (int i = 1; i < size; i++) {
                int subCol = 0;
                for (int j = 0; j < size; j++) {
                    if (j == col) continue;
                    subMat[i - 1][subCol] = mat[i][j];
                    subCol++;
                }
            }
            det += Math.pow(-1, col) * mat[0][col] * calcDet(subMat, size - 1);
        }
        return det;
    }
}
