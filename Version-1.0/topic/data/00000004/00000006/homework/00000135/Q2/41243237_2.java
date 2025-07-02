/*
filename:app5_2
function:Find well-ordered number
author:PoXsun
date:2024/10/11
version:11.0.12
*/

import java.util.Scanner;

public class app5_2{
	public static void main(String[] args) {
        	Scanner scanner = new Scanner(System.in);
        
        	// 判斷單個數字是否為 well-ordered number
        	System.out.print("請輸入一個數字: ");
        	int number = scanner.nextInt();
        	if (isWellOrdered(number)) {// 呼叫 isWellOrdered 來判斷是否為 well-ordered number
            	System.out.println(number + " 是 well-ordered number.");
        	} 
		else {
            	System.out.println(number + " 不是 well-ordered number.");
        	}
        
        	// 計算 1 到 10000 中的 well-ordered number
        	int count = 0;
        	for (int i = 1; i <= 10000; i++) {
            		if (isWellOrdered(i)) {
               	 		count++;
            		}
        	}
        	System.out.println("1 到 10000 中有 " + count + " 個 well-ordered number.");
    	}

    	// 判斷是否為 well-ordered number
   	public static boolean isWellOrdered(int number) {
        	int previousDigit = 10;  // 初始化為大於 9 的值
        	while (number > 0) {
            		int currentDigit = number % 10;
            		if (currentDigit >= previousDigit) {
                		return false;
            		}
            	previousDigit = currentDigit;
            	number /= 10;
        	}
        	return true;
    	}
}
