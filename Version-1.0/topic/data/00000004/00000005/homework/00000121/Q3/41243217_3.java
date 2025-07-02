import java.util.Scanner; // 引入 Scanner 類別以便從控制台讀取輸入

public class test3 {
    public static void main(String[] args) {
        // 創建 Scanner 物件來讀取輸入
        Scanner scanner = new Scanner(System.in);

        // 提示用戶輸入第一個數字
        System.out.println("請輸入第一個數字：");
        int a = scanner.nextInt(); // 讀取第一個整數
        
        // 提示用戶輸入第二個數字
        System.out.println("請輸入第二個數字：");
        int b = scanner.nextInt(); // 讀取第二個整數
        
        // 提示用戶輸入第三個數字
        System.out.println("請輸入第三個數字：");
        int c = scanner.nextInt(); // 讀取第三個整數

        // 計算最大值、最小值和中間值
        int max = (a > b ? a : b) > c ? (a > b ? a : b) : c; // 找到最大值
        int min = (a < b ? a : b) < c ? (a < b ? a : b) : c; // 找到最小值
        int mid = a + b + c - max - min; // 中間值 = 總和 - 最大值 - 最小值

        // 輸出結果
        System.out.println("從小到大的排序為：");
        System.out.println(min); // 輸出最小值
        System.out.println(mid);  // 輸出中間值
        System.out.println(max);  // 輸出最大值
        
        scanner.close(); // 關閉 Scanner 物件以釋放資源
    }
}
