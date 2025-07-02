import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("請輸入一個整數，輸入 'n' 結束程式。");

        while (true) {
            System.out.print("請輸入數字：");
            input = scanner.nextLine();

            // 檢查是否輸入 'n' 結束程式
            if (input.equalsIgnoreCase("n")) {
                break;
            }

            try {
                // 將輸入轉換為整數
                int number = Integer.parseInt(input);

                // 呼叫 reverse 函數進行反轉
                int reversedNumber = reverse(number);

                // 輸出反轉後的結果
                System.out.println("反轉後的數字是：" + reversedNumber);
            } catch (NumberFormatException e) {
                // 處理輸入錯誤
                System.out.println("輸入格式錯誤，請輸入整數或 'n'。");
            }
        }

        scanner.close();
    }

    /**
     * 反轉一個整數
     *
     * @param number 要反轉的數字
     * @return 反轉後的數字
     */
    public static int reverse(int number) {
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10; // 取出個位數
            reversed = reversed * 10 + digit; // 將個位數加到反轉後的數字末尾
            number /= 10; // 去掉個位數
        }
        return reversed;
    }
}