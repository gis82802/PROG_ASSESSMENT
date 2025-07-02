import java.util.Scanner;

public class WellOrderedNumber {
    public static boolean isWellOrdered(int number) {
        String numStr = String.valueOf(number);
        for (int i = 1; i < numStr.length(); i++) {
            if (numStr.charAt(i) <= numStr.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("請輸入一個正整數 (輸入0結束): ");
            int number = scanner.nextInt();

            if (number == 0) {
                break;
            }

            if (isWellOrdered(number)) {
                System.out.println(number + " 是井然有序數");
            } else {
                System.out.println(number + " 不是井然有序數");
            }
        }

        scanner.close();
    }
}