/*
 * project name: Hw02
 * project author: 41243144温博鈞
 * project description: 判斷用戶輸入是否符合 well-ordered number，另外計算在100000內共有多少well-ordered number
 * 
 * project function: 
 * 1. 判斷number是否符合 well-ordered number
 * 2. 判斷number 內共有多少個well-orderded number
 * 
 * latest changed date: 10-11-2024
 */
package October.oct_11;

import java.util.Scanner;;

public class Hw02 {
    public static void main(String[] args) {
        // 定義範圍為10000
        int FIND_NUMBER = 100000;
        // 使用者輸入
        System.out.print("請輸入number: ");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        if (is_well_ordered(number)){
            System.out.println(String.format("%d 是 well-ordered number", number));
        }else{
            System.out.println(String.format("%d 不是 well-ordered number", number));
        }

        System.out.println(String.format("在1000以內符合well-ordered number數量為: %d 個", total(FIND_NUMBER)));
        input.close();
    }

    public static boolean is_well_ordered(int number){
        /*
         * 判斷number是否符合 well-ordered number
         * 
         * @param number 用戶輸入數值
         * @return number reverse
         */

        // 若數字<10為well-ordered number
        if(number < 10) return true;
        
        // 餘數初始化
        int rem = number % 10;
        number /= 10;

        // 當number 大於0的時候不斷循環直到number歸零，當number歸零時reverse_number則為number倒豎
        while(number > 0){
            if(number % 10 <= rem) return false;
            rem = number % 10;
            number /= 10;
        }

        return true;
    }

    public static int total(int number){
        /*
         * 判斷number 內共有多少個well-orderded number
         * 
         * @param number 範圍
         * @return 範圍內符合well-ordered number個數
         */

        int count = 0;
        for(int i=0; i <= number; i++){
            if(is_well_ordered(i)){
                count++;
            }
        }
        return count;
    }
}
