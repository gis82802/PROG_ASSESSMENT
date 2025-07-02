/*
filename:app3_1
function:讓一根棒子從左到右轉動
author:傅學呈
data:2024/09/27
version:11.0.12
*/
public class app3_2
{
	public static void main(String args[]) throws Exception
	{
		while(true){
			System.out.print("\r\\");
			Thread.sleep(100);
			System.out.print("\r|");
			Thread.sleep(100);
			System.out.print("\r/");
			Thread.sleep(100);
			System.out.print("\r-");
			Thread.sleep(100);
		}
	}
}