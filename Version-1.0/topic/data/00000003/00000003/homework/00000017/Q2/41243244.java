import java.util.Scanner;

public class app7_2 {

    // 矩陣相乘 (僅處理 2x2 矩陣)
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int[][] result = new int[2][2];
        
        // 計算 A * B
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = A[i][0] * B[0][j] + A[i][1] * B[1][j];
            }
        }
        
        return result;
    }

    // 驗證是否為單位矩陣 (2x2)
    public static boolean isIdentityMatrix(int[][] matrix) {
        int[][] identity = {{1, 0}, {0, 1}};
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (matrix[i][j] != identity[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // 輸入 2x2 矩陣
    public static int[][] inputMatrix(Scanner scanner, String name) {
        int[][] matrix = new int[2][2];
        System.out.println("輸入矩陣 " + name + " 的 2x2 元素:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入矩陣 A 和 B
        int[][] A = inputMatrix(scanner, "A");
        int[][] B = inputMatrix(scanner, "B");

        // 計算 A * B
        int[][] result = multiplyMatrices(A, B);

        // 驗證結果是否為單位矩陣
        if (isIdentityMatrix(result)) {
            System.out.println("矩陣 A 和 B 是互為反矩陣。");
        } else {
            System.out.println("矩陣 A 和 B 不是互為反矩陣。");
        }

        scanner.close();
    }
}
