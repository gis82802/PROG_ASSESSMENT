import java.util.Scanner; // 導入 Scanner 類，用於讀取使用者輸入

public class Rever { // 定義類 Rever
    public static void main(String args[]) { // 主方法
        Scanner sc = new Scanner(System.in); // 創建 Scanner 物件以讀取使用者輸入
        System.out.print("請輸入一個整數: "); // 提示使用者輸入一個整數
        int n = sc.nextInt(); // 讀取使用者輸入的整數

        int reversed = 0; // 用於存儲反轉後的數字，初始值為 0
        // 使用 while 循環反轉數字，直到 n 為 0
        while (n != 0) { 
            int digit = n % 10; // 獲取當前最低位的數字
            reversed = reversed * 10 + digit; // 將當前數字添加到反轉結果的最低位
            n /= 10; // 去掉最低位數字
        }
        System.out.println("反轉後的數字: " + reversed); // 輸出反轉後的結果
        sc.close(); // 關閉 Scanner 物件，釋放資源
    }
}
