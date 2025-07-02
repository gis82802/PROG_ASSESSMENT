import java.util.Scanner;

public class owoblue_java13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入高度 n
        System.out.print("請輸入一個高度 n (0 < n <= 20): ");
        int n = scanner.nextInt();

        if (n <= 0 || n > 20) {
            System.out.println("n 必須在 1 到 20 之間");
            return;
        }

        // 填充下三角矩陣
        int[][] triangle = new int[n][n];
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = num++;
            }
        }

        // 輸入要查找的數字
        System.out.print("請輸入要查找的數字 num (<100000): ");
        int searchNum = scanner.nextInt();

        // 找到該數字並輸出位置
        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (triangle[i][j] == searchNum) {
                    System.out.println("數字 " + searchNum + " 在位置: (" + (i + 1) + ", " + (j + 1) + ")");
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        if (!found) {
            System.out.println("找不到數字 " + searchNum);
        }
    }
}
