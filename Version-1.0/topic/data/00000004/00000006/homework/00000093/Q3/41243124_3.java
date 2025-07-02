import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("輸入數字: ");
        int n = sc.nextInt();
        System.out.println(n);

        int rev = 0;  
        while (n != 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }

        System.out.println("顛倒後: " + rev);

        sc.close();
    }
}
