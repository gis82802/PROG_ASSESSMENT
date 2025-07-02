import java.util.Scanner;

public class owoblue_java12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 輸入高度 n
        System.out.print("請輸入一個高度 n (0 < n <= 20): ");
        int n = scanner.nextInt();
        
        if (n <= 0 || n > 20) {
            System.out.println("n 必須在 1 到 20 之間");
            return;
        }

        // 下三角形
        System.out.print("\n");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 上三角形
        System.out.print("\n");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = i; k <= n; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

 
