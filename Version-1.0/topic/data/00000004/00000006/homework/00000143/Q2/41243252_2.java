import java.util.Scanner;

public class ch5_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        while (true) {
            System.out.print("輸入要檢測的數字(輸入0停止): ");
            number = scanner.nextInt();
            
            if (number == 0) {
                System.out.println("跳出程式");
                break;
            }

            int previousDigit = 10;  // 設置初始值為10，因為任何數字都會小於10
            int temp = number;       // 使用 `temp` 來保存 `number`，以免直接修改原始值

            // 判斷數字是否為well-ordered
            while (temp > 0) {
                int currentDigit = temp % 10; // 提取最右邊的數字

                // 如果當前位數大於上一位數，則輸出並跳出內部循環
                if (currentDigit > previousDigit) {
                    System.out.println("該數字不是 well-ordered");
                    break;
                }

                // 更新前一位數，繼續處理下一位
                previousDigit = currentDigit;
                temp = temp / 10;  // 移除最右邊的數字
            }

            // 如果成功遍歷到最後，則表示該數字是 well-ordered
            if (temp == 0) {
                System.out.println("該數字是 well-ordered");
            }
        }

        scanner.close();
    }
}
