import java.util.Scanner;

public class owoblue_java09 {
    // 判斷是否為良序數
    public static boolean isWellOrdered(int number) {
        String numStr = Integer.toString(number);  // 將數字轉換為字串
        for (int i = 0; i < numStr.length() - 1; i++) {
            if (numStr.charAt(i) >= numStr.charAt(i + 1)) {  // 判斷是否滿足 a < b 的條件
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 用戶輸入一個數字來判斷是否為良序數
        System.out.print("請輸入一個數字: ");
        int number = scanner.nextInt();

        if (isWellOrdered(number)) {
            System.out.println(number + " 是良序數。");
        } else {
            System.out.println(number + " 不是良序數。");
        }

        // 計算 1 到 100000 之間的良序數總數
        int count = 0;
        for (int i = 1; i <= 100000; i++) {
            if (isWellOrdered(i)) {
                count++;
            }
        }
        System.out.println("1 到 100000 之間共有 " + count + " 個良序數。");

        scanner.close();
    }
}

