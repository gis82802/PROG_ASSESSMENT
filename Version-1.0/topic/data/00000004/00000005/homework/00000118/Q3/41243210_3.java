import java.util.Scanner;

public class No3{
    public static void main(String[] args) {
       Scanner scanner=new Scanner(System.in);
       System.out.println("請輸入a b c 3個點:");
       float a=scanner.nextFloat();
       float b=scanner.nextFloat();
       float c=scanner.nextFloat();
       float max,mid,min;
       max=(a>b)?((a>c)?a:c):((b>c)?b:c);
       min=(a<b)?((a<c)?a:c):((b<c)?b:c);
       mid=(a!=max&&a!=min)?a:((b!=max&&b!=min)?b:c);
       System.out.println("最大值為:"+max);
       System.out.println("中間值為:"+mid);
       System.out.println("最小值為:"+min);
    }
}
