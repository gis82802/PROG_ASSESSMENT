import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("請輸入三個整數 (以空格分隔): ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        scanner.close();

        System.out.println("使用 if-else");
        
        // (a) 找出最大值和最小值 (if-else)
        int max_a = num1;
        if (num2 > max_a) {
            max_a = num2;
        }
        if (num3 > max_a) {
            max_a = num3;
        }

        int min_a = num1;
        if (num2 < min_a) {
            min_a = num2;
        }
        if (num3 < min_a) {
            min_a = num3;
        }
        
        // (a) 找出中間值 (不使用 if-else)
        int sum_a = num1 + num2 + num3;
        int middle_a = sum_a - max_a - min_a;

        System.out.println("最大值: " + max_a);
        System.out.println("最小值: " + min_a);
        System.out.println("中間值: " + middle_a);

        System.out.println(); // 換行

        System.out.println("使用三元運算子");
        
        // (b) 找出最大值和最小值 (三元運算子)
        int max_b = (num1 > num2) ? ((num1 > num3) ? num1 : num3) : ((num2 > num3) ? num2 : num3);
        int min_b = (num1 < num2) ? ((num1 < num3) ? num1 : num3) : ((num2 < num3) ? num2 : num3);
        
        // (b) 找出中間值 (不使用三元運算子)
        int sum_b = num1 + num2 + num3;
        int middle_b = sum_b - max_b - min_b;
        
        System.out.println("最大值: " + max_b);
        System.out.println("最小值: " + min_b);
        System.out.println("中間值: " + middle_b);
    }
}