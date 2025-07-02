import java.util.Scanner;

public class linedistance {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

      //輸入直線座標
        System.out.print("輸入直線上的第一個點X1: ");
        float x1 = scn.nextFloat();
        System.out.print("輸入直線上的第一個點Y1: ");
        float y1 = scn.nextFloat();
        System.out.print("輸入直線上的第二個點X2: ");
        float x2 = scn.nextFloat();
        System.out.print("輸入直線上的第二個點Y2: ");
        float y2 = scn.nextFloat();

      
        float A = y2 - y1;  
        float B = x1 - x2; 
        float C = x2 * y1 - x1 * y2;  

       //輸入要計算距離的點
        System.out.print("輸入要計算距離的點X0: ");
        float x0 = scn.nextFloat();
        System.out.print("輸入要計算距離的點Y0: ");
        float y0 = scn.nextFloat();

       
        float distance = Math.abs(A * x0 + B * y0 + C) / (float) Math.sqrt(A * A + B * B);
        
        System.out.println("點到直線的距離為: " + distance);

        scn.close();  
    }
}
