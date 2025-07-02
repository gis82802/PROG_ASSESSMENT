import java.util.Arrays;
import java.util.Scanner;

public class hw1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        // 輸入陣列大小
        System.out.print("請輸入陣列大小: ");
        int size=scanner.nextInt();
        int[] array=new int[size];

        // 輸入陣列內容
        System.out.println("請輸入 " + size + " 個整數:");
        for (int i = 0; i < size; i++) {
            array[i]=scanner.nextInt();
        }

        System.out.println("排序前的陣列: " + Arrays.toString(array));

        // 排序
        Arrays.sort(array);
        System.out.println("排序後的陣列: " + Arrays.toString(array));
        scanner.close();
    }
}
