public class hw10111 {
    public static void main(String[] args) {
        // (a) 計算 π 的近似值，i 分別為 10000 到 100000，每次增加 10000
        for (int i = 10000; i <= 100000; i += 10000) {
            double pi = calculatePi(i);
            System.out.printf("i = %d, Approximate π = %.10f%n", i, pi);
        }
        System.out.printf("%n");

        // (b) 找到最小的 i 值，使得近似值達到 pi = 3.14159
        findMinIForPi();
    }

    // 計算 π 的近似值，根據給定的項數
    public static double calculatePi(int terms) {
        double pi = 0.0;
        for (int j = 0; j <= terms; j++) {
            // 使用交錯級數公式計算 π
            pi += Math.pow(-1, j) / (2.0 * j + 1);
        }
        return pi * 4; // 乘以 4 得到近似的 π 值
    }

    // 找到達到近似值 pi = 3.14159 所需的最小 i 值
    public static int findMinIForPi() {
        double pi = 0.0;
        int i = 0;
        boolean found = false;
        
        while (!found) {
            // 格雷戈里-萊布尼茲級數公式: pi = 4 * (1 - 1/3 + 1/5 - 1/7 + ...)
            pi += (Math.pow(-1, i) / (2 * i + 1)) * 4;

            // 列出當前的 i 值和對應的 pi 值
            //System.out.println("i = " + i + ", pi = " + pi);

            // 如果 pi 值超過 3.14159，結束迴圈
            if (pi >= 3.1415926 && pi <3.1415927) {
                found = true;
                System.out.println("i = " + i + ", pi = " + pi);
                System.out.println("最先超過 3.14159 的 i 值是: " + i);
            }

            i++;
        }
        return i;
    }
}
