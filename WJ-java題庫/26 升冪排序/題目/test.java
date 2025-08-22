import java.util.Scanner;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 步驟 1: 讀取陣列長度
        //System.out.print("請輸入陣列的長度：");
        int length = scanner.nextInt();
        
        int[] numbers = new int[length];
        
        // 步驟 2: 讀取陣列元素
        //System.out.println("請輸入 " + length + " 個整數：");
        for (int i = 0; i < length; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.close();

        // 步驟 3: 印出排序前的陣列
        System.out.println("排序前的陣列：" + Arrays.toString(numbers));

        // 步驟 4: 對陣列進行排序
        Arrays.sort(numbers);

        // 步驟 5: 印出排序後的陣列
        System.out.println("排序後的陣列：" + Arrays.toString(numbers));
    }
}