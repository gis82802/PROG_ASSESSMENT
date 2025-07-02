import java.util.Scanner;

public class hw9 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("請輸入數字: ");
        int num = scn.nextInt();
        int temp = num; 
        int reversed = 0; // 用於存放反轉後的數字

        while (num != 0) {
            int digit = num % 10; 
            reversed = reversed * 10 + digit; 
            num /= 10; // 移除最低位數字
        }

        System.out.println(temp + " -> " + reversed); 

    }
}
