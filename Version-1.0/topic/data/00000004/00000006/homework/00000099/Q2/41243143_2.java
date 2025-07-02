import java.util.Scanner; // 導入 Scanner 類，用於讀取使用者輸入

public class WellOrdered { // 定義類 WellOrdered
    public static void main(String args[]) { // 主方法
        Scanner sc = new Scanner(System.in); // 創建 Scanner 物件以讀取使用者輸入
        String n = sc.next(); // 讀取輸入的數字，作為字符串
        int ans = 0; // 用於判斷輸入的數字是否為 well-ordered number
        int num = 0; // 計數器，用於統計 well-ordered numbers 的數量

        System.out.println("(a)"); // 輸出部分 (a) 的標題
        
        // 檢查輸入的數字是否為 well-ordered number
        for (int i = 0; i < n.length() - 1; i++) {
            // 如果當前位大於或等於下一位，則不是 well-ordered number
            if (n.charAt(i) >= n.charAt(i + 1)) {
                ans = 0; // 設置 ans 為 0，表示不是
                break; // 終止循環
            }
            ans = 1; // 否則，設置 ans 為 1
        }

        // 輸出結果
        if (ans == 1) {
            System.out.println(n + " is a well-ordered number");
        } else {
            System.out.println(n + " is not a well-ordered number");
        }
        
        System.out.println("(b)"); // 輸出部分 (b) 的標題
        ans = 0; // 重置 ans，用於後面的判斷

        // 遍歷從 0 到 100000 的所有數字
        for (int i = 0; i <= 100000; i++) {
            n = String.valueOf(i); // 將當前整數轉換為字符串
            for (int j = 0; j < n.length() - 1; j++) {
                // 如果當前位大於或等於下一位，則不是 well-ordered number
                if (n.charAt(j) >= n.charAt(j + 1)) {
                    ans = 0; // 設置 ans 為 0，表示不是
                    break; // 終止循環
                }
                ans = 1; // 否則，設置 ans 為 1
            }
            // 如果是 well-ordered number，則計數器加一
            if (ans == 1) {
                num += 1;
            }
        }

        // 輸出 0 到 100000 的 well-ordered numbers 的數量
        System.out.println("1~100000 have " + num + " well-ordered numbers.");
        
        sc.close(); // 關閉 Scanner 物件，釋放資源
    }
}
