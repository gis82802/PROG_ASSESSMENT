import java.util.Scanner;

public class hw10113 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 取得使用者輸入的數字
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // 反轉數字並顯示結果
        int reversed = reverseNumber(number);
        System.out.println("Reversed number: " + reversed);
    }

    // 反轉數字的順序
    public static int reverseNumber(int number) {
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10; // 取得當前位數字
            reversed = reversed * 10 + digit; // 將該位數字加到反轉後的數字上
            number /= 10; // 移除當前位數字
        }
        return reversed; // 返回反轉後的數字
    }
}
