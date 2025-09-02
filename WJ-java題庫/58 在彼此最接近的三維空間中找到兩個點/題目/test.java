import java.util.Scanner;
import java.lang.Math;

public class test {

    /**
     * 計算三維空間中兩點之間的距離
     * @param p1 第一個點的座標陣列
     * @param p2 第二個點的座標陣列
     * @return 兩點之間的距離
     */
    public static double distance(double[] p1, double[] p2) {
        double dx = p2[0] - p1[0];
        double dy = p2[1] - p1[1];
        double dz = p2[2] - p1[2];
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("請輸入點的數量: ");
        int numberOfPoints = scanner.nextInt();

        if (numberOfPoints < 2) {
            System.out.println("至少需要兩個點才能計算距離。");
            scanner.close();
            return;
        }

        double[][] points = new double[numberOfPoints][3];
        //System.out.println("請輸入 " + numberOfPoints + " 個點的座標 (x y z):");
        for (int i = 0; i < numberOfPoints; i++) {
            points[i][0] = scanner.nextDouble(); // x
            points[i][1] = scanner.nextDouble(); // y
            points[i][2] = scanner.nextDouble(); // z
        }
        scanner.close();

        int p1Index = 0;
        int p2Index = 1;
        double minDistance = distance(points[0], points[1]);

        // 遍歷所有點對
        for (int i = 0; i < numberOfPoints; i++) {
            for (int j = i + 1; j < numberOfPoints; j++) {
                double currentDistance = distance(points[i], points[j]);
                if (currentDistance < minDistance) {
                    minDistance = currentDistance;
                    p1Index = i;
                    p2Index = j;
                }
            }
        }
        
        System.out.println("點 A (" + points[p1Index][0] + ", " + points[p1Index][1] + ", " + points[p1Index][2] + 
                           ") 與 點 B (" + points[p2Index][0] + ", " + points[p2Index][1] + ", " + points[p2Index][2] + 
                           ") 之間的最小距離為 " + minDistance);
    }
}