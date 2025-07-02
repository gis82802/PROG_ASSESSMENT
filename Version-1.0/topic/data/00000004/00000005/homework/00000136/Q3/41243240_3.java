/*
filename:app4_6
function:輸入a,b,c判斷MAX,MIN,MID
author:傅學呈
data:2024/10/04
version:11.0.12
*/
import java.util.Scanner;
public class app4_6
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("輸入a:");
		int a= scanner.nextInt();
		System.out.print("輸入b:");
		int b= scanner.nextInt();
		System.out.print("輸入c:");
		int c= scanner.nextInt();
		int max,mid,min;
		
		//判斷最大值
		max=(a>b)?((a>c)?a:c):((b>c)?b:c);
		//判斷最小值
		min=(a<b)?((a<c)?a:c):((b<c)?b:c);
		//判斷中間值
		mid=(a<max&&a>min)?a:((b>max&&b<min)?b:c);
		System.out.println("MAX="+max);
		System.out.println("MID="+mid);
		System.out.println("MIN="+min);
	}
}