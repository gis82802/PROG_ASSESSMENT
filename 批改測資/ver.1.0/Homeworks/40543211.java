/*
    filename: hw2.java
    function: 寫程式讓使用者輸入不同原始資料型態的資料(byte, short, int, char, long, float, dobule)
    author: 40543211 吳崧禾
    datetime: 10/05/2020
    version: 1.0
*/

import java.util.Scanner;
public class hw2{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        byte bn;
        short sn;
        int in;
        char cn;
        long ln;
        float fn;
        double dn;

        //System.out.print("請輸入 byte 型態的數值: ");
        bn = scn.nextByte();
        //System.out.print("請輸入 short 型態的數值: ");
        sn = scn.nextShort();
        //System.out.print("請輸入 int 型態的數值: ");
        in = scn.nextInt();
        //System.out.print("請輸入 char 型態的數值: ");
        cn = scn.next().charAt(0);
        //System.out.print("請輸入 long 型態的數值: ");
        ln = scn.nextLong();
        //System.out.print("請輸入 float 型態的數值: ");
        fn = scn.nextFloat();
        //System.out.print("請輸入 double 型態的數值: ");
        dn = scn.nextDouble();

        System.out.println(bn);
        System.out.println(sn);
        System.out.println(in);
        System.out.println(cn);
        System.out.println(ln);
        System.out.println(fn);
        System.out.println(dn);
    }
}