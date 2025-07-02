import java.util.Scanner;
public class decide
{
	public static void main (String args[])
	{
		int x,count=0,a=0,b=0,c=0,d=0,e=0;
		System.out.println("請輸入一個1~10000間的整數值:");
        	Scanner scn=new Scanner(System.in);
		x=scn.nextInt();
		if(x>0&&x<10001) //確認輸入的數值無誤
		{
			while(x>0)
			{	
				count++;
				switch(count)		 //上到下分別是右到左
				{
					case 1:
						a=x%10;	 //最右的數
						break;
					case 2:
						b=x%10;	 
						break;
					case 3:
						c=x%10;	 
						break;
					case 4:
						d=x%10;	 
						break;
					case 5:
						e=x%10;	 //最左的數
						break;	 
				}
				x/=10;
			}
			if((count==1)||(count==2&&a>b)||(count==3&&a>b&&b>c)||(count==4&&a>b&&b>c&&c>d)||(count==5&&a>b&&b>c&&c>d&&d>e))
			{
				System.out.println("THis is a well-ordered number");
			}
			else
			{
				System.out.println("THis is  not a well-ordered number");

			}
		}
		else
		{
			System.out.println("請重新輸入一個1~10000間的整數值:");
		}
	}
}