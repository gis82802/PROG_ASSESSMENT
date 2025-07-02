import java.util.Scanner;

public class java5_5_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();
        
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;  // 取出數字的最後一位
            reversed = reversed * 10 + digit;  // 將該位數字加入到反轉數字中
            num /= 10;  // 去掉最後一位數字
        }
        
        System.out.println("Reversed number: " + reversed);
    }
}
