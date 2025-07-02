import java.util.Scanner;

public class SquareArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        // 提示用户输入有效的 n
        do {
            System.out.print("Enter (0 < n <= 4): ");
            n = scanner.nextInt();
        } while (n <= 0 || n > 4);

        // 创建 n x n 的方形数组
        int[][] square = new int[n][n];

        // 填充方形数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                square[i][j] = i * n + j; // 用数字填充
            }
        }


        int rowToDelete, colToDelete;
        System.out.print("Enter the row to delete (0 to " + (n - 1) + "): ");
        rowToDelete = scanner.nextInt();
        System.out.print("Enter the column to delete (0 to " + (n - 1) + "): ");
        colToDelete = scanner.nextInt();

        int newSize = n - 1; 
        int[][] subMatrix = new int[newSize][newSize];

        for (int i = 0, newI = 0; i < n; i++) {
            if (i == rowToDelete) continue; 
            for (int j = 0, newJ = 0; j < n; j++) {
                if (j == colToDelete) continue;
                subMatrix[newI][newJ] = square[i][j];
                newJ++;
            }
            newI++;
        }
        int determinant = 0;
        for (int x = 0; x < newSize; x++) {
            int[][] tempMatrix = new int[newSize - 1][newSize - 1];
            for (int i = 1; i < newSize; i++) {
                for (int j = 0; j < newSize; j++) {
                    if (j < x) {
                        tempMatrix[i - 1][j] = subMatrix[i][j];
                    } else if (j > x) {
                        tempMatrix[i - 1][j - 1] = subMatrix[i][j];
                    }
                }
            }
            int minorDeterminant = 1;
            for (int i = 0; i < newSize - 1; i++) {
                minorDeterminant *= tempMatrix[i][0];
            }
            determinant += (int) Math.pow(-1, x) * subMatrix[0][x] * minorDeterminant;
        }

        System.out.println("The determinant of the remaining matrix is: " + determinant);

        scanner.close();
    }
}
