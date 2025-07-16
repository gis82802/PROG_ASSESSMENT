/*
   HW2
   寫程式讓使用者輸入不同原始資料型態的資料(byte, short, int, char, long, float, dobule)
   40843110 鍾易唐
*/
import java.lang.Integer;
import java.util.*;
public class HW2
{
	public static void main(String args[])
	{
		Scanner scn=new Scanner(System.in);
		byte Byte0;
		short Short0;
		int Int0;
		char Char0;
		long Long0;
		float Float0;
		double Double0;

				
		//System.out.print("輸入byte型別資料=");
		Byte0=scn.nextByte();
		System.out.println(Byte0);

		//System.out.print("輸入short型別資料=");
		Short0=scn.nextShort();
		System.out.println(Short0);

		//System.out.print("輸入int型別資料=");
		Int0=scn.nextInt();
		System.out.println(Int0);

		//System.out.print("輸入char型別資料=");
		Char0=scn.next().charAt(0);
		System.out.println(Char0);

		//System.out.print("輸入long型別資料=");
		Long0=scn.nextLong();
		System.out.println(Long0);

		//System.out.print("輸入float型別資料=");
		Float0=scn.nextFloat();
		System.out.println(Float0);

		//System.out.print("輸入double型別資料=");
		Double0=scn.nextDouble();
		System.out.println(Double0);

	}
}