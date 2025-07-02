import java.util.Scanner; // 引入 Scanner 類別以便從控制台讀取輸入

public class test2 {

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

        // 計算直線方程式的係數 A, B, C
        double A = y2 - y1; // 直線的 A 值
        double B = x1 - x2; // 直線的 B 值
        double C = x2 * y1 - x1 * y2; // 直線的 C 值
        // 輸出直線方程式
        System.out.println("直線方程式為: " + A + "x + " + B + "y + " + C + " = 0");

        // 計算 y 截距和 x 截距
        double yIntercept = -C / B; // 當 x = 0 時的 y 值
        double xIntercept = -C / A; // 當 y = 0 時的 x 值
        // 輸出截距
        System.out.println("y 截距: " + yIntercept);
        System.out.println("x 截距: " + xIntercept);

        // 提示用戶輸入要計算距離的點的座標
        System.out.println("請輸入要計算距離的點的座標 x0, y0:");
        double x0 = scanner.nextDouble(); // 讀取 x0 座標
        double y0 = scanner.nextDouble(); // 讀取 y0 座標

        // 計算點到直線的距離
        double distance = Math.abs(A * x0 + B * y0 + C) / Math.sqrt(A * A + B * B);
        // 輸出距離
        System.out.println("點到直線的距離: " + distance);

        scanner.close(); // 關閉 Scanner 物件以釋放資源
    }
}
