import java.util.Scanner;

public class hw3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入三個數字
        System.out.print("輸入第一個數字: ");
        int a = scanner.nextInt();
        System.out.print("輸入第二個數字: ");
        int b = scanner.nextInt();
        System.out.print("輸入第三個數字: ");
        int c = scanner.nextInt();

        // 使用三元運算子找最大值
        int max = (a > b) ? (a > c ? a : c) : (b > c ? b : c);

        // 使用三元運算子找最小值
        int min = (a < b) ? (a < c ? a : c) : (b < c ? b : c);

        // 中間值 = 總和 - 最大值 - 最小值
        int middle = a + b + c - max - min;

        // 輸出結果
        System.out.println("最小值: " + min);
        System.out.println("中間值: " + middle);
        System.out.println("最大值: " + max);

        scanner.close();
    }
}
