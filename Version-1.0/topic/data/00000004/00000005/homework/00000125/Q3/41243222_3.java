/*
filename:app 4_4
funtion:min mid max
auther:ToBoShu
date:2024/10/04
version:jdk23
*/
/*
System.out.println();
import java.util.Scanner;
Scanner sc = new Scanner(system.in);
int x = sc.nextInt;
throws Exxception
Thread.sleep(x);
Math.pow(x,2.0);
Math.squt(x);
*/

import java.util.Scanner;

public class app4_4
{
	public static void main(String args[]) 

	{
	Scanner sc = new Scanner(System.in);
	int a, b, c, max, mid, min;
	//使用者輸入
	System.out.print("請輸入第一個值:");
	a = sc.nextInt();
	System.out.print("請輸入第二個值:");
	b = sc.nextInt();
	System.out.print("請輸入第三個值:");
	c = sc.nextInt();
	
	//計算最大值
	max =(a > b) ? a : b ;
	max =(max > c) ? max : c;
	//計算最小值
	min =(a < b) ? a : b ;
	min =(min < c) ? min : c;
	//計算中間值
	mid = (a > b) ? ((a < c) ? a : ((b > c) ? b : c)) : ((b < c) ? b : ((a > c) ? a : c));

	System.out.println("最小值為:" + min + ",中間值為:" + mid + ",最大值為:" + max);
	
	}
}