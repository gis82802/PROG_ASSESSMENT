import java.util.Scanner;

public class hw6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入一個整數:");
        int number = scanner.nextInt();
        System.out.println("反轉後的數字為: " + reverseNumber(number));
        scanner.close();
    }

    public static int reverseNumber(int number) {
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return reversed;
    }
}
