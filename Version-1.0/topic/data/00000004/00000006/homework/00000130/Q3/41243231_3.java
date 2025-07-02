/*
    Filename: "hwapp03_1011"
    Function: Reverse
    Author: SHUN-YE XU
    Version: 23
    date: 2024/10/11
*/

import java.util.Scanner;
public class hwapp03_1011
{
    public static void main(String args[])
    {
		Scanner scn = new Scanner(System.in);
		int num, reverse, count, temp;
		boolean flag = false;

		// 使用者輸入
		System.out.print("Input number:");
		num = scn.nextInt();

		// 設定初值
		reverse = count = 0;
		temp = num;

		// 計算位數
		while(temp != 0)
		{
			count++;
			temp /= 10;
		}

		// 反轉
		count--;
		while(num != 0)
		{
			if(flag || num%10 != 0)
			{
			flag = true;
			reverse += (num%10) * Math.pow(10, count);
			}
			count--;
			num /= 10;
		}

		System.out.println("Reverse = " + reverse);
    }
}