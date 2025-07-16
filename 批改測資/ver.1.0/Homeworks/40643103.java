/*
filename:practice3_2
funtion:寫程式讓使用者輸入不同原始資料型態的資料(byte, short, int, char, long, float, dobule)
author:永林玄
datetime:20/10/05
coding:Big5
*/

import java.util.Scanner;

public class practice3_2
{
	public static void main(String args[])
	{
        Scanner scn = new Scanner(System.in);
		
        //System.out.print("Please input byte: ");
		byte B = scn.nextByte();
		
        //System.out.print("Please input short: ");
        short S = scn.nextShort();
		
        //System.out.print("Please input int: ");
        int I = scn.nextInt();
		
        //System.out.print("Please input char: ");
        char C = scn.next().charAt(0);
		
        //System.out.print("Please input long: ");
        long L = scn.nextLong();
		
        //System.out.print("Please input float: ");
        float F = scn.nextFloat();
		
        //System.out.print("Please input double: ");
        double D = scn.nextDouble();
		
        System.out.println(B);
        System.out.println(S);
        System.out.println(I);
        System.out.println(C);
        System.out.println(L);
        System.out.println(F);
        System.out.println(D);
	}
}