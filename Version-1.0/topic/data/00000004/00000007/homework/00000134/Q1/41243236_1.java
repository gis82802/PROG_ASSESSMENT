import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
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

        // 輸出排序前的陣列
        System.out.println("排序前的陣列: " + Arrays.toString(array));

        // 排序陣列
        Arrays.sort(array);

        // 輸出排序後的陣列
        System.out.println("排序後的陣列: " + Arrays.toString(array));

        scanner.close();
    }
}
