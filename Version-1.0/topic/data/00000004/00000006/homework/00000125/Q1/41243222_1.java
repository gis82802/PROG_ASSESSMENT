/*
filename:app 5_1
funtion:9 mult 9
auther:ToBoShu
date:2024/10/11
version:jdk23
*/
/*
System.out.println();
System.out.printf();
import java.util.Scanner;
Scanner sc = new Scanner(system.in);
int x = sc.nextInt;
throws Exxception
Thread.sleep(x);
Math.pow(x,2.0);
Math.squt(x);
*/

import java.util.Scanner;

public class app5_1
{
	public static void main(String args[]) 
	{
	int value;
	 for(int i = 1;i <= 9; i++)
	 {
		for(int j = 1;j <= 9;j++)
		{
		value = j*i;
	 	System.out.printf("%dx%d = %2d   ", j, i, value);
		}
	 System.out.println("");
	 }
	}
}