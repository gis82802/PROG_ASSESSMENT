/*
filename:WellOrderedNumber1
function:在1~10000中判斷有多少個WellOrderedNumber
author:傅學呈
data:2024/10/11
version:11.0.12
*/

public class WellOrderedNumber1 {
    public static void main(String[] args) {

        int count = 0; // 儲存有多少 well-ordered numbers

        // 從1到10000檢查每個數字
        for (int number = 1; number <= 10000; number++) {
            int num = number;
            int prenum = 10; // 設為一個比9大的數值
            
            boolean isWellOrdered = true; // 記錄是否為well-ordered
            
            // 開始檢查數字的每一位
            while (num > 0) {
                int current = num % 10;
                if (current >= prenum) {
                    isWellOrdered = false; // 不是well-ordered
                    break; // 跳出while迴圈，這個數字不合規則
                }
                prenum = current;
                num = num / 10; // 繼續檢查下一位
            }

            // 若這個數字是well-ordered，則count增加
            if (isWellOrdered) {
                count++;
            }
        }

        // 輸出結果
        System.out.println("在1~10000中的Well-Ordered numbers有" + count + " 個");
    }
}
