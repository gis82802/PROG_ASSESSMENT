import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        System.out.print("輸入第一個點X1: ");
        float x1 = scn.nextFloat();
        System.out.print("輸入第一個點Y1: ");
        float y1 = scn.nextFloat();
        System.out.print("輸入第二個點X2: ");
        float x2 = scn.nextFloat();
        System.out.print("輸入第二個點Y2: ");
        float y2 = scn.nextFloat();
        
        if (x1 == x2) {
            System.out.println("這兩點的X坐標相同，直線是垂直的，方程式為: x = " + x1);
        } else {
            float m = (y2 - y1) / (x2 - x1);  //先計算斜率再用斜率計算方程式
            float b = y1 - m * x1;  
            System.out.println("直線方程式為: y = " + m + "x + " + b);
        }
        //歐式距離
         float distance = (float) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("兩點之間的歐式距離為: " + distance);
        //曼哈頓距離
        float Mdistance =(float)Math.abs(x1-x2)+Math.abs(y1-y2);
        System.out.println("兩點之間的曼哈頓距離為: " + Mdistance);
        
        //切比雪夫距離
        float Cdistance = Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
        System.out.println("兩點之間的切比雪夫距離為: " + Cdistance);

        System.out.println("第一個點: (" + x1 + ", " + y1 + ")");
        System.out.println("第二個點: (" + x2 + ", " + y2 + ")");

        scn.close();  
    }
}
