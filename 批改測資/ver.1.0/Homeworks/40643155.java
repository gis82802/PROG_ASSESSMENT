/*
--防侵權宣告--
===========================================*/
//File name:q2_1005
//function:讓使用者分別輸入型別為byte/short/int/char/long/float/double的資料
//authors:施文茗 40643155
//created date:10/05,2020
//version:1st
import java.util.Scanner;
public class q2{
	public static void main(String args[]){
		Scanner scn = new Scanner(System.in);
		byte b1;
		short s2;
		int i3;
		char c4;
		long L5;
		float f6;
		double d7;
		//System.out.println("分別輸入型別為byte/short/int/char/long/float/double的資料!");
		b1 = scn.nextByte();
		s2 = scn.nextShort();
		i3 = scn.nextInt();
		//c4 = scn.nextChar();
		L5 = scn.nextLong();
		f6 = scn.nextFloat();
        d7 = scn.nextDouble();
	}
}