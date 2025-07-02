import java.util.Scanner;

public class hw10112 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // (a) 檢查使用者輸入的數字是否為 well-ordered number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        if (isWellOrdered(number)) {
            System.out.println(number + " is a well-ordered number.");
        } else {
            System.out.println(number + " is not a well-ordered number.");
        }

        // (b) 計算小於100000的 well-ordered number 的個數
        int count = countWellOrderedNumbersBelow(100000);
        System.out.println("There are " + count + " well-ordered numbers below 100000.");
    }

    // 檢查一個數字是否為 well-ordered number
    public static boolean isWellOrdered(int number) {
        int previousDigit = 10;  // 初始化前一位數字為 10，確保每一位數字都小於前一位數
        while (number > 0) {
            int currentDigit = number % 10;
            if (currentDigit >= previousDigit) {
                return false; // 若當前位數字大於或等於前一位數字，則非 well-ordered
            }
            previousDigit = currentDigit; // 更新前一位數字
            number /= 10; // 去掉當前位數字
        }
        return true;
    }

    // 計算小於 limit 的 well-ordered number 個數
    public static int countWellOrderedNumbersBelow(int limit) {
        int count = 0;
        for (int i = 1; i < limit; i++) {
            if (isWellOrdered(i)) {
                count++; // 如果是 well-ordered number，計數加一
            }
        }
        return count;
    }
}
