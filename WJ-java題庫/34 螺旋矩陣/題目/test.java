import java.util.Scanner;

public class test {

    public static int[][] spinMatrix(int n, int dir) {
        if (n < 1 || n > 20) {
            throw new IllegalArgumentException("n 的值必須介於 1 到 20 之間。");
        }
        
        int[][] matrix = new int[n][n];
        int num = 1;
        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = n - 1;

        if (dir == 1) { // 順時針
            while (rowStart <= rowEnd && colStart <= colEnd) {
                // 向右
                for (int i = colStart; i <= colEnd; i++) {
                    matrix[rowStart][i] = num++;
                }
                rowStart++;

                // 向下
                for (int i = rowStart; i <= rowEnd; i++) {
                    matrix[i][colEnd] = num++;
                }
                colEnd--;

                // 向左
                if (rowStart <= rowEnd) {
                    for (int i = colEnd; i >= colStart; i--) {
                        matrix[rowEnd][i] = num++;
                    }
                    rowEnd--;
                }

                // 向上
                if (colStart <= colEnd) {
                    for (int i = rowEnd; i >= rowStart; i--) {
                        matrix[i][colStart] = num++;
                    }
                    colStart++;
                }
            }
        } else if (dir == 2) { // 逆時針
            while (rowStart <= rowEnd && colStart <= colEnd) {
                // 向下
                for (int i = rowStart; i <= rowEnd; i++) {
                    matrix[i][colStart] = num++;
                }
                colStart++;

                // 向右
                for (int i = colStart; i <= colEnd; i++) {
                    matrix[rowEnd][i] = num++;
                }
                rowEnd--;
                
                // 向上
                if (colStart <= colEnd) {
                    for (int i = rowEnd; i >= rowStart; i--) {
                        matrix[i][colEnd] = num++;
                    }
                    colEnd--;
                }

                // 向左
                if (rowStart <= rowEnd) {
                    for (int i = colEnd; i >= colStart; i--) {
                        matrix[rowStart][i] = num++;
                    }
                    rowStart++;
                }
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%d ", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        
        for (int i = 0; i < numTestCases; i++) {
            int n = scanner.nextInt();
            int dir = scanner.nextInt();
            
            try {
                int[][] result = spinMatrix(n, dir);
                printMatrix(result);
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}