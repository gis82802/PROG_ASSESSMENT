import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        // 檢查輸入是否在有效範圍內 (2到10)
        while (true) {
            //System.out.print("請輸入一個介於 2 到 10 之間的數字 n: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n >= 2 && n <= 10) {
                    break;
                }
            } else {
                scanner.next(); // 消耗無效輸入
            }
            System.out.println("輸入不正確，請重新輸入。");
        }
        scanner.close();

        final int TOTAL_AREAS = 17;
        boolean[] isPowered = new boolean[TOTAL_AREAS + 1]; // 索引 1 到 17
        int currentArea = 1;

        System.out.print("停電順序: ");
        
        for (int i = 0; i < TOTAL_AREAS; i++) {
            // 尋找下一個未停電的區域
            int count = 0;
            while (count < n) {
                // 如果當前區域未停電，計數器增加
                if (!isPowered[currentArea]) {
                    count++;
                }
                
                // 檢查是否達到指定的步數
                if (count == n) {
                    // 如果下一個停電的區域是已停過的，則繼續找下一個
                    if (isPowered[currentArea]) {
                        count = 0; // 重置計數
                    }
                }
                
                // 移至下一個區域
                if (count < n) {
                    currentArea = (currentArea % TOTAL_AREAS) + 1;
                }
            }
            
            // 找到下一個停電區域，標記為已停電並印出
            System.out.print(currentArea + " ");
            isPowered[currentArea] = true;
            
            // 準備下一次迴圈的起點
            currentArea = (currentArea % TOTAL_AREAS) + 1;
            while (isPowered[currentArea]) {
                currentArea = (currentArea % TOTAL_AREAS) + 1;
            }
        }
        System.out.println();
    }
}