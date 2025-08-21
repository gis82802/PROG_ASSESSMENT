import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("請輸入一個整數：");
        int number = scanner.nextInt();
        scanner.close();

        int reversedNumber = 0;
        
        // 處理負數情況
        int sign = 1;
        if (number < 0) {
            sign = -1;
            number = -number;
        }

        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }

        System.out.println(reversedNumber * sign);
    }
}