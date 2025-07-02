import java.util.Scanner;

public class No2 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.println("請輸入點x,y座標:");
       double x=scanner.nextDouble();
       double y=scanner.nextDouble();
       System.out.println("請輸入直線係數a b c:(例子ax+by+c=0):");
       double a=scanner.nextDouble();
       double b=scanner.nextDouble();
       double c=scanner.nextDouble();
       double distance =Math.abs(x*a+y*b+c)/Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
       System.out.printf("點(%.2f,%.2f)到直線 %.2fx + %.2fy + %.2f = 0 的距離為:%.2f\n",x,y,a,b,c,distance);
    }
}
