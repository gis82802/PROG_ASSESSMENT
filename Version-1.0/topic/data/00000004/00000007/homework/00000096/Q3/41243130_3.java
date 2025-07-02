//1018上課練習_3
import java.util.Scanner;
public class a1018_3
{
	public static void main(String arg[])
	{
		Scanner scn=new Scanner(System.in);	//a部分
		System.out.print("請輸入n:");
		int input=scn.nextInt();
		char arr[][]=new char[input][input],arr1[][]=new char[input][input];
		for(int i=0;i<input;i++)		//下三角
		{
			for(int j=0;j<input;j++)
			{
				if(j<=i)
					arr[i][j]='*';
				else
					arr[i][j]=' ';
			}
		}
		for(int i=0;i<input;i++)		//下三角輸出
		{
			for(int j=0;j<input;j++)
			{
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();		//換行
		for(int i=0;i<input;i++)		//上三角
		{
			for(int j=0;j<input;j++)
			{
				if(j<i)
					arr[i][j]=' ';
				else
					arr[i][j]='*';
			}
		}
		for(int i=0;i<input;i++)		//上三角輸出
		{
			for(int j=0;j<input;j++)
			{
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.print("請輸入數字:");		//b部分
		boolean state=false;
		int num=0,in=scn.nextInt();		//輸入數字
		for(int i=1;;i++)
		{
			for(int j=1;j<=i;j++)
			{
				num++;
				if(num==in)			//num與輸入相同時輸出目前i和j
				{
					System.out.println("i="+i+",j="+j);
					state=true;
				}
				if(state)		//中斷迴圈
					break;
				
			}
			if(state)		//中斷迴圈
				break;
		}
	}
}