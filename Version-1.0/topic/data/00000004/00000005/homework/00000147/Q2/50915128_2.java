import java.util.Scanner;

public class java4_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.println("請輸入直線方程式的係數 A, B, C (Ax + By + C = 0): ");
        double A = scanner.nextDouble();
        double B = scanner.nextDouble();
        double C = scanner.nextDouble();

        
        System.out.println("請輸入座標 (x0, y0): ");
        double x0 = scanner.nextDouble();
        double y0 = scanner.nextDouble();

       
        double distance = Math.abs(A * x0 + B * y0 + C) / Math.sqrt(A * A + B * B);

       
        System.out.println("點到直線的距離為: " + distance);
        
        scanner.close();
    }
}
