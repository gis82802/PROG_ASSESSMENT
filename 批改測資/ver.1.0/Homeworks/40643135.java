/* 
author:40643135���q��
datetime:20/10/05
funtion:�g�{�����ϥΪ̿�J���P��l��ƫ��A�����
*/
import java.util.Scanner;
public class hw2_1005 {
    public static void main(String args[]){
        Scanner scn =new Scanner(System.in);
        
        //System.out.println("��Jbyte���");
        Byte b = scn.nextByte();
        System.out.println(b);

        //System.out.println("��Jshort���");
        short sh = scn.nextShort();
        System.out.println(sh);

        //System.out.println("��Jint���");
        int i = scn.nextInt();
        System.out.println(i);

        //System.out.println("��Jchar���");
        char c = scn.next().charAt(0);
        System.out.println(c);

        //System.out.println("��Jlong���");
        long l = scn.nextLong();
        System.out.println(l);

        //System.out.println("��Jfloat���");
        float f = scn.nextFloat();
        System.out.println(f);
        
        //System.out.println("��Jdobule���");
        double d = scn.nextDouble();
        System.out.println(d);
    }
}
