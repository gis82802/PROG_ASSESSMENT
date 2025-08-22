import java.util.Random;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("請輸入隨機種子碼 (seed): ");
        long seed = scanner.nextLong();
        scanner.close();

        // 使用使用者輸入的種子碼來初始化 Random 物件
        Random random = new Random(seed);

        // 產生並印出 seed 個 double 數字
        for (int i = 0; i < seed; i++) {
            double randomNumber = random.nextDouble();
            System.out.print(randomNumber + "\n");

            // 每 10 個數字換行
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }
}