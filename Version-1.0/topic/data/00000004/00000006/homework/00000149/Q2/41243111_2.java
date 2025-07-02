import java.util.Scanner;

public class Test2
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		//=========輸入
		
		System.out.printf("請輸入要計算的數值x= ");
		int x = s.nextInt();
		
		//=========判斷&輸出
		
		System.out.print(x);
		
		int temp;
		while(true)  //使用%10取個位數的方式來判斷
		{
			temp=x%10;
			x/=10;
			
			if(temp<=x%10){
				System.out.printf(" is not a well-ordered number");
				break;
			}else if(x==0){
				System.out.printf(" is a well-ordered number");
				break;
			}
		}
		
		s.close();
	}
}