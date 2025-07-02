import java.io.BufferedReader;
import java.util.Scanner;
import mypackage.Point;
import javax.swing.border.SoftBevelBorder;
//https://www.52jisuan.com/algebra/distancepointline.php 線上計算器


public class homework3 {
        public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        try {
            System.out.println("three numbers");
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();

            System.out.println("the bigger:"+(a>b?(a>c?(a):(c)):(b>c?(b):(c)))+"\n");
            /*if(a>b){
                if(a>c) a
                else c
            }
            else{
                if(b>c) b
                else c
            }*/
                
            System.out.println("middle: "+(a<b? (a>c? (a): (b>c? (c): (b))): (b>c? (b): (a>c? (c): (a))))+"\n");
            /*if(a>b){
                if(a>c) a
                else{
                    if(b>c) b
                    else b
                }
            }
            else{
                if(b>c) b
                else{
                    if(a>c) c
                    else a
                }
            }因為不確定這三個誰大誰小所以必須三個都找出來*/

            System.out.println("smallest:"+(a<b?(a<c?(a):(c)):(b<c?(b):(c)))+"\n");
            /*if(a<b){
                if(a<c) a
                else c
            }
            else{
                if(b<c) b
                else c
            }*/
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
