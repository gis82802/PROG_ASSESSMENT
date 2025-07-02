import java.util.Scanner;
public class app4_4
{
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
	int In_a,In_b,In_c;	//輸入值a、b、c
	int max,middle,min;	//最大值、中間值、最小值
             //輸入初值
	System.out.print("請輸入a值:");
        In_a=sc.nextInt();
        System.out.print("請輸入b值:");
        In_b=sc.nextInt();
        System.out.print("請輸入c值:");
        In_c=sc.nextInt();
        //計算最大值
	max=(In_a>In_b)?((In_a>In_c)?In_a:In_c):((In_b>In_c)?In_b:In_c);
        //計算最小值
	min=(In_a>In_b)?((In_b>In_c)?In_c:In_b):((In_a>In_c)?In_c:In_a);
        //計算中間值
	middle=(In_a!=max && In_a!=min)?In_a:((In_b!=max && In_b!=min)?In_b:In_c);
	middle=(In_a==In_b)?In_a:((In_b==In_c)?In_b:((In_c==In_a)?In_c:middle));
	System.out.println("MAX="+max);
	System.out.println("MIN="+min);
	System.out.println("MIDDLE="+middle);
    }
}