import java.util.Scanner;

public class number {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 請用戶輸入第一個整數
        System.out.print("請輸入第一個整數: ");
        int firstNumber = scanner.nextInt();
        int reversedFirst = reverseDigits(firstNumber);
        System.out.println("第一個整數反轉後的數字是: " + reversedFirst);

        // 請用戶輸入第二個整數
        System.out.print("請輸入第二個整數: ");
        int secondNumber = scanner.nextInt();
        int reversedSecond = reverseDigits(secondNumber);
        System.out.println("第二個整數反轉後的數字是: " + reversedSecond);

        // 請用戶輸入第三個整數
        System.out.print("請輸入第三個整數: ");
        int thirdNumber = scanner.nextInt();
        int reversedThird = reverseDigits(thirdNumber);
        System.out.println("第三個整數反轉後的數字是: " + reversedThird);
    }

    // 反轉整數的位數
    public static int reverseDigits(int num) {
        int reversed = 0;

        while (num != 0) {
            int digit = num % 10; // 獲取最後一位數字
            reversed = reversed * 10 + digit; // 將該位數字加到反轉結果中
            num /= 10; // 刪除最後一位數字
        }

        return reversed; // 返回反轉後的數字
    }
}
