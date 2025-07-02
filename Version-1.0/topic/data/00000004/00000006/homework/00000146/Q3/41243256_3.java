import java.util.Scanner;

public class owoblue_java10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入一個數字: ");
        int input = scanner.nextInt();
        
        int reversed = 0;

        while (input != 0) {
            int digit = input % 10;
            reversed = reversed * 10 + digit; 
            input /= 10;
        }
        System.out.println("反轉後的數字是: " + reversed);
        scanner.close();
    }
}
