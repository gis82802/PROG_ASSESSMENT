/*
	作業三：反著輸出
	資工二乙	41243202	林沛慧
	功能：請使用者輸入一個數字，程式結束後會輸出會是他的反過來
*/
import java.util.Scanner;
public class w3
{
	public static void main(String[] args)
	{
		int[] a=new int[10];	//宣告一個陣列儲存輸入的數字
		int t=0;
		Scanner sc = new Scanner(System.in);
		//輸入
		System.out.print("請輸入一個數字，我將把它反過來：");
		int x = sc.nextInt();
		String number = Integer.toString(x); //將輸入轉成字串，方便後面使用
		for(int i=0;i<number.length();i++)
		{
			a[i] = number.charAt(i); //將值輸進陣列
		}
		System.out.print("反過來是：");
		for(int j=number.length()-1;j>=0;j--)
		{
			System.out.print((char)a[j]);
		}
	}
}
