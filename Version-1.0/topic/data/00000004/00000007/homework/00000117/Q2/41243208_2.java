import java.util.HashMap;

public class test2{
    
    // 輸出每個元素的出現次數
    public static void printFrequency(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        
        // 計算每個元素出現的次數
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // 輸出每個元素的頻率
        for (int num : arr) {
            System.out.print(freqMap.get(num) + " ");
            freqMap.put(num, -1); // 已經印出過的元素設為-1 避免重複輸出
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {35, 8, 43, 6, 7, 1, 1, 2};
        
        // 輸出每個元素的出現次數
        System.out.print("Frequency of elements: ");
        printFrequency(arr);
    }
}