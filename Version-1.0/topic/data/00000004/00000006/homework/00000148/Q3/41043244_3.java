import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入一個數字:");
        long number = scanner.nextLong();
        System.out.println("反轉後的數字是：" + reverse(number));
    }
    public static long reverse(long number) {
        long reversed = 0;
        while (number != 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        return reversed;
    }
}
