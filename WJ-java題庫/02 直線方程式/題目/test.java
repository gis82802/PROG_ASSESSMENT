import java.util.Scanner;

public class LineEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 輸入兩個座標點
        //System.out.print("Enter x1 y1: ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        //System.out.print("Enter x2 y2: ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        // 計算斜率 m
        double m = (y2 - y1) / (x2 - x1);

        // 計算截距 b
        double b = y1 - m * x1;

        // 輸出直線方程式
        //System.out.println("The line equation is: y = " + m + "x + " + b);
        System.out.println(m + "x + " + b);

        sc.close();
    }
}
