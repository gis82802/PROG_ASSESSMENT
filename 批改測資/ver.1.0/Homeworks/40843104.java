
//40843104  資工二甲 吳欣樺  接收不同資料型態的資料並顯示

import java.util.Scanner;//將Scanner的函式導入
public class hw2
{
	public static void main(String args[])//程式進入點
	{
		
		Scanner scn=new Scanner(System.in);//宣告一個物件用來收取鍵盤的輸入
		byte b_in;//定義變數
		short sor_in;//定義變數
		int i_in;//定義變數
		String str_in;//定義變數
		char c_in;//定義變數
		long L_in;//定義變數
		float f_in;//定義變數
		double d_in;//定義變數
		//System.out.println("Enter the byte");//顯示要輸入的資料型態
		b_in=scn.nextByte();//接收輸入(byte)
		System.out.println(b_in);//顯示要輸出的資料
		
		//下面重複
		
		//System.out.println("Enter the short");
		sor_in=scn.nextShort();
		System.out.println(sor_in);

		//System.out.println("Enter the int");
		i_in=scn.nextInt();
		System.out.println(i_in);

		//System.out.println("Enter the char");
		str_in=scn.next();
		c_in=str_in.charAt(0);
		System.out.println(c_in);

		//System.out.println("Enter the long");
		L_in=scn.nextLong();
		System.out.println(L_in);
		
		//System.out.println("Enter the float");
		f_in=scn.nextFloat();
		System.out.println(f_in);

		//System.out.println("Enter the double");
		d_in=scn.nextDouble();
		System.out.println(d_in);
		
						
		
	}
	
}