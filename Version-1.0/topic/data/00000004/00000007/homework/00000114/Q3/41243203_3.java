import java.util.Scanner;

public class TrianglesWithStarsAndNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 取得三角形高度
        System.out.print("請輸入三角形的高度 (1-20): ");
        int n = scanner.nextInt();

        // 檢查高度是否在範圍內
        if (n < 1 || n > 20) {
            System.out.println("高度必須在 1 到 20 之間！");
            return;
        }

        // Part (a): 建立並顯示上三角形
        System.out.println("上三角形 (使用*顯示)：");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");  // 使用*符號
            }
            System.out.println(); // 換行
        }

        // Part (b): 建立並顯示下三角形
        System.out.println("下三角形 (使用*顯示)：");
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");  // 使用*符號
            }
            System.out.println(); // 換行
        }

        // Part (c): 填充下三角形矩陣並查找特定數字
        System.out.print("請輸入一個小於100000的數字: ");
        int num = scanner.nextInt();

        // 最大尺寸以確保數字在範圍內
        int maxSize = 447; // 447*(448)/2 = 100056, 最大的三角形
        int[][] triangleNumbers = new int[maxSize][];

        // 填充下三角形矩陣
        int count = 1; // 用於填充數字
        for (int i = 0; i < maxSize; i++) {
            triangleNumbers[i] = new int[i + 1]; // 每行的列數
            for (int j = 0; j <= i; j++) {
                triangleNumbers[i][j] = count; // 填入順序數字
                count++;
            }
        }

        // 查找指定數字的位置
        boolean found = false;
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j <= i; j++) {
                if (triangleNumbers[i][j] == num) {
                    System.out.println("數字 " + num + " 出現在行 " + (i + 1) + " 列 " + (j + 1));
                    found = true;
                    break; // 找到後停止查找
                }
            }
            if (found) {
                break;
            }
        }

        if (!found) {
            System.out.println("數字 " + num + " 不在下三角形中。");
        }

        scanner.close();
    }
}
