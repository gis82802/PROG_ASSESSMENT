/*
    filename: hw4_2_2
    function: 計算小於 100,000 的 well-ordered numbers
    author: 41243204
    datetime: 2024/10/11
    version: 1.0
*/

public class hw4_2_2 {

    // 檢查一個數字是否是 well-ordered
    public static boolean isWellOrdered(int num) {
        int prevDigit = 10; // 初始化前一位數，因為數字最大為9
        while (num > 0) {
            int currentDigit = num % 10;
            if (currentDigit >= prevDigit) {
                return false; // 如果當前數字大於或等於前一位，則false
            }
            prevDigit = currentDigit; // 更新前一位數
            num /= 10; // 去掉最後一位數字
        }
        return true; // 所有位數均符合條件
    }

    public static void main(String[] args) {
        int count = 0; // 計數器

        // 循環檢查每個數字
        for (int i = 1; i < 100000; i++) {
            if (isWellOrdered(i)) {
                count++; // 計數加一
            }
        }

        System.out.println("小於 100,000 的 well-ordered numbers 總數為: " + count);
    }
}
//此程式變數名稱皆有意義，方便閱讀。
//參考資料:https://stackoverflow.com/questions/40151408/finding-all-well-ordered-numbers-within-a-range-how-to-print-last-value-before