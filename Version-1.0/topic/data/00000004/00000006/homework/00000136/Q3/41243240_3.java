/*
filename:hw3
function:輸入數字後將數字反轉(以整數型態輸出)
author:傅學呈
data:2024/10/11
version:11.0.12
*/
import java.util.Scanner;

public class hw3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入數字: ");
        int number = scanner.nextInt();       //儲存輸入數字
	int reversed = 0;		      //儲存反轉後的數字

        while (number != 0) {
            int lastnum = number % 10;          // 取得最後一位數
            reversed = reversed * 10 + lastnum; // 反轉數字
            number = number / 10;               // 移除最後一位數
        }

        System.out.println("Reversed number: " + reversed);

        scanner.close();
    }
}
