import java.util.Scanner;

public class test {

    // 0-9的點陣圖定義 (5x4)
    private static final String[][] DIGITS = {
        {"####", "#00#", "#00#", "#00#", "####"}, // 0
        {"0#00", "##00", "0#00", "0#00", "0#00"}, // 1
        {"####", "000#", "####", "#000", "####"}, // 2
        {"####", "000#", "####", "000#", "####"}, // 3
        {"#00#", "#00#", "####", "000#", "000#"}, // 4
        {"####", "#000", "####", "000#", "####"}, // 5
        {"####", "#000", "####", "#00#", "####"}, // 6
        {"####", "000#", "000#", "000#", "000#"}, // 7
        {"####", "#00#", "####", "#00#", "####"}, // 8
        {"####", "#00#", "####", "000#", "####"}  // 9
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("請輸入一串數字 (0-9): ");
        String input = scanner.nextLine();
        scanner.close();

        // 檢查輸入是否為數字
        if (!input.matches("\\d+")) {
            System.out.println("輸入格式不正確，請輸入數字。");
            return;
        }

        // 逐行印出點陣圖
        for (int row = 0; row < 5; row++) {
            for (int i = 0; i < input.length(); i++) {
                int digit = Character.getNumericValue(input.charAt(i));
                String pattern = DIGITS[digit][row];
                
                // 替換 # 和 0
                pattern = pattern.replace('1', '#').replace('0', '0');
                System.out.print(pattern);
                
                // 除了最後一個數字，每個數字後都加一個空格
                if (i < input.length() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}