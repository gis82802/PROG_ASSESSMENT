import java.util.Scanner;

public class homework2_1 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入二維點
        System.out.println("Enter (x1, y1):");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.println("Enter (x2, y2):");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        //輸入p值
        System.out.println("Enter the order (p) for Minkowski distance:");
        double p = scanner.nextDouble();

        // 斜率 m
        if (x2 - x1 != 0) {
            double m = (y2 - y1) / (x2 - x1);

            // 截距 b
            double b = y1 - m * x1;

            // 直線方程式
            System.out.printf("(1) y = %.2fx + %.2f\n", m, b);
        } else {
            System.out.printf("(1) x = %.2f\n", x1);
        }

        // Euclidean Distance
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.printf("(2) Euclidean Distance: %.2f\n", distance);

        // Manhattan Distance
        double manhattanDistance = Math.abs(x2 - x1) + Math.abs(y2 - y1);
        System.out.printf("(3) Manhattan Distance: %.2f\n", manhattanDistance);

        // Minkowski
        double minkowskiDistance = Math.pow(Math.pow(Math.abs(x2 - x1), p) + Math.pow(Math.abs(y2 - y1), p), 1.0 / p);
        System.out.printf("(4) Minkowski : %.2f\n", p, minkowskiDistance);

        // 計算夾角
        double dotProduct = x1 * x2 + y1 * y2;
        double magnitudeA = Math.sqrt(x1 * x1 + y1 * y1); 
        double magnitudeB = Math.sqrt(x2 * x2 + y2 * y2);
        
        // cos
        double cosTheta = dotProduct / (magnitudeA * magnitudeB);
        double angleRadians = Math.acos(cosTheta);
        double angleDegrees = Math.toDegrees(angleRadians);
        
        // 輸出夾角
        System.out.printf("(5) cos : %.2f 度\n", angleDegrees);

        scanner.close();
    }
}
