import java.util.Scanner; // 引入 Scanner 類別以便從控制台讀取輸入

public class test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 創建 Scanner 物件以讀取用戶輸入

        // 提示用戶輸入第一個點的座標
        System.out.println("請輸入第一個點的座標 x1, y1:");
        double x1 = scanner.nextDouble(); // 讀取 x1 座標
        double y1 = scanner.nextDouble(); // 讀取 y1 座標
        
        // 提示用戶輸入第二個點的座標
        System.out.println("請輸入第二個點的座標 x2, y2:");
        double x2 = scanner.nextDouble(); // 讀取 x2 座標
        double y2 = scanner.nextDouble(); // 讀取 y2 座標

        // 計算並顯示直線方程式
        if (x1 != x2) { // 確保不為垂直線
            double m = (y2 - y1) / (x2 - x1); // 計算斜率 m
            double b = y1 - m * x1; // 計算截距 b
            System.out.println("直線方程式為: y = " + m + "x + " + b); // 輸出直線方程式
        } else {
            System.out.println("無法計算垂直線的斜率（斜率不存在）"); // 垂直線情況的提示
        }

        // 計算歐式距離
        double euclideanDistance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("歐式距離: " + euclideanDistance); // 輸出歐式距離

        // 計算曼哈頓距離
        double manhattanDistance = Math.abs(x2 - x1) + Math.abs(y2 - y1);
        System.out.println("曼哈頓距離: " + manhattanDistance); // 輸出曼哈頓距離

        // 計算切比雪夫距離
        double chebyshevDistance = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
        System.out.println("切比雪夫距離: " + chebyshevDistance); // 輸出切比雪夫距離

        // 計算兩個向量的夾角
        double dotProduct = x1 * x2 + y1 * y2; // 計算內積
        double magnitudeA = Math.sqrt(x1 * x1 + y1 * y1); // 計算向量 A 的大小
        double magnitudeB = Math.sqrt(x2 * x2 + y2 * y2); // 計算向量 B 的大小
        double cosTheta = dotProduct / (magnitudeA * magnitudeB); // 計算 cos(θ)
        double angle = Math.acos(cosTheta) * (180 / Math.PI); // 將弧度轉換為度數
        System.out.println("向量夾角 (度數): " + angle); // 輸出向量夾角
    }
}

