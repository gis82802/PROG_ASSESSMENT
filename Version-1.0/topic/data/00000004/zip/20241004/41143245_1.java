import java.io.BufferedReader;
import java.util.Scanner;

import javax.swing.border.SoftBevelBorder;

public class homework1 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        try {
            System.out.println("A1");
            
            int x1=sc.nextInt();
            int y1=sc.nextInt();
            System.out.println("A2");
            int x2=sc.nextInt();
            int y2=sc.nextInt();
            int Subtract_X =x1-x2;
            int Subtract_Y=y1-y2;
            int i;
            for ( i = Math.max(Math.abs(Subtract_Y),Math.abs(Subtract_X)); i >=1; i--) {//https://hackmd.io/@gminc/ByFdrKOn_(最大公因數)
                if (Subtract_X % i == 0 && Subtract_Y % i == 0) {
                    break;
                }
            }
            if (Subtract_X<0&&Subtract_Y<0) {
                Subtract_Y=Math.abs(Subtract_Y);
                Subtract_X=Math.abs(Subtract_X);
            }
            if (Subtract_Y!=0) { //分母不為0
                int b=y1-x1*Subtract_X/Subtract_Y; //y=x*a+b
                System.out.println(Subtract_X/i+"x+"+Subtract_Y/i+"y+"+b+"=0");
            }
            else{
                System.out.println("infinty*x+infinty=y") ;
            }
            System.out.println("geometry hypotenuse = "+Math.sqrt(Math.pow(Subtract_X, 2)+Math.pow(Subtract_Y, 2)));
            System.out.println("Manhattan length = "+(Math.abs(Subtract_X)+Math.abs(Subtract_Y)));
            float vector_one=x1/y1;
            float vector_two=x2/y2;
            double Multiply_result=Math.abs(vector_one)*Math.abs(vector_two);
           System.out.println("acute angle ="+(vector_one ));
            // TODO: handle exception
        } catch (Exception e) {
            // TODO: handle exception
        }
    }1
}