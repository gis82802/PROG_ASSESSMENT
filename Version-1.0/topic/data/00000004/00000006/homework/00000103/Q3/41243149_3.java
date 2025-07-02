import java.util.Scanner;

public class hw3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an int: ");
        int n = sc.nextInt();
        
        System.out.println("Reversed num: " + revNum(n));
    }

    // 數字反轉的函數
    public static int revNum(int n) {
        int rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }
}
