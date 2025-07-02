import java.util.Scanner;
public class Pi2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("輸入一個數字:");
        int num = scn.nextInt();
        boolean w = true;
        while (num >= 10) {
            int num2 = num % 10;
            int di = (num / 10) % 10;

            if (num2 <= di) {
                System.out.println("is not a well-ordered number");
                w = false;
                break;
            }
            num /= 10;
        }

        if (w) {
            System.out.println("well-ordered number");
        }
    }
}
