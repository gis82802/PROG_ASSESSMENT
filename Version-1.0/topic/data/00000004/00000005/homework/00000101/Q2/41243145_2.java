import java.io.BufferedReader;
import java.util.Scanner;
import mypackage.Point;
import javax.swing.border.SoftBevelBorder;
//https://www.52jisuan.com/algebra/distancepointline.php 線上計算器
class Point {  //public 是專案所以只要class就好 需要先宣告Point 
    private double x;
    private double y;
    public Point(double x,double y) {
        this.x=x;
        this.y=y;
    }
    public double getx(){return x; }
    public void setx(double x){this.x=x; }
    public double gety(){return y; }
    public void sety(double y){this.y=y; }

}

public class homework2 {
        public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        try {
            System.out.println("The line:");
            Point slope=new Point(sc.nextInt(), sc.nextInt());
            int displace=sc.nextInt();

            System.err.println("point:");
            Point point=new Point(sc.nextInt(), sc.nextInt());

            double molecular=slope.getx() * point.getx() + slope.gety() * point.gety() + displace;
            double denominator=Math.pow(slope.getx(), 2) + Math.pow(slope.gety(), 2);
            double answer=Math.abs(molecular) / Math.sqrt(denominator);
            System.err.println(answer + "is the answer\n");//d=│AXo+BYo+C│ / √（A²+B²）

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
