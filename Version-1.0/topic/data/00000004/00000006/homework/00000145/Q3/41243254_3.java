//app5_test5
//filename:app5_test5
//function:反轉所給的數字
//author:xiao
//date:10/11
//version:11.0.12

import java.util.Scanner;

public class app5_test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入一個數字: ");
        int number = scanner.nextInt();
        
        int reversed = 0;
        
        while (number != 0) {
            int digit = number % 10; // 取出最後一位數字
            reversed = reversed * 10 + digit; // 將反轉後的數字更新
            number /= 10; // 去掉最後一位數字
        }
        
        // 輸出結果
        System.out.println("反轉後的數字: " + reversed);
        
        scanner.close();
    }
}
