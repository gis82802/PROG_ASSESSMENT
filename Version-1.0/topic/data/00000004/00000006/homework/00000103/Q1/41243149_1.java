public class hw1 {
    public static void main(String[] args) {
        // a
        for (int i = 10000; i <= 100000; i += 10000) {
            double pi = cal(i);
            System.out.printf("i = %d, pi = %.5f%n", i, pi);
        }

        // b
        // 逐步計算，直到剛好等於 3.14159
        double ans=3.14159;
        for(int i=375000;i<380000;i++){
            double pi = cal(i);
            if(pi-ans>1e-15){
                System.out.println("i最小值為"+i+" pi="+pi);
                break;
            }
            
        }
    }
   
    // 計算 pi 的值
    public static double cal(int n) {
        double pi = 0;
        double sign = 1.0; // 使用符號控制，避免每次計算 (-1)^i

        // 每次迴圈處理兩項
        for (int i = 0; i < n; i += 2) {
            pi += sign / (2 * i + 1);         // 第 i
            pi -= sign / (2 * (i + 1) + 1);   // 第 i+1
        }

        return 4 * pi;
    }
}
