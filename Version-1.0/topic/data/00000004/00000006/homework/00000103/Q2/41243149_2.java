import java.util.Scanner;

public class hw2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a num: ");
        int n = sc.nextInt();
        
        if (isWON(n)) {
            System.out.println(n + " is a WON.");//WON well-order number由小到大
        } else {
            System.out.println(n + " is not a WON.");
        }
    }

    // 判斷是否WON
    public static boolean isWON(int n) {
        int prev = 10; //>9
        while (n > 0) {
            int cur = n % 10;
            if (cur >= prev) {
                return false;
            }
            prev = cur;
            n /= 10;
        }
        return true;
    }
}
