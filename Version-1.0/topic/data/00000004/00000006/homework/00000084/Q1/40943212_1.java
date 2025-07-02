/*
	filename:Java_1011_01
	function:pi值計算
	author:陳廷威 40943212
	datetime:2024/10/11
	version:1.0
*/

public class Java_1011_01 {
    // 計算公式的pi值
    public static double calculatePi(int terms) {
        double pi = 0.0;
        for (int i = 1; i <= terms; i++) {
            // 公式計算
            pi += Math.pow(-1, i + 1) / (2 * i - 1);
        }
        return 4 * pi;
    }

    public static void main(String[] args) {
        // (a) 計算 i 的 pi 值
        int[] termValues = {10000, 20000, 50000, 100000}; 
        System.out.println("計算 i = 10000, 20000, 50000, 100000 時的 pi 值:");
        for (int terms : termValues) {
            double pi = calculatePi(terms);
            System.out.printf("i = %d 時，π ? %.10f%n", terms, pi);
        }

        // (b) 找到使 pi 接近 3.14159 的最小 i
        double targetPi = 3.14159;
        int minI = 0;
        for (int i = 1; ; i++) {
            double pi = calculatePi(i);
            if (Math.abs(pi - targetPi) < 0.00001) { // 設定誤差
                minI = i;
                System.out.printf("最小的 i 值，使得 pi ? %.5f 是: %d%n", targetPi, minI);
                break;
            }
        }
    }
}


