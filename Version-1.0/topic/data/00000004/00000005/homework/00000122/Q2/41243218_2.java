import java.util.Scanner;

public class PointToLineDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入直線的一般式方程 A, B, C
        System.out.print("請輸入直線一般式方程的 A: ");
        double A = scanner.nextDouble();
        System.out.print("請輸入直線一般式方程的 B: ");
        double B = scanner.nextDouble();
        System.out.print("請輸入直線一般式方程的 C: ");
        double C = scanner.nextDouble();

        // 輸入點的座標 x1, y1
        System.out.print("請輸入點的 x 座標: ");
        double x1 = scanner.nextDouble();
        System.out.print("請輸入點的 y 座標: ");
        double y1 = scanner.nextDouble();

        // 計算點到直線的距離
        double distance = Math.abs(A * x1 + B * y1 + C) / Math.sqrt(A * A + B * B);

        System.out.println("點到直線的距離為: " + distance);
    }
}