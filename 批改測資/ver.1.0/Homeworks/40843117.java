/*
��J�t��
��껨 40843117
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

	//System.out.println("byte��J:");
	b_by=in.nextByte();
	//System.out.println("short��J:");
	s_sh=in.nextShort();
	//System.out.println("int��J:");
	i_in=in.nextInt();
	//System.out.println("char��J:");
	c_ch=in.next().charAt(0);
	//System.out.println("long��J:");
	l_lo=in.nextLong();
	//System.out.println("double��J:");
	d_do=in.nextDouble();
	
	System.out.println(b_by);
	System.out.println(s_sh);
	System.out.println(i_in);
	System.out.println(c_ch);
	System.out.println(l_lo);
	System.out.println(d_do);
    }
}