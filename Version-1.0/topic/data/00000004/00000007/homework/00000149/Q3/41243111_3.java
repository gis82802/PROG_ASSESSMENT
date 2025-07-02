import java.util.Scanner;

public class Test3

{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);

		//=========輸入
		
		System.out.print("請輸入陣列長度: ");
		int L = s.nextInt();
		int[] arr = new int[L];  //宣告一維陣列
		System.out.print("請隨機輸入"+L+"個數值: ");
		for(int i=0 ;i<L ;i++) {
			arr[i] = s.nextInt();
		}

		//=========處理&輸出
		
		System.out.print("後項最大:");
		for(int i=0 ;i<L-1 ;i++)
		{
			int temp = arr[i+1];
			for(int j=i+1 ;j<L ;j++)  //找i項以後的最大值
			{
				if(arr[j]>temp) {
					temp = arr[j];
				}
			}
			System.out.print(temp+",");  //不更動陣列 找到答案直接輸出
		}
		System.out.println("-1");
		
		System.out.print("後項最小:");
		for(int i=0 ;i<L-1 ;i++)
		{
			int temp = arr[i+1];
			for(int j=i+1 ;j<L ;j++)
			{
				if(arr[j]<temp) {
					temp = arr[j];
				}
			}
			System.out.print(temp+",");
		}
		System.out.println("-1");
		
		s.close();
	}
}