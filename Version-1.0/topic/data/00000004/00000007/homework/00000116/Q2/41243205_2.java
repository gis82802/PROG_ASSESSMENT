import java.util.Scanner;

public class ex2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[5];
        System.out.print("輸入五個整數: ");

        // 取得使用者輸入
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        // 排序前
        System.out.print("排序前: ");
        for (int j = 0; j < 5; j++) {
            System.out.print(arr[j] + " ");
        }

        // 呼叫最大值排序
        int[] maxSortedArr = maxvalueSort(arr);

        // 呼叫最小值排序
        int[] minSortedArr = minvalueSort(arr);

        // 輸出最大值排序結果
        System.out.print("\n最大值排序後: ");
        for (int j = 0; j < 5; j++) {
            System.out.print(maxSortedArr[j] + " ");
        }

        // 輸出最小值排序結果
        System.out.print("\n最小值排序後: ");
        for (int j = 0; j < 5; j++) {
            System.out.print(minSortedArr[j] + " ");
        }
    }

    // 最大值排序函式
    public static int[] maxvalueSort(int[] arr) {
        int[] sortedArr = arr.clone(); // 複製原始陣列
        for (int i = 0; i < 5; i++) {
            if (i == 4) {
                sortedArr[i] = -1;
                break;
            }
            int imax = i + 1;
            for (int j = i + 2; j < 5; j++) {
                if (sortedArr[j] > sortedArr[imax]) {
                    imax = j; // 找到新的最大值索引
                }
            }
            sortedArr[i] = sortedArr[imax];
        }
        return sortedArr; // 返回排序後的陣列
    }

    // 最小值排序函式
    public static int[] minvalueSort(int[] arr) {
        int[] sortedArr = arr.clone(); // 複製原始陣列
        for (int i = 0; i < 5; i++) {
            if (i == 4) {
                sortedArr[i] = -1;
                break;
            }
            int imin = i + 1;
            for (int j = i + 2; j < 5; j++) {
                if (sortedArr[j] < sortedArr[imin]) {
                    imin = j; // 找到新的最小值索引
                }
            }
            sortedArr[i] = sortedArr[imin];
        }
        return sortedArr; // 返回排序後的陣列
    }
}
