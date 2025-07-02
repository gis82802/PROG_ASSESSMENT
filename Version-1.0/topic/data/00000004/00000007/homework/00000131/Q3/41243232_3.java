/*
filename:java1018_3
function:
author:41243232
date:2024/10/18
version:jdk23
*/

import java.util.Scanner;
public class java1018_3{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int iNum=0;
		System.out.print("input length : ");
		iNum = scn.nextInt();
		int iA[] = new int[iNum];
		int iB[] = new int[iNum];
		System.out.print("input : ");
		//input
		for(int i=0;i<iA.length;i++)
		{
			iA[i] = scn.nextInt();
		}
		//min
		for(int i=0;i<iA.length-1;i++)
		{
			iNum = iA[i+1];
			for(int j=1+i;j<iA.length;j++)
			{
				if(iNum<iA[j])
				{
					iNum = iA[j];
				}
			}
		iB[i] = iNum;
		}
		iB[((iB.length)-1)] = -1;
		//output min
		System.out.println(" ");
		System.out.print("min : ");
		for(int i=0;i<iB.length;i++)
		{	
			if(i==iB.length-1)
			{
				System.out.print(iB[i]);
			}
			else
				System.out.print(iB[i] + " , ");
		}


		//max
		for(int i=0;i<iA.length-1;i++)
		{
			iNum = iA[i+1];
			for(int j=1+i;j<iA.length;j++)
			{
				if(iNum>iA[j])
				{
					iNum = iA[j];
				}
			}
		iB[i] = iNum;
		}
		//output max
		System.out.println(" ");
		System.out.print("max : ");
		for(int i=0;i<iB.length;i++)
		{	
			if(i==iB.length-1)
			{
				System.out.print(iB[i]);
			}
			else
				System.out.print(iB[i] + " , ");
		}


}
}