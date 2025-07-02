import java.util.Scanner;

public class Test2

{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);

		//=========輸入
		
		System.out.print("請輸入三角形的高: ");
		int H = s.nextInt();

		//=========處理&輸出
		
		for(int i=0;i<H;i++)  //巢狀迴圈
		{
			for(int j=0;j<=i;j++){
				System.out.print("*");
			}
			System.out.print("\n");
		}
		
		//=========輸入
		
		System.out.print("請輸入要在三角形中尋找的編號x: ");
		int x = s.nextInt();

		//=========處理&輸出
		
		/*
		因   第n列的最後一個數字為 n*(n+1)/2
		所以 只需要找到以上算式大於x時的n值 就是x的列數
		再   第n列的第一個數為 n*(n-1)/2+1
		所以 只需計算 x-n*(n-1)/2 就可得出x的行數
		*/
		
		int n=1;
		while(n*(n+1)/2 < x) {
			n++;
		}
		System.out.printf("x位於第 %d列 第%d行",n,x-n*(n-1)/2);
		
		s.close();
	}
}