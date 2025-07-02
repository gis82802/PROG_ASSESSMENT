/*
filename:hw1004_3
funtion:max mid min
author:41243232
date:2024/10/04
version:jdk23
*/
import java.util.Scanner;
public class hw1004_3{
	public static void main(String[] args){
	Scanner scn = new Scanner(System.in);
	int iA,iB,iC,iMax,iMin,iMid;
	System.out.print("input a : ");
	iA = scn.nextInt();
	System.out.print("input b : ");
	iB = scn.nextInt();
	System.out.print("input c : ");
	iC = scn.nextInt();
	iMax = (iA>iB)? iA:iB;
	iMax = (iMax>iC)? iMax:iC;
	iMid = (iA>iB)? iA:iB;
	iMid = (iMid>iC)? iC:iMid;
	iMin = (iA<iB)? iA:iB;
	iMid = (iMid>iMin)?iMid:iMin;
	iMin = (iMin<iC)? iMin:iC;
	System.out.println("max number : " + iMax);
	System.out.println("mid number : " + iMid);
	System.out.println("min number : " + iMin);

	}
}