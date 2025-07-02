//app5_test4
//filename:app5_test4
//function:(1)判斷是否為良序數(2)輸出十萬內所有良序數
//author:xiao
//date:10/11
//version:11.0.12

import java.util.Scanner;

public class app5_test4 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        //設定單位至十萬
        int otd = 0, td = 0, th = 0, hu = 0, te = 0, single = 0;
        
        //輸入數字
        System.out.print("請輸入數字: ");
        int num = scn.nextInt();
        
        //追蹤各個單位的數字並保存
        if (num >= 100000)
            otd = num / 100000;
        if (num >= 10000)
            td = (num / 10000) - otd * 10;
        if (num >= 1000)
            th = (num / 1000) - otd * 100 - td * 10;
        if (num >= 100)
            hu = (num / 100) - otd * 1000 - td * 100 - th * 10;
        if (num >= 10)
            te = (num / 10) - otd * 10000 - td * 1000 - th * 100 - hu * 10;
        if (num >= 1)
            single = num - otd * 100000 - td * 10000 - th * 1000 - hu * 100 - te * 10;

        int[] digits = {otd, td, th, hu, te, single};
        boolean isOrdered = true;  // 追蹤是否是良序數
        
        //判斷是否為良序數
        for (int i = 0; i < digits.length - 1; i++) {
            if (digits[i] != 0 && digits[i] > digits[i + 1]) {
                isOrdered = false;
                break;
            }
        }

        if (isOrdered) {
            System.out.println("這組數字是良序數");
        } else {
            System.out.println("這組數字不是良序數");
        }


        // 輸出十萬內所有良序數
        System.out.println("十萬內的所有良序數:");


        // 追蹤各個單位的數字並保存
        for (int i = 1; i < 100000; i++) {
            otd = i / 100000;
            td = (i / 10000) % 10;
            th = (i / 1000) % 10;
            hu = (i / 100) % 10;
            te = (i / 10) % 10;
            single = i % 10;
       

            // 重置判斷標記
            digits = new int[]{otd, td, th, hu, te, single};
            isOrdered = true;  
            
            // 判斷是否為良序數
            for (int j = 0; j < digits.length - 1; j++) {
                if (digits[j] != 0 && digits[j] > digits[j + 1]) {
                    isOrdered = false;
                    break;
                }
            }

            if (isOrdered) {
                System.out.print(i+" ");
            }
        }
    }
}
