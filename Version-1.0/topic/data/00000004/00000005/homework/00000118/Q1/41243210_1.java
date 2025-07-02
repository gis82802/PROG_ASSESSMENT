import java.util.Scanner;

public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入a點的x y座標:");
        float ax = scanner.nextFloat();
        float ay = scanner.nextFloat();
        System.out.println("請輸入b點的x y座標:");
        float bx = scanner.nextFloat();
        float by = scanner.nextFloat();
        if (ax == bx) {
            System.out.println("這是一條垂直線，方程式為 X = " + ax);
        } else {
            double slope = (by - ay) / (bx - ax);
            double intercept = ay - slope * ax;
            System.out.printf("直線方程式為: y = %.2fx + %.2f\n", slope, intercept);
            double angleInRadians = Math.atan(slope);
            double angleInDegrees = Math.toDegrees(angleInRadians);
            System.out.printf("直線與x軸的角度為: %.2f度\n", angleInDegrees);
        }
        double distance = Math.sqrt(Math.pow(bx - ax, 2) + Math.pow(by - ay, 2));
        System.out.println("歐式距離為: " + distance);
        distance = Math.abs(bx - ax) + Math.abs(by - ay);
        System.out.println("曼哈頓距離為: " + distance);
        distance = Math.max(Math.abs(bx - ax), Math.abs(by - ay));
        System.out.println("切比雪夫距離為: " + distance);

    }
}
