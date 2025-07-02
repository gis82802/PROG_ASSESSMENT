/*
filename:java1018
function:
author:41243232
date:2024/10/18
version:jdk23
*/

import java.util.Scanner;
public class java1018{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int iNum=0;
		System.out.print("input length : ");
		iNum = scn.nextInt();
		int iA[] = new int[iNum];
		System.out.print("input : ");
		//input
		for(int i=0;i<iA.length;i++)
		{
			iA[i] = scn.nextInt();
		}
		//output before
		System.out.print("before : ");
		for(int i=0;i<iA.length;i++)
		{	
			if(i==iA.length-1)
			{
				System.out.print(iA[i]);
			}
			else
				System.out.print(iA[i] + " , ");
		}
		//min
		for(int i=0;i<iA.length;i++)
		{
			for(int j=0;j<(iA.length-i);j++)
			{
				iNum = iA[j];
				if((j+1)<iA.length)
				{
					if(iNum>iA[j+1])
					{	
						iNum = iA[j];
						iA[j] = iA[j+1];
						iA[j+1] = iNum;
					}
				}
			}
		}
		//output min
		System.out.println(" ");
		System.out.print("min    : ");
		for(int i=0;i<iA.length;i++)
		{	
			if(i==iA.length-1)
			{
				System.out.print(iA[i]);
			}
			else
				System.out.print(iA[i] + " , ");
		}
		//max
		for(int i=0;i<iA.length;i++)
		{
			for(int j=0;j<(iA.length-i);j++)
			{
				iNum = iA[j];
				if((j+1)<iA.length)
				{
					if(iNum<iA[j+1])
					{	
						iNum = iA[j];
						iA[j] = iA[j+1];
						iA[j+1] = iNum;
					}
				}
			}
		}
		//output max
		System.out.println(" ");
		System.out.print("max    : ");
		for(int i=0;i<iA.length;i++)
		{	
			if(i==iA.length-1)
			{
				System.out.print(iA[i]);
			}
			else
				System.out.print(iA[i] + " , ");
		}


}
}