/*
filename:hw1025_3b
function:inverse matrix
author:41243232
date:2024/10/25
version:jdk23
*/

import java.util.Scanner;
public class hw1025_3b{
	public static void main(String[] args)
	{
		invMatrix();
	}
	public static void invMatrix()
	{
		Scanner scn = new Scanner(System.in);
		int[][] a = new int [2][2];
		double[][] b = new double [2][2];
		int[][] c = new int [2][2];
		int deta=0;
		for(int i =0;i<4;i++)
		{
			System.out.print(" input a[" + i/2 + "][" + i%2 + "] : ");
			a[(i/2)][(i%2)] = scn.nextInt();
		}
		deta = (a[0][0] * a[1][1]) - (a[0][1] * a[1][0]);
		for(int i =0;i<4;i++)
		{
			if(i ==1||i==2)
			{
				b[i/2][i%2] = -(1.0f/(deta)) * a[i/2][i%2];
			}
			else
			{
				b[i/2][i%2] = (1.0f/(deta)) * a[(i+1)%4][(i+1)%4];
			}
		}
		for(int i =0;i<4;i++)
		{
			System.out.println("output b[" + i/2 + "][" + i%2 + "] = " + b[i/2][i%2]);
		}
		for(int i=0;i<4;i++)
		{
			for(int j =0;j<2;j++)
			{
				c[i/2][i%2] += a[i/2][j]*b[j][i%2];
			}
			System.out.println("output a[" + i/2 + "][" + i%2 + "] * " + "b[" + i/2 + "][" + i%2 + "] = " + "c[" + i/2 + "][" + i%2 + "] = " + c[i/2][i%2]);
				
		}

	}
}

