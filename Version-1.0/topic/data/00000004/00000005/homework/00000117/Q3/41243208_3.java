import java.util.Scanner;

public class hw10043 {
    public static void main(String[] args) {
        // 建立 Scanner 物件，從使用者輸入讀取數據
        Scanner scanner = new Scanner(System.in);
        
        // 提示使用者輸入三個數字
        System.out.println("請輸入三個數字 (a, b, c): ");
        
        // 使用 Scanner 讀取三個數字並存入變數 a, b, c
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        
        // 將三個數字存入陣列
        double[] numbers = {a, b, c};
        
        // 計算最大值
        double max = Math.max(a, Math.max(b, c));
        
        // 計算最小值
        double min = Math.min(a, Math.min(b, c)); 
        
        // 計算中間值 (總和減去最大和最小值)
        double mid = a + b + c - max - min; 
        
        // 輸出最大值、最小值和中間值，並格式化輸出小數點後兩位
        System.out.printf("最大值: %.2f\n", max);
        System.out.printf("最小值: %.2f\n", min);
        System.out.printf("中間值: %.2f\n", mid);
        
        // 關閉 Scanner
        scanner.close();
    } 
}
