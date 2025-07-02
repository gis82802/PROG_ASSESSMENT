public class pi {

    public static void main(String[] args) {
        // 從 n = 10000 開始，每次增加 10000，到 n = 100000
	double pi=0.0;
	System.out.println("(a)");
        for (int n = 10000; n <= 100000; n += 10000) {
            pi = 0.0;
            for (int i = 0; i < n; i++) {
                // 交替的加減
                if (i % 2 == 0) {
                    pi += 1.0 / (2 * i + 1);
                } else {
                    pi -= 1.0 / (2 * i + 1);
                }
            }
            pi *= 4; // 根據公式乘以 4
            System.out.println("n = " + n + " 時 Pi 的近似值: " + pi);
        }
        // 找到最接近 3.14159 的 Pi 值所需的最小值
	System.out.println("(b)");
        double epsilon = 0.000001;  // 允許的誤差範圍
        int n = 1;
        while (Math.abs((4 * (1 - 1.0 / (2 * n + 1))) - 3.14159) > epsilon) {
            n++;
	    pi = 0.0;
            for (int i = 0; i < n; i++) {
                // 交替的加減
                if (i % 2 == 0) {
                    pi += 1.0 / (2 * i + 1);
                } else {
                    pi -= 1.0 / (2 * i + 1);
                }
            }
            pi *= 4; // 根據公式乘以 4
            // 計算 Pi 與 3.14159 的誤差
            if (Math.abs(pi - 3.14159) <= epsilon) {
                break; //跳出
            }
	    //System.out.print(".");
        }
	System.out.print("若要得到 Pi 接近 3.14159 ,i 最小值須為: " + n + "此時pi為:"+ pi);
    }
}

