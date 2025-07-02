import java.util.Arrays;
import java.util.Scanner;

public class arrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 輸入陣列長度
        System.out.print("請輸入陣列的長度：");
        int length = scanner.nextInt();
        
        int[] array = new int[length];
        
        // 輸入陣列內容
        System.out.println("請輸入陣列內容：");
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        
        // 輸出排序前的陣列
        System.out.println("排序前的陣列：" + Arrays.toString(array));
        
        // 將陣列複製一份來進行排序
        int[] sortedArray = array.clone();
        Arrays.sort(sortedArray);
        
        // 輸出排序後的陣列
        System.out.println("排序後的陣列：" + Arrays.toString(sortedArray));
        
        scanner.close();
    }
}
