import java.util.Scanner;

public class ch5_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // 提示使用者輸入一個整數
            System.out.print("輸入一個整數 (輸入 '0' 以結束): ");
            String input = scanner.nextLine();

            // 嘗試將輸入轉換為整數
            try {
                int number = Integer.parseInt(input);
                
                // 檢查是否輸入0，若是則結束程式
                if (number == 0) {
                    System.out.println("程式結束。");
                    break; // 結束迴圈
                }

                // 初始化一個變數來儲存反轉後的數字
                int reversed = 0;

                // 使用迴圈反轉數字
                while (number != 0) {
                    int digit = number % 10;  // 取得最後一位數字
                    reversed = reversed * 10 + digit;  // 將該數字加入反轉後的數字
                    number /= 10;  // 移除最後一位數字
                }

                // 輸出反轉後的數字
                System.out.println("反轉後的數字: " + reversed);
            } catch (NumberFormatException e) {
                System.out.println("請輸入有效的整數。");
            }
        }

        scanner.close();
    }
}
