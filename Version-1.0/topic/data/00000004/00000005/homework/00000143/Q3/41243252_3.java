/*
日期:2024/10/4
作者:41243252蔡承叡
版本:jdk23
題目:4_3
*/
import java.util.Scanner;

public class ch4_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 提示使用者輸入三個數字
        System.out.print("請輸入第一個數字：");
        int num1 = scanner.nextInt();

        System.out.print("請輸入第二個數字：");
        int num2 = scanner.nextInt();

        System.out.print("請輸入第三個數字：");
        int num3 = scanner.nextInt();

        int max = (num1 > num2 ? (num1 > num3 ? num1 : num3) : (num2 > num3 ? num2 : num3));
        int min = (num1 < num2 ? (num1 < num3 ? num1 : num3) : (num2 < num3 ? num2 : num3));

        // 使用公式：中位數 = 總和 - 最大值 - 最小值
        int median = num1 + num2 + num3 - max - min;

        // 輸出結果
        System.out.printf("最大值：%d\n", max);
        System.out.printf("最小值：%d\n", min);
        System.out.printf("中位數：%d\n", median);

        scanner.close();
    }
}
