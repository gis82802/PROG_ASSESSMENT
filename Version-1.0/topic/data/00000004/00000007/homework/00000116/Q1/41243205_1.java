import java.util.Scanner;

public class ex1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int arr[];
        arr = new int[5];
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

        // 冒泡排序
        for (int i = 0; i < 5 - 1; i++) { // 控制比較的次數
            for (int k = 0; k < 5 - i - 1; k++) { // 進行相鄰元素的比較
                int temp;
                if (arr[k] > arr[k + 1]) {
                    temp = arr[k];
                    arr[k] = arr[k + 1];
                    arr[k + 1] = temp;
                }
            }
        }

        // 排序後
        System.out.print("\n排序後: ");
        for (int j = 0; j < 5; j++) {
            System.out.print(arr[j] + " ");
        }
    }
}
