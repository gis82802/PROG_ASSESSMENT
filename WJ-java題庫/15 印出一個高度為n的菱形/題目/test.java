import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("請輸入一個奇數整數 (n): ");
        int n = scanner.nextInt();
        scanner.close();

        // 檢查輸入是否為奇數
        if (n % 2 == 0) {
            System.out.println("請輸入一個奇數。");
            return;
        }

        int half = n / 2;

        // 印出上半部菱形 (包含中間最寬的一行)
        for (int i = 0; i <= half; i++) {
            // 印出空格
            for (int j = 0; j < half - i; j++) {
                System.out.print(" ");
            }
            // 印出星號
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 印出下半部菱形
        for (int i = half - 1; i >= 0; i--) {
            // 印出空格
            for (int j = 0; j < half - i; j++) {
                System.out.print(" ");
            }
            // 印出星號
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}