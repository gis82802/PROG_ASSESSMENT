import java.util.Scanner;

public class wellordered {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // (a) 判斷用戶輸入的數字是否為 well-ordered number
        System.out.print("請輸入一個數字: ");
        int userInput = scanner.nextInt();

        if (isWellOrdered(userInput)) {
            System.out.println(userInput + " 是一個有序數字 (well-ordered number)。");
        } else {
            System.out.println(userInput + " 不是一個有序數字 (well-ordered number)。");
        }

        // (b) 計算 1 到 100000 之間有多少個 well-ordered numbers
        int count = countWellOrderedNumbers(100000);
        System.out.println("在 1 到 100000 之間有 " + count + " 個有序數字 (well-ordered numbers)。");
    }

    // (a) 判斷一個數字是否為 well-ordered number
    public static boolean isWellOrdered(int num) {
        String numStr = Integer.toString(num); // 將數字轉為字串以便逐位檢查
        for (int i = 0; i < numStr.length() - 1; i++) {
            if (numStr.charAt(i) >= numStr.charAt(i + 1)) {
                return false; // 如果任意一位不滿足遞增條件，則返回 false
            }
        }
        return true; // 全部位數滿足遞增條件則返回 true
    }

    // (b) 計算 1 到 max 範圍內有多少個 well-ordered numbers
    public static int countWellOrderedNumbers(int max) {
        int count = 0;
        for (int i = 1; i <= max; i++) {
            if (isWellOrdered(i)) {
                count++;
            }
        }
        return count;
    }
}
