import java.util.Scanner;

public class FindMinMaxMid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入三個整數，用空格分隔：");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        // 找出最小值 min
        int min = a < b ? (a < c ? a : c) : (b < c ? b : c);

        // 找出最大值 max
        int max = a > b ? (a > c ? a : c) : (b > c ? b : c);

        // 找出中位數 mid
        int mid = a + b + c - min - max;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("最小值: " + min);
        System.out.println("中位數: " + mid);
        System.out.println("最大值: " + max);

        scanner.close();
    }
}