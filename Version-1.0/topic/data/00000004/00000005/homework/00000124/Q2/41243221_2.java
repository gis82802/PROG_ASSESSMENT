import java.util.Scanner;
public class app4_3
{
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int iP_x,iP_y;        //iP_x 點P的x、iP_y 點P的y
	int iL_a,iL_b,iL_c;   //iL_a直線L的x係數,iL_b直線L的y係數,iL_c直線L的c係數
        double d_len;         //d_len直線距離
        //輸入初值
	System.out.println("ax+by+c=0");
        System.out.print("請輸入a值:");
        iL_a=sc.nextInt();
        System.out.print("請輸入b值:");
        iL_b=sc.nextInt();
        System.out.print("請輸入c值:");
        iL_c=sc.nextInt();
	System.out.print("請輸入P(x,y)的x:");
        iP_x=sc.nextInt();
	System.out.print("請輸入P(x,y)的y:");
        iP_y=sc.nextInt();

        //計算點到直線距離
        d_len=Math.abs((iL_a*iP_x+iL_b*iP_y+iL_c))/Math.sqrt(Math.pow(iL_a,2)+Math.pow(iL_b,2));
        System.out.println("距離為:"+d_len);
    }
}