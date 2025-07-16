/*
輸入系統
何國豪 40843117
2020/10/05
*/
import java.util.*;
public class test2
{
    public static void main(String args[])
    {
	Scanner in = new Scanner(System.in);
	byte b_by;
	short s_sh;
	int i_in;
	char c_ch;
	long l_lo;
	float f_fl;
	double d_do;

	//System.out.println("byte輸入:");
	b_by=in.nextByte();
	//System.out.println("short輸入:");
	s_sh=in.nextShort();
	//System.out.println("int輸入:");
	i_in=in.nextInt();
	//System.out.println("char輸入:");
	c_ch=in.next().charAt(0);
	//System.out.println("long輸入:");
	l_lo=in.nextLong();
	//System.out.println("double輸入:");
	d_do=in.nextDouble();
	
	System.out.println(b_by);
	System.out.println(s_sh);
	System.out.println(i_in);
	System.out.println(c_ch);
	System.out.println(l_lo);
	System.out.println(d_do);
    }
}