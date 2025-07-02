import java.util.Scanner;

public class app5_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入一個整數：");
        int number = scanner.nextInt();
        int reversedNumber = reverseDigits(number);
        System.out.println("反轉後的數字為：" + reversedNumber);
    }

    public static int reverseDigits(int number) {
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return reversed;
    }
}
