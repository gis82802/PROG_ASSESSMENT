import java.util.Scanner;

public class java4_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("請輸入點A的座標 (x1, y1): ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.println("請輸入點B的座標 (x2, y2): ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        //計算直線方程式(y = mx + c)
        if (x1 != x2) {
            double m = (y2 - y1) / (x1 - x2); //斜率m
            double c = y1 - m * x1; //截距c
            System.out.println("通過這兩點的直線方程式為: y = " + m + "x + " + c);
        } else {
            System.out.println("直線為垂直線，方程式為: x = " + x1);
        }
        //計算歐式距離
        double euclideanDistance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("兩點的歐式距離為: " + euclideanDistance);
        //計算曼哈頓距離
        double manhattanDistance = Math.abs(x2 - x1) + Math.abs(y2 - y1);
        System.out.println("兩點的曼哈頓距離為: " + manhattanDistance);
        //計算Minkowski 距離,預設p=3
        double p = 3;
        double minkowskiDistance = Math.pow(Math.pow(Math.abs(x2 - x1), p) + Math.pow(Math.abs(y2 - y1), p), 1.0 / p);
        System.out.println("兩點的 Minkowski 距離 (p=" + p + ") 為: " + minkowskiDistance);
        //計算兩向量夾角(cosθ=dot(A,B)/|A|*|B|)
        double dotProduct = x1 * x2 + y1 * y2;
        double magnitudeA = Math.sqrt(x1 * x1 + y1 * y1);
        double magnitudeB = Math.sqrt(x2 * x2 + y2 * y2);
        double cosTheta = dotProduct / (magnitudeA * magnitudeB);
        double angle = Math.acos(cosTheta) * (180.0 / Math.PI); //轉角度
        System.out.println("兩個向量的夾角為: " + angle + " 度");

        scanner.close();
    }
}
