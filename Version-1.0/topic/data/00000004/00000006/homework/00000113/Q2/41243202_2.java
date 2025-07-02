/*
	作業二：well ordered number
	資工二乙	41243202	林沛慧
	功能1：使用者輸入一個數字，若是前面數字皆小於後面的數字代表
	是well ordered number，反之則不是
	功能2：計算由1到10000的數字中有幾個well ordered number
*/
import java.util.Scanner;
public class w2
{
	public static void main(String[] args)
	{
		int[] a=new int[10];	//宣告一個陣列儲存輸入的數字
		int t=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("請輸入一個數字，我將判斷它是否為well ordered number：");
		int x = sc.nextInt();
		String number = Integer.toString(x); //將輸入轉成字串
		for(int i=0;i<10;i++)
		{
			a[i]=10;	//先給陣列初始值
		}
		for(int i=0;i<number.length();i++)
		{
			a[i] = number.charAt(i); //將字串一個一個輸進陣列
		}
		for(int i=0;i<number.length()-1;i++)
		{
			if(a[i]>a[i+1])
			{
				t=1;	//判斷是否前者數字皆小於後者
			}
		}
		if(t==1)	//若有數字不小於後者
		{
			System.out.println("It is not a well ordered number.");
		}
		else
		{
			System.out.println("It is a well ordered number.");
		}
		//1~十萬
		int c=0; //用來計數出現次數
		for(int i=1;i<=100000;i++)
		{
			String gj = Integer.toString(i); //將整數轉為字串
			int t1=0;
			for(int j=0;j<gj.length()-1;j++) //判斷前者是否小於後者
			{
				if(gj.charAt(j)>gj.charAt(j+1))
				{
					t1=1;		//如果大於後者，t1=1
					break;		//錯誤就直接跳出，不用繼續判斷
				}
			}
			if(t1==0)
			{
				c++;	//若都小於即正確，計數加一
			}
		}
		//輸出
		System.out.print("由1到100000，總共有"+c+"個well ordered number");
		

	}
}