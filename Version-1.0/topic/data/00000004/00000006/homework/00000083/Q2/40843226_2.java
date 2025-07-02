import java.util.Scanner;

public class WellOrderedNumber {

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入一個數字: ");
        int number = scanner.nextInt();

        scanner.close();

        
        String numberStr = Integer.toString(number);

        // 假設數字是 well-ordered number，初始化為 true
        boolean isWellOrdered = true;

        // 從第一位數開始，檢查每一位數是否小於後一位
        for (int i = 0; i < numberStr.length() - 1; i++) {
            // 比較當前位數與下一位數的大小
            if (numberStr.charAt(i) >= numberStr.charAt(i + 1)) {
                isWellOrdered = false; // 如果發現前一位數不小於後一位，設為 false
                break; 
            }
        }

        if (isWellOrdered) {
            System.out.printf("數字 %d 是 well-ordered number%n", number);
        } else {
            System.out.printf("數字 %d 不是 well-ordered number%n", number);
        }

	int wellOrderedCount = 0; 

        for (int n = 1; n < 100000; n++) {
            boolean isCurrentWellOrdered = true;
            String numStr = Integer.toString(n);

            for (int i = 0; i < numStr.length() - 1; i++) {
                if (numStr.charAt(i) >= numStr.charAt(i + 1)) {
                    isCurrentWellOrdered = false;
                    break;
                }
            }

            if (isCurrentWellOrdered) {
                wellOrderedCount++; // 如果是 well-ordered number，計數器加 1
            }
        }

        
        System.out.printf("小於 100000 的 well-ordered number 數量為: %d%n", wellOrderedCount);
  
    }
}
