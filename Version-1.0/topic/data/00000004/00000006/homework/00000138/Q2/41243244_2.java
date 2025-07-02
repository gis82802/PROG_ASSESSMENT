import java.util.Scanner;

public class app5_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入一個數字: ");
        String numberStr = scanner.nextLine();
        
        if (isWellOrderedNumber(numberStr)) {
            System.out.println("這是一個遞增數。");
        } else {
            System.out.println("這不是一個遞增數。");
        }
        
        scanner.close();
    }
    
    public static boolean isWellOrderedNumber(String numberStr) {
        for (int i = 0; i < numberStr.length() - 1; i++) {
            if (numberStr.charAt(i) >= numberStr.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
