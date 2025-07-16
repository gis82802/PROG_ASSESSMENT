import java.util.Scanner;
public class type
{
	public static void main(String args[])
	{
		Scanner scn = new Scanner(System.in);
		byte intByte;
		short intShort;
		int intInt;
		String str; 
		char charChar;
		long intLong;
		float fFloat;
		double fDouble;
		
		//System.out.println("請輸入-128~127之間的整數\n");
		intByte = scn.nextByte();
		System.out.println(intByte);

		//System.out.println("請輸入-132768~32767之間的整數\n");
		intShort = scn.nextShort();
		System.out.println(intShort);

		//System.out.println("請輸入-2147483648~2147483647之間的整數\n");
		intInt = scn.nextInt();
		System.out.println(intInt);

		//System.out.println("請輸入一個字\n");
		str = scn.next();
		charChar = str.charAt(0);
		System.out.println(charChar);

		//System.out.println("請輸入-9223372036854775808~9223372036854775807之間的整數\n");
		intLong = scn.nextLong();
		System.out.println(intLong);

		//System.out.println("請輸入-3.4E38~3.4E38之間的小數\n");
		fFloat = scn.nextFloat();
		System.out.println(fFloat);

		//System.out.println("請輸入-1.7E308~1.7E308之間的小數\n");
		fDouble = scn.nextDouble();
		System.out.println(fDouble);
	}
}