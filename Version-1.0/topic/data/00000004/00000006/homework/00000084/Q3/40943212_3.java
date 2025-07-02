/*
	filename:Java_1011_03
	function:將輸入的數字反轉
	author:陳廷威 40943212
	datetime:2024/10/11
	version:1.0
*/

import java.util.Scanner;

public class Java_1011_03 {
    
    // 反轉一個整數
    public static int reverseNumber(int number) {
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;   // 取出最後一位數
            reversed = reversed * 10 + digit;  // 將取出的數字加到反轉的數字上
            number /= 10;   // 移除已經取出的最後一位數
        }
        return reversed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 輸入一個整數
        System.out.print("請輸入一個整數來進行反轉: ");
        int inputNumber = scanner.nextInt();
        
        // 計算並顯示反轉後的結果
        int reversedNumber = reverseNumber(inputNumber);
        System.out.println("反轉後的數字是: " + reversedNumber);
        
        scanner.close();
    }
}

