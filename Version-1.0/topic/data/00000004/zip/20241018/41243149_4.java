import java.util.Scanner;

public class hw4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 輸入高度
        System.out.print("請輸入三角形的高度 (n <= 20): ");
        int n = sc.nextInt();
        
        // 確保n不超過20
        if (n > 20) {
            System.out.println("高度必須小於或等於20");
            return;
        }
        
        // 建立並顯示下三角陣列
        int[][] triangle = new int[n][];
        
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1]; // 設定每一行的大小
            
            // 填充陣列並顯示
            for (int j = 0; j <= i; j++) {
                System.out.print("* "); // 顯示 *
            }
            System.out.println(); // 換行
        }
        
        sc.close();
    }
}
