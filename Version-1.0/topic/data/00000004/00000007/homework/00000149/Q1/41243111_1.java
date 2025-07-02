import java.util.Scanner;

public class Test1
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
		
		System.out.print("排序前:");
		for(int i=0 ;i<L ;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.print("\n");
		
		for(int i=1 ;i<L ;i++)  //插入排序
		{
			int temp = arr[i];
			int j = i-1;
			
			while(j>=0 && arr[j]>temp)
			{
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=temp;
			
		}
		
		System.out.print("排序後:");
		for(int i=0 ;i<L ;i++) {
			System.out.print(arr[i]+" ");
		}
		
		s.close();
	}
}