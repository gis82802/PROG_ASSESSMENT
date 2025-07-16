/*
班級:資工二乙
姓名:張哲瑜
學號:40843218
日期:10/5
檔案名稱:app2
功能:寫程式讓使用者輸入不同原始資料型態的資料(byte, short, int, char, long, float, dobule)
*/


import java.util.Scanner;

public class app2
{
	public static void main(String args[])
	{
		byte byte1;
		short short1;
		int int1;
		char char1;
		long long1;
		float float1;
		double double1; 
		Scanner scn =new Scanner(System.in);
	
		//System.out.println("請輸入byte");
		byte1 = scn.nextByte();
		
		//System.out.println("請輸入short");
		short1 = scn.nextShort();

		//System.out.println("請輸入int");
		int1 = scn.nextInt();

		//System.out.println("請輸入char");
		char1 = scn.next().charAt(0);

		//System.out.println("請輸入long");
		long1 = scn.nextLong();

		//System.out.println("請輸入float");
		float1 = scn.nextFloat();

		//System.out.println("請輸入double");
		double1 = scn.nextDouble();

		System.out.println(byte1);
		System.out.println(short1);
		System.out.println(int1);
		System.out.println(char1);
		System.out.println(long1);
		System.out.println(float1);
		System.out.println(double1);
        //System.out.println(byte1 + " " +  short1 + " " + int1 + " " + char1 + " "+ long1 + " " + float1 + " " + double1 );

	}

}