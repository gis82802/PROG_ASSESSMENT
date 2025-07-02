/*
filename:app5_3
function:Reverse number
author:PoXsun
date:2024/10/11
version:11.0.12
*/

import java.util.Scanner;

public class app5_3{
	public static void main(String[] args) {
        	Scanner scanner = new Scanner(System.in);
        	System.out.print("請輸入一個數字: ");
        	int number = scanner.nextInt();
        	int reversed = reverse(number);
       	 	System.out.println("反轉後的數字是: " + reversed);
    	}

    	public static int reverse(int number) {
        	int reversed = 0;
        	while (number != 0) {
            		reversed = reversed * 10 + number % 10;
            		number /= 10;
        	}
        	return reversed;
    	}
}
