import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        // 建立掃描器用來接收使用者輸入
        Scanner scanner = new Scanner(System.in);

        // 提示使用者輸入陣列的長度
        System.out.print("請輸入陣列的長度：");
        int n = scanner.nextInt();

        // 初始化陣列
        int[] arr = new int[n];

        // 提示使用者輸入陣列的元素
        System.out.println("請輸入陣列的元素：");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 輸出原始陣列
        System.out.println("原始陣列：" + Arrays.toString(arr));

        // 初始化兩個新陣列來存儲每個元素後面的最大值和最小值
        int[] maxArr = new int[n];
        int[] minArr = new int[n];

        // 設定最後一個元素的後面最大值和最小值為 -1，因為後面沒有其他元素
        maxArr[n - 1] = -1;
        minArr[n - 1] = -1;

        // 從陣列的倒數第二個元素開始，計算每個元素後面的最大值和最小值
        for (int i = n - 2; i >= 0; i--) {
            maxArr[i] = Math.max(arr[i + 1], maxArr[i + 1]);  // 計算最大值
            minArr[i] = Math.min(arr[i + 1], (minArr[i + 1] == -1 ? arr[i + 1] : minArr[i + 1]));  // 計算最小值
        }

        // 輸出每個元素後面的最大值和最小值陣列
        System.out.println("每個元素後面的最大值陣列：");
        System.out.println(Arrays.toString(maxArr));

        System.out.println("每個元素後面的最小值陣列：");
        System.out.println(Arrays.toString(minArr));

        // 關閉掃描器
        scanner.close();
    }
}
