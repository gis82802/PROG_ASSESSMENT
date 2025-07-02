/*
    filename: hw4_3
    function: 數字排列
    author: 41243204
    datetime: 2024/10/11
    version: 1.0
*/
import java.util.Scanner;

public class hw4_3 {
    public static int reverse(int num) {
        int reversedNum = 0;

        while (num > 0) {
            int digit = num % 10;// 取出最後一位
            reversedNum = reversedNum * 10 + digit;// 將當前的反轉結果*10後加上這個數字
            num /= 10; // 去掉最後一位數字
        }

        return reversedNum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("輸入一個整數: ");
        int inputNum = scanner.nextInt();
        int reversedNum = reverse(inputNum);
        System.out.println("此數反轉後是: " + reversedNum);//輸出結果
        scanner.close();
    }
}
