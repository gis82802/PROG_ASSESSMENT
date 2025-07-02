import java.util.Scanner;

public class pi3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("輸入一個數:");
        int a = scn.nextInt();
        int w = 0;
        int i = 0;
        while (a > 0) {
            w = w * 10 + (a % 10);
            a /= 10;
        }

        System.out.println("倒轉數字為: " + w);
    }
}
