/*
filename:app 5_5
funtion:well odered number
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

public class app5_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入要判斷的值: ");
        
        // 讀取輸入的整數
        int val = sc.nextInt();
        int tempValue = val;
        int count = 0;
        // 計算數字位數
        if (tempValue == 0) {
            count = 1;
        } else {
            while (tempValue != 0) {
                tempValue /= 10;
                count++;
            }
        }

        int[] digits = new int[count];
        tempValue = val; 

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = tempValue % 10;  // 取出最後一位數字
            tempValue /= 10;  // 去掉最後一位數字
        }

    
        boolean flag = true;
	boolean Sflag = false;
        for (int i = 1; i < count; i++) { 
            if (digits[i] <= digits[i - 1]) {
                flag = false;
	    if (digits[i] == digits[i - 1]) {
                Sflag = true;
                break;              }
	    
            }
        }

        // 輸出結果
        if (flag) 
            System.out.println("此數為 well-ordered number");
	else if (Sflag) 
            System.out.println("此數有相同值,不為 well-ordered number");
 	else 
            System.out.println("此數非 well-ordered number");
     

        int wellOrderedCount = 0;
        for (int i = 0; i <= 100000; i++) {
            // 重新計算數字位數
            tempValue = i;
            count = 0;

            if (tempValue == 0) {
                count = 1;
            } else {
                while (tempValue != 0) {
                    tempValue /= 10;
                    count++;
                }
            }

            int[] tempDigits = new int[count];
            tempValue = i; 

            // 將數字的每一位存入陣列
            for (int j = count - 1; j >= 0; j--) {
                tempDigits[j] = tempValue % 10; // 取出最後一位數字
                tempValue /= 10; // 去掉最後一位數字
            }

            // 判斷該數字是否為 well-ordered number
            boolean tempFlag = true; // 假設為 well-ordered number
            boolean tempSflag = false; // 假設沒有相同的數字

            for (int j = 1; j < count; j++) {
                if (tempDigits[j] <= tempDigits[j - 1]) {
                    tempFlag = false; // 若有不符合的情況，則標記為 false
                    if (tempDigits[j] == tempDigits[j - 1]) {
                        tempSflag = true; // 若有相同的數字，則標記為 true
                        break;
                    }
                }
            }

            // 統計 well-ordered number 的數量
            if (tempFlag) {
                wellOrderedCount++;
            }
        }

        // 輸出 0 到 100000 之間的 well-ordered number 的數量
        System.out.println("0 到 100000 之間有 " + wellOrderedCount + " 個 well-ordered number");

        sc.close();
    }
    
}

       