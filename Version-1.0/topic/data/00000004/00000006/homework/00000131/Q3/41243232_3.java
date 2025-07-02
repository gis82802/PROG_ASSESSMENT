/*
filename:hw1011_3
funtion:reverse
author:41243232
date:2024/10/11
version:jdk23
*/
import java.util.Scanner;
public class hw1011_3{

	public static void main(String[] args){
	Scanner scn = new Scanner(System.in);
	int iA=0,iB=0,iC=0,iD =0,iNum;
	System.out.print("input num (1~9999): ");
	iNum = scn.nextInt();
	iD = iNum %10;	
	iC = (iNum %100)/10;
	iB = (iNum %1000)/100;
	iA = iNum/1000;
	iNum = (iD*1000) + (iC*100) + (iB*10) + iA;
	System.out.println("Ans : " + iNum);
}
}