/*
filename:app3_2
author:40843120 wu,guan-ting
feature:input all type and output they
data2020/10/05
*/ 
import java.util.Scanner;
public class app3_2
{
    public static void main(String args[]){
        Scanner scn=new Scanner(System.in);
        byte b;
        short s;
        int i;
        char c;
        long l;
        float f;
        double d;

        //System.out.println("input your byte:");
        b=scn.nextByte();
        //System.out.println("input your short:");
        s=scn.nextShort();
        //System.out.println("input your int:");
        i=scn.nextInt();
        //System.out.println("input your char:");
        String str;
        str=scn.next();
        c=str.charAt(0);
        //System.out.println("input your long:");
        l=scn.nextLong();
        //System.out.println("input your float:");
        f=scn.nextFloat();
        //System.out.println("input your double:");
        d=scn.nextDouble();

        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(c);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
    }
}