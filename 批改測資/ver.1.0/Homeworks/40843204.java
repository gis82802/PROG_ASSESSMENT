/*
40843204 不同型態輸入
*/
import java.util.Scanner; 
public class app10_5{
	public static void main(String args[]){
		Scanner san=new Scanner(System.in);
		byte b;
		short s;
		int i;
		char c;
		long l;
		float f;
		double d;
		//System.out.print("輸入Byte= ");
		b=san.nextByte();
		//System.out.print("輸入Short= ");
		s=san.nextShort();
		//System.out.print("輸入int= ");
		i=san.nextInt();
		//System.out.print("輸入char= ");
		c=san.next().charAt(0);
		//System.out.print("輸入long= ");
		l=san.nextLong();
		//System.out.print("輸入float= ");
		f=san.nextFloat();
		//System.out.print("輸入double= ");
		d=san.nextDouble();
		System.out.println(b);
		System.out.println(s);
		System.out.println(i);
		System.out.println(c);
		System.out.println(l);
		System.out.println(f);
		System.out.println(d);
        //System.out.println("輸出 Byte :"+b+"  輸出 short :"+s+"  輸出 int :"+i+"\n"+"輸出 char :"+c+"  輸出 long :"+l+"  輸出 float :"+f+"  輸出 double :"+d);
	}
} 