import java.util.Scanner;

public class hw10042 {

    public static double calculateDistance(double A, double B, double C, double x1, double y1) {
	// 使用點到直線的距離公式：|Ax1 + By1 + C| / sqrt(A^2 + B^2)
        return Math.abs(A * x1 + B * y1 + C) / Math.sqrt(A * A + B * B);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

	// 提示使用者輸入直線方程式的係數
        System.out.println("Enter the coefficients of the line (Ax + By + C = 0):");
        System.out.print("A: ");
        double A = scanner.nextDouble();
        System.out.print("B: ");
        double B = scanner.nextDouble();
        System.out.print("C: ");
        double C = scanner.nextDouble();
	
	// 提示使用者輸入點的座標
        System.out.println("Enter the coordinates of the point (x1, y1):");
        System.out.print("x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("y1: ");
        double y1 = scanner.nextDouble();

	// 計算點到直線的距離
        double distance = calculateDistance(A, B, C, x1, y1);

        System.out.printf("The distance between the point (%.2f, %.2f) and the line %.2fx + %.2fy + %.2f = 0 is: %.4f\n", x1, y1, A, B, C, distance);

        scanner.close();
    }
}
