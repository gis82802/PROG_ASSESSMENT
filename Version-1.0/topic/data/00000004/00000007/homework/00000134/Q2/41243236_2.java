import java.util.Arrays;
import java.util.Scanner;

public class ReplaceWithMaxAfter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入陣列大小
        System.out.print("請輸入陣列的大小: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        // 輸入陣列內容
        System.out.println("請輸入 " + n + " 個整數:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // 輸出原始陣列
        System.out.println("原始陣列: " + Arrays.toString(array));

        // 替換每個元素為它之後的最大值
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int maxAfter = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > maxAfter) {
                    maxAfter = array[j];
                }
            }
            result[i] = (maxAfter == Integer.MIN_VALUE) ? -1 : maxAfter; // 若沒有後續元素則設為 -1
        }

        // 輸出替換後的陣列，加上最後的 -1
        System.out.println("替換後的陣列: " + Arrays.toString(result) + "，最後一個元素是 -1 代表沒有後續數字。");

        scanner.close();
    }
}
