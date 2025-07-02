import java.util.Scanner;

public class homework2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("A * x + B * y + C = ??\n");

        // 輸入
        System.out.print("輸入A: ");
        double A = scanner.nextDouble();

        System.out.print("輸入B: ");
        double B = scanner.nextDouble();

        System.out.print("輸入C: ");
        double C = scanner.nextDouble();

        System.out.print("輸入 x 座標: ");
        double x = scanner.nextDouble();

        System.out.print("輸入 y 座標: ");
        double y = scanner.nextDouble();

        // 計算
        double distance = Math.abs(A * x + B * y + C) / Math.sqrt(A * A + B * B);

        // 輸出
        System.out.println("點與直線之間的距離為: " + distance);

        scanner.close();
    }
}
