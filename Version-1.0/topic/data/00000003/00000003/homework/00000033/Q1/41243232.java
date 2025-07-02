/*
filename:hw1025_3a
function:matrix * matrix
author:41243232
date:2024/10/25
version:jdk23
*/

import java.util.Scanner;
public class hw1025_3a{
	public static void main(String[] args)
	{
		 MathMultiply();
	}
	public static void MathMultiply()
	{
		Scanner scn = new Scanner(System.in);
		int x=0,y=0,e=0;
		System.out.println("input a size(a[x][y])");
		System.out.print("input x : ");
		x = scn.nextInt();
		System.out.print("input y : ");
		y = scn.nextInt();
		int[][] a = new int [x][y];
		for(int i=0;i<x*y;i++)
		{
			System.out.print(" input a[" + i/y + "][" + i%y + "] : ");
			a[i/y][i%y] = scn.nextInt();
		}
		System.out.println("input b size(b[x][y])");
		e=x;
		System.out.print("input x : ");
		x = scn.nextInt();
		if(x!=y)
		{
			e=0;
		}
		System.out.print("input y : ");
		y = scn.nextInt();
		int[][] b = new int [x][y];
		for(int i=0;i<x*y;i++)
		{
			System.out.print(" input b[" + i/y + "][" + i%y + "] : ");
			b[i/y][i%y] = scn.nextInt();
		}
		int[][] c = new int [e][y];
		if(e!=0)
		{
			for(int i=0;i<e*y;i++)
			{
				for(int j =0;j<x;j++)
				{
					c[i/y][i%y] += a[i/e][j]*b[j][i%y];
				}				
			}
		}
		else
		{
			System.out.println("null");
		}
		for(int i=0;i<e*y;i++)
		{
			System.out.println("output c[" + i/y + "][" + i%y + "] : " + c[i/y][i%y]);			
		}
	}
}