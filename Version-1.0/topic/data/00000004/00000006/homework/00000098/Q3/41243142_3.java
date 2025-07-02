// File name: app5_3
// Author: 41243142
// Function: 反轉使用者輸入的數字順序
// Date: 24/10/11
// Version:

import java.util.Scanner;

public class app5_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入一個整數: ");
        int number = scanner.nextInt();

        int rdNumber = rNumber(number); 
        System.out.println("反轉後的數字為: " + rdNumber);  
        
        scanner.close();
    }

    public static int rNumber(int number) {
        int a = 0;
        while (number != 0) {
            int digit = number % 10; 
            a = a * 10 + digit; 
            number /= 10; 
        }
        return a;
    }
}
