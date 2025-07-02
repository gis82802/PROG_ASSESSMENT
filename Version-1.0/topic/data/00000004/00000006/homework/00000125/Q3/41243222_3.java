/*
filename:app 5_6
funtion:reverse number
auther:ToBoShu
date:2024/10/11
version:jdk23
*/
/*
System.out.println();
import java.util.Scanner;
Scanner sc = new Scanner(System.in);
int x = sc.nextInt();
throws Exxception
Thread.sleep(x);
Math.pow(x,2.0);
Math.squt(x);
*/


import java.util.Scanner;

public class app5_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入要判斷的值: ");
        
        // 讀取輸入的整數
        int val = sc.nextInt();
        int reversed = 0;

        // 反轉整數
        while (val != 0) {
            int digit = val % 10; // 取出最後一位數字
            reversed = reversed * 10 + digit; // 將數字反轉
            val /= 10;
        }

        

        // 輸出反轉後的數字及去零的結果
        System.out.println("反轉結果為: " + reversed);

        sc.close();
    }
}
