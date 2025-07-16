/*
user_input
功能：讓使用者輸入不同原始資料型態的資料
姓名：蕭蓉
學號：40843103
2020/10/5
*/
import java.util.Scanner;
public class user_input
{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);

        byte b;
        //System.out.println("請輸入byte型別");
        b = scn.nextByte(); 
        System.out.println(b);

        short s;
        //System.out.println("請輸入short型別");
        s = scn.nextShort(); 
        System.out.println(s);


        int i;
        //System.out.println("請輸入int型別");
        i = scn.nextInt(); 
        System.out.println(i);

        String str;
        char ch;
        //System.out.println("請輸入char型別");
        str = scn.next();
        ch = str.charAt(0); 
        System.out.println(str);
    
        long l;
        //System.out.println("請輸入long型別");
        l = scn.nextLong(); 
        System.out.println(l);

        float f;
        //System.out.println("請輸入float型別");
        f = scn.nextFloat(); 
        System.out.println(f);

        double d;
        //System.out.println("請輸入double型別");
        d = scn.nextDouble(); 
        System.out.println(d);
    }
}
