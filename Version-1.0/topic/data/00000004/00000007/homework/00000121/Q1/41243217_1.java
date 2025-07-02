import java.util.Arrays;
import java.util.Scanner;

public class hw1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 提示使用者輸入陣列的大小
        System.out.print("請輸入陣列的大小: ");
        int size = scanner.nextInt();

        // 建立陣列
        int[] arr = new int[size];

        // 提示使用者輸入陣列的元素
        System.out.println("請輸入陣列的元素：");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // 輸出排序前的陣列
        System.out.println("排序前: " + Arrays.toString(arr));

        // 對陣列進行排序
        Arrays.sort(arr);

        // 輸出排序後的陣列
        System.out.println("排序後: " + Arrays.toString(arr));
        
        scanner.close();
    }
}
