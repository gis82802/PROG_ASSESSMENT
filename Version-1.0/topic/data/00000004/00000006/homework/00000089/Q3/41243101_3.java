import java.util.Scanner;
public class reverse
{
	public static void main (String args[])
	{
		int x,originalx,count=0,i;
		System.out.println("請輸入一個1~10000間的整數值:");	//123
        	Scanner scn=new Scanner(System.in);
		x=scn.nextInt();
		if(x>0&&x<10001) //確認輸入的數值無誤
		{
			originalx=x;
			int arr[]=new int [5];				//最多存5個數
			while(x>0&&count<5)
			{	
				arr[count]=x%10; 			//取出最右的數放入陣列arr中[0][1][2]
				count++;				//3
				x/=10;					//去除最右的數
			}						//arr[5]={3,2,1,0,0}
			int reversenumber=0;
			for(i=0;i<count;i++)				//i=0,1,2
			{
				reversenumber=reversenumber*10+arr[i];	//陣列中數值是前面位數的十倍加上當前位 3=0*10+3，32=3*10+2，321=32*10+1
			}
			System.out.println(originalx+"-->"+reversenumber);
		}
		else
		{
			System.out.println("請重新輸入一個1~10000間的整數值:");
		}
	}
}