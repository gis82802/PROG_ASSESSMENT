/*
	hw2.java
	上課練習
	讓使用者輸入不同原始資料型態的資料 
	資工二甲 40843142 許建程
	2020/10/5
*/




import java.util.Scanner;
public class hw2
{
	public static void main(String args[]){
		Scanner scn=new Scanner(System.in);

		byte byt;
		short sho;
		int in;
		String str;
		char ch;
		long lon;
		float flo;
		double dou;
		
		//System.out.print("請輸入型態為Byte的資料 ");
		byt=scn.nextByte();

		//System.out.print("請輸入型態為Short的資料 ");
		sho=scn.nextShort();

		//System.out.print("請輸入型態為Int的資料 ");
		in=scn.nextInt();

		//System.out.print("請輸入型態為Char的資料 ");
		str=scn.next();
		ch=str.charAt(0);

		//System.out.print("請輸入型態為Long的資料 ");
		lon=scn.nextLong();

		//System.out.print("請輸入型態為Float的資料 ");
		flo=scn.nextFloat();

		//System.out.print("請輸入型態為Double的資料 ");
		dou=scn.nextDouble();
		
		System.out.print(byt+"\n");
		System.out.print(sho+"\n");
		System.out.print(in+"\n");
		System.out.print(ch+"\n");
		System.out.print(lon+"\n");
		System.out.print(flo+"\n");
		System.out.print(dou+"\n");
	}
}
