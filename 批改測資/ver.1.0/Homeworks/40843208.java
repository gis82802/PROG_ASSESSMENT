//file name app_2
//input every type of data 
//student number 40843208
//complete date 2020/10/05 
//version 1
import java.util.Scanner;
public class app_2
{
	public static void main(String args[])
	{
		
		Scanner scn = new Scanner(System.in);
		//System.out.println("請輸入一個byte的資料");
		byte b;
		b = scn.nextByte();
		//System.out.println("請輸入一個short的資料");
		short sh;
		sh = scn.nextShort();
		//System.out.println("請輸入一個int的資料");
		int i;
		i = scn.nextInt();
		//System.out.println("請輸入一個char的資料");
		char ch;
		ch = scn.next().charAt(0);
		//System.out.println("請輸入一個long的資料");
		long l;
		l = scn.nextLong();
		//System.out.println("請輸入一個float的資料");
		float f;
		f = scn.nextFloat();
		//System.out.println("請輸入一個double的資料");
		double d;
		d = scn.nextDouble();
	}
}