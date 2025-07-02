/*
    Filename: "App03_1004"
    Function: Print max, mid, min
    Author: SHUN-YE XU
    Version: 17.0.11
    date: 2024/10/4
*/

import java.util.Scanner;

public class App03_1004
{
    
    public static void main(String[] args)
    {
	int a, b, c, max, mid, min;
	Scanner s = new Scanner(System.in);
	System.out.print("輸入三個整數: ");
	a = s.nextInt(); b = s.nextInt(); c = s.nextInt();
	
	max = a > b ? (a > c ? a : c) : (b > c ? b : c); 
	mid = a > b ? (b > c ? b : a > c ? c : a) : (a > c ? a : b > c ? c : b);
	min = a < b ? (a < c ? a : c) : (b < c ? b : c);
	
	System.out.println("max = " + max);
	System.out.println("mid = " + mid);
	System.out.println("min = " + min);
    }
}