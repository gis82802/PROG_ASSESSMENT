/*
filename:hw1004
funtion:distance
author:41243232
date:2024/10/04
version:jdk23
*/

import java.util.Scanner;

public class hw1004{

	public static void main(String[] args){

	Scanner scn = new Scanner(System.in);

	int iX1,iY1,iX2,iY2,iA,iB,iEuclidean,iManhattan;
	int iMx,iMy,iAb,iP;
	double dAxy, dBxy, dTheta,dMinkowski;

	System.out.print("input x1 : ");
	iX1 = scn.nextInt();
	System.out.print("input y1 : ");
	iY1 = scn.nextInt();
	System.out.print("input x2 : ");
	iX2 = scn.nextInt();
	System.out.print("input y2 : ");
	iY2 = scn.nextInt();


	iA = 0;
	if(iX1 != iX2)
	{
	iA=(iX1-iY2)/(iY1-iY2); //https://reurl.cc/dyAWo8
	}
	iB=iY1-(iA*iX1);
	if(iB>0)
	{
		System.out.println("y=" + iA +"x + " + iB);
	}
	else if(iB==0)
	{
		System.out.println("y=" + iA +"x");
	}
	else
	{
		System.out.println("y=" + iA +"x" + iB);
	}
	iEuclidean = ((iX1-iX2)*(iX1-iX2))+((iY1-iY2)*(iY1-iY2));//https://zh.wikipedia.org/zh-tw/%E6%AC%A7%E5%87%A0%E9%87%8C%E5%BE%97%E8%B7%9D%E7%A6%BB
	System.out.println("Euclidean distance : " + Math.sqrt(iEuclidean));



	iMx = iX1 - iX2;//https://zh.wikipedia.org/zh-tw/%E6%9B%BC%E5%93%88%E9%A0%93%E8%B7%9D%E9%9B%A2
	if(iMx < 0)
        {
		iMx = 0 - iMx;
	}
	iMy = iY1 - iY2;
	if(iMy < 0)
        {
		iMy = 0 - iMy;
	}
	iManhattan = iMx + iMy;
	System.out.println("Manhattan distance : " + iManhattan);


	System.out.print("input p : ");
	iP = scn.nextInt();
	dMinkowski = Math.pow((Math.pow(Math.abs(iX1-iX2),iP) + Math.pow(Math.abs(iY1 - iY2),iP)),(1.0/iP));
	System.out.println("Minkowski distance : " + dMinkowski);//https://zh.wikipedia.org/zh-tw/%E6%98%8E%E6%B0%8F%E8%B7%9D%E7%A6%BB

	dAxy = Math.sqrt((iX1*iX1)+(iY1*iY1));	//https://zh.wikipedia.org/zh-tw/%E5%90%91%E9%87%8F
	dBxy = Math.sqrt((iX2*iX2)+(iY2*iY2));
	iAb = (iX1*iX2)+(iY1*iY2);
	dTheta = Math.acos(iAb/(dAxy*dBxy));
	System.out.println("θ : " + Math.toDegrees(dTheta) + "°");
	}
}