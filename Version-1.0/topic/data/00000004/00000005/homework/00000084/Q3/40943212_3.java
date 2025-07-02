/*
	filename:Java_1004_03
	function:三元運算子
	author:陳廷威 40943212
	datetime:2024/10/04
	version:1.0
*/

import java.util.Scanner;

public class Java_1004_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入三個數字
        System.out.println("請輸入三個數字:");
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        double num3 = scanner.nextDouble();

        // 使用三元運算子找出最大值
        double max = (num1 > num2) ? ((num1 > num3) ? num1 : num3) : ((num2 > num3) ? num2 : num3);

        // 使用三元運算子找出最小值
        double min = (num1 < num2) ? ((num1 < num3) ? num1 : num3) : ((num2 < num3) ? num2 : num3);

        // 找出剩下的中間值
        double mid = (num1 != max && num1 != min) ? num1 :
                     (num2 != max && num2 != min) ? num2 : num3;

        // 輸出結果
        System.out.println("從小到大排序的結果為:");
        System.out.println(min + " < " + mid + " < " + max);

        scanner.close();
    }
}
