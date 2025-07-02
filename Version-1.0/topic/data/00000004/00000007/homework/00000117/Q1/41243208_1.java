import java.util.Arrays;

public class test1{
    
    // 輸出陣列
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {35, 8, 43, 6, 7, 1, 1, 2};
        
        // 輸出排序前的陣列
        System.out.print("Original array: ");
        printArray(arr);
        
        // 排序陣列
        Arrays.sort(arr);
        
        // 輸出排序後的陣列
        System.out.print("Sorted array: ");
        printArray(arr);
    }
}