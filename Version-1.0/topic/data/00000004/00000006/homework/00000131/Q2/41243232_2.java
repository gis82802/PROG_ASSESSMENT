/*
filename:hw1011_2b
function: Check if a number is a well-ordered number
author:41243232
date:2024/10/11
version:jdk23
*/
import java.util.Scanner;
public class hw1011_2b{

	public static void main(String[] args){
	Scanner scn = new Scanner(System.in);
	int iA=10,iB=0,iNum,iCount=0;
	System.out.print("input num (1~100000): ");
	iNum = scn.nextInt();
	for(int i=1;i<1000000;i*=10)
	{
		iB = iA;
		if(i == 100000)
		{
			iA = iNum /i; 
		}
		else
		{
			iA = (iNum %(i*10))/i; 
		}
		iCount+= 1;
		if(iB <= iA)
		{
			iCount = 0;
			break;
		}
	}
	if(iCount!=0)
	{
		System.out.println(iNum + " is a well-ordered number");
	}
	else
	{
		System.out.println( iNum + " is not a well-ordered number");
	}
}
}