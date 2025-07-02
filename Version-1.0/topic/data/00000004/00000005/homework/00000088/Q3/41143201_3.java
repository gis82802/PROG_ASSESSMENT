import java.util.Arrays;
import java.util.Scanner;

public class numCompare{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 輸入資料數字的個數n
        System.out.print("請輸入數字的個數n: ");
        int n = scanner.nextInt();
        double[] num = new double[n];
        System.out.println("請輸入" + n + "個數字:");
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextDouble();  
        }

        double max = num[0];
        double min = num[0];

        // 使用迴圈比較找出最大值與最小值
        for (int i = 1; i < n; i++) {
            if (num[i] > max) {
                max = num[i];
            }
            if (num[i] < min) {
                min = num[i];
            }
        }
        
        // 找出中位數
        Arrays.sort(num);
        double median;
        if (n % 2 == 0) {
            median = (num[n / 2 - 1] + num[n / 2]) / 2;
        } else {
            median = num[n / 2];
        }

        System.out.println("最大值: " + max);
        System.out.println("最小值: " + min);
        System.out.println("中位數: " + median);
        
        scanner.close();
    }
}