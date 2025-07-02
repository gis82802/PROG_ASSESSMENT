import java.util.Scanner;

public class PointCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("請輸入第一個點的x座標：");
            double x1 = scanner.nextDouble();
            System.out.println("請輸入第一個點的y座標：");
            double y1 = scanner.nextDouble();
            System.out.println("請輸入第二個點的x座標：");
            double x2 = scanner.nextDouble();
            System.out.println("請輸入第二個點的y座標：");
            double y2 = scanner.nextDouble();

            // 計算歐式距離
            double euclideanDistance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            System.out.println("歐式距離： " + euclideanDistance);

            // 計算曼哈頓距離
            double manhattanDistance = Math.abs(x2 - x1) + Math.abs(y2 - y1);
            System.out.println("曼哈頓距離： " + manhattanDistance);

            // 計算Minkowski距離
            System.out.println("請輸入Minkowski距離的p值：");
            double p = scanner.nextDouble();
            double minkowskiDistance = Math.pow(Math.pow(Math.abs(x2 - x1), p) + Math.pow(Math.abs(y2 - y1), p), 1.0 / p);
            System.out.println("Minkowski距離： " + minkowskiDistance);

            // 計算向量夾角
            double dotProduct = x1 * x2 + y1 * y2;
            double lengthA = Math.sqrt(x1 * x1 + y1 * y1);
            double lengthB = Math.sqrt(x2 * x2 + y2 * y2);
            double cosTheta = dotProduct / (lengthA * lengthB);
            double angleInRadians = Math.acos(cosTheta);
            double angleInDegrees = Math.toDegrees(angleInRadians);
            System.out.println("兩個向量的夾角 (角度)： " + angleInDegrees + " 度");

            System.out.println("是否繼續計算？(y/n)");
            if (!scanner.next().equalsIgnoreCase("y")) {
                break;
            }
        }
    }
}