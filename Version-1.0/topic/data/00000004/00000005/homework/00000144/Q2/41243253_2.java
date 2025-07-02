import java.util.Scanner;

public class hw2 {

    
    public static double calculateDistance(double A, double B, double C, double x1, double y1)   // 計算點到直線的距離
    { 
	 return Math.abs(A * x1 + B * y1 + C) / Math.sqrt(A * A + B * B);
    }

    public static void main(String args[]) 
    { 
	Scanner scanner = new Scanner(System.in);

        // 輸入直線的參數 A, B, C
        System.out.print("請輸入直線方程的係數 A: ");
        double A = scanner.nextDouble();

        System.out.print("請輸入直線方程的係數 B: ");
        double B = scanner.nextDouble();

        System.out.print("請輸入直線方程的常數 C: ");
        double C = scanner.nextDouble();

        // 輸入數據點的坐標 x1, y1
        System.out.print("請輸入數據點的 x 坐標: ");
        double x1 = scanner.nextDouble();

        System.out.print("請輸入數據點的 y 坐標: ");
        double y1 = scanner.nextDouble();

        // 計算距離
        double distance = calculateDistance(A, B, C, x1, y1);

        // 顯示結果
        System.out.println("數據點到直線的距離是: " + distance);

        scanner.close();
    }
}
