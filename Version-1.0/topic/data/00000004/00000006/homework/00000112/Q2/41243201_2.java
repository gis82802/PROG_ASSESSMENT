import java.util.Scanner;

public class text2
{
	public static void main(String[] args)
	{
		Scanner scn=new Scanner(System.in);
		
		System.out.printf("輸入一個數字:");
		int uNum=scn.nextInt();
		
		int x=uNum;//將x儲存為uNum變數內容，用於交換
		int changNum=10;//儲存前一數字變量，一位數最大為9，所以初始設10
		int check=1;
		
		while(x>0)
		{
			int nowNum=x%10;
			if(nowNum>=changNum)
			{
				check=-1;
				break;
			}
			changNum=nowNum;
			x=x/10;
		}
		if(check==1)
		{
			System.out.println(uNum+"是well-ordered number");
		}
		else
		{
			System.out.println(uNum+"不是well-ordered number");
		}
		
		

		int count=0;
		for(int i=0;i<=100000;i++)
		{
			int y=i;//將x儲存為uNum變數內容，用於交換
			int changNum1=10;//儲存前一數字變量，一位數最大為9，所以初始設10
			int check1=1;
			
			while(y>0)
			{
				int nowNum1=y%10;
				if(nowNum1>=changNum1)
				{
					check1=-1;
					break;
				}
				changNum1=nowNum1;
				y=y/10;
			}
			if(check1==1)
			{
				count++;
			}
		}
		System.out.println("1~100000有 "+count+" 個well-ordered number");
		scn.close();
	}	
}
