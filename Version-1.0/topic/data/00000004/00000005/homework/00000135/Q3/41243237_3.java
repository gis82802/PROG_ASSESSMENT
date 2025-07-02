/*
filename:app4_4
function:Max Mid Min
author:PoXsun
date:2024/10/04
version:11.0.12
*/

import java.util.Scanner;

public class app4_4
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("輸入三個數字:");
		System.out.println("輸入數字一:");
      		int a = sc.nextInt();
		System.out.println("輸入數字二:");
       		int b = sc.nextInt();
     		System.out.println("輸入數字三:");
       		int c = sc.nextInt();

		int max = (a > b ? a : b) > c ? (a > b ? a : b) : c;//取最大值
		int min = (a < b ? a : b) < c ? (a < b ? a : b) : c;//取最小值
		int mid = a + b + c - max - min;//將中數取出

		System.out.println("從小到大的排序為:");
		System.out.println("min "+min);
		System.out.println("mid "+mid);
		System.out.println("max "+max);
	}
}