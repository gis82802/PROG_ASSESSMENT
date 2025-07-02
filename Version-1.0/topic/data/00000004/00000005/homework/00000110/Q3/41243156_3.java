import java.util.Scanner;
import java.lang.Math;
public class hw2 {
    public static void main(String avgs[]){
    Scanner scn=new Scanner(System.in);
    System.out.println("輸入第一個數值：");
    int a=scn.nextInt();
    System.out.println("輸入第二個數值：");
    int b=scn.nextInt();
    System.out.println("輸入第三個數值：");
    int c=scn.nextInt();
    int max=(a>b&&a>c)?a:(b>c?b:c);
    int min=(a<b&&a<c)?a:(b<c?b:c);
    int mid=(a+b+c)-(max+min);
    System.out.println("最大的數值為："+max);
    System.out.println("中間的數值為："+mid);
    System.out.println("最小的數值為："+min);
    }
}