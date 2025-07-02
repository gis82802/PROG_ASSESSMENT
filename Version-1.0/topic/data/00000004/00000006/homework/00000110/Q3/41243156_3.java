import java.util.Scanner;

public class hwc {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("請輸入一個整數: ");
        int n = s.nextInt();
        int t = 0;
        while (n != 0) {
            int d = n % 10;  // 取得最後一位數字
            t = t * 10 + d;  // 將數字添加到反轉結果中
            n /= 10;  // 去掉最後一位數字
        }
        
        System.out.println("反轉後的數字是: " + t);
        s.close();
    }
}