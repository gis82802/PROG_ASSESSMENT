import java.util.Scanner;

public class hw6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("�п�J�@�Ӿ��:");
        int number = scanner.nextInt();
        System.out.println("����᪺�Ʀr��: " + reverseNumber(number));
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
