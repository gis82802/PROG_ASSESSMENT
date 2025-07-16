/*
FileName:app2
Function:寫程式讓使用者輸入不同原始資料型態的資料(byte, short, int, char, long, float, dobule)
Date:202010/15
Version:1.0
Author: 40843116 張庭嘉
*/
import java.util.Scanner;
public class app2
{
    public static void main(String args[])
        {
	    Scanner scn=new Scanner(System.in);
	    int b,s,i,c,l,f,d;
	    //System.out.println("byte?");
	    b=scn.nextInt();
	    System.out.println((byte)b);
	    //System.out.println("short?");
	    s=scn.nextInt();
	    System.out.println((short)s);
	    //System.out.println("int?");
	    i=scn.nextInt();
	    System.out.println((int)i);
	    //System.out.println("char?");
	    c=scn.nextInt();
	    System.out.println((char)(c+48));
	    //System.out.println("long?");
	    l=scn.nextInt();
	    System.out.println((long)l);
	    //System.out.println("float?");
	    f=scn.nextInt();
	    System.out.println((float)f);
	    //System.out.println("double?");
	    d=scn.nextInt();
	    System.out.println((double)d);
	    
        }
}
