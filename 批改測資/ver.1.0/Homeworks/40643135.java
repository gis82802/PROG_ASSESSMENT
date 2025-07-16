/* 
author:40643135郭益成
datetime:20/10/05
funtion:寫程式讓使用者輸入不同原始資料型態的資料
*/
import java.util.Scanner;
public class hw2_1005 {
    public static void main(String args[]){
        Scanner scn =new Scanner(System.in);
        
        //System.out.println("輸入byte資料");
        Byte b = scn.nextByte();
        System.out.println(b);

        //System.out.println("輸入short資料");
        short sh = scn.nextShort();
        System.out.println(sh);

        //System.out.println("輸入int資料");
        int i = scn.nextInt();
        System.out.println(i);

        //System.out.println("輸入char資料");
        char c = scn.next().charAt(0);
        System.out.println(c);

        //System.out.println("輸入long資料");
        long l = scn.nextLong();
        System.out.println(l);

        //System.out.println("輸入float資料");
        float f = scn.nextFloat();
        System.out.println(f);
        
        //System.out.println("輸入dobule資料");
        double d = scn.nextDouble();
        System.out.println(d);
    }
}
