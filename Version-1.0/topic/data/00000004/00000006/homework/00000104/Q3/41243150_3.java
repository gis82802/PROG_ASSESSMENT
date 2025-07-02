import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input an integer number: "); 
        int num = scan.nextInt();
        int ans = 0;
        int num1=num;
        // Reverse the number
        while (num != 0) {
            ans *= 10;          // Shift current answer to the left
            ans += num % 10;   // Add the last digit of num to ans
            num /= 10;         // Remove the last digit from num
        }

        System.out.printf("%d -> %d\n", num1, ans); 
        scan.close(); 
    }
}
