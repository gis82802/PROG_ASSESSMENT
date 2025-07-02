import java.util.Arrays;
import java.util.Scanner;
public class hw181{
	public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入陣列的大小: ");
        int n = sc.nextInt();

		int[] arr = new int[n];

        System.out.print("輸入陣列: ");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();         
        }

        System.out.print("排序前: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }

        System.out.print("排序小到大: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    arr[j] += arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];
                }
            }
        }

        System.out.print("排序大到小: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
	}
}