/*
filename:java0927_2
funtion:轉|桿子
author:41243232
date:2024/09/27
version:jdk23
*/
public class java0927_2{

	public static void main(String[] args) throws Exception{
		
		char cRod[] = {'|','/','-','\\'};
		
		for(int i =0;i<20;i++)
		{
			System.out.print("\r" + cRod[i%4]);
			Thread.sleep(200);
		}
		
		
	}
}