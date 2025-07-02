import java.util.Arrays;
import java.util.Scanner;

public class homework2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //輸入
        System.out.println("請輸入第一個數字：");
        int num1 = scanner.nextInt();
        System.out.println("請輸入第二個數字：");
        int num2 = scanner.nextInt();
        System.out.println("請輸入第三個數字：");
        int num3 = scanner.nextInt();

        //資料放入正列
        int[] numbers = {num1, num2, num3};

        Arrays.sort(numbers);
        //輸出
        System.out.println("最小值: " + numbers[0]);
        System.out.println("中間值: " + numbers[1]);
        System.out.println("最大值: " + numbers[2]);

        scanner.close();
    }
}
