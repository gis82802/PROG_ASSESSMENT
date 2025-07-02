import java.util.Scanner;
import java.util.Arrays;

public class MaxMinMiddle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入三個數字
        System.out.print("輸入第一個數字 A: ");
        double A = scanner.nextDouble();

        System.out.print("輸入第二個數字 B: ");
        double B = scanner.nextDouble();

        System.out.print("輸入第三個數字 C: ");
        double C = scanner.nextDouble();

        // 將三個數字存入數組
        double[] numbers = {A, B, C};

        // 使用 Arrays.sort() 進行排序
        Arrays.sort(numbers);

        // 最小值、最大值和中間值
        double min = numbers[0];
        double middle = numbers[1];
        double max = numbers[2];

        // 輸出結果
        System.out.println("最小值: " + min);
        System.out.println("中間值: " + middle);
        System.out.println("最大值: " + max);

        scanner.close();
    }
}
