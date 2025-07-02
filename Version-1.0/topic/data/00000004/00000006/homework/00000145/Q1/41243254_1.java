//app5_test3
//filename:app5_test3
//function:(1)i=10000,20000,...100000所求的pi項為何(2)若要得到pi=3.14159 i最小值為何
//author:xiao
//date:10/11
//version:11.0.12
public class app5_test3 {
    public static void main(String[] args) {
        // i = 10000 時的 π
        int terms = 10000;
        double pi = 0.0;
        for (int i = 1; i <= terms; i++) {
            pi += Math.pow(-1, i + 1) / (2 * i - 1);
        }
        pi *= 4;
        System.out.println("當 i = 10000 時, π = " + pi);
        
        // i = 20000 時的 π
        terms = 20000;
        pi = 0.0;
        for (int i = 1; i <= terms; i++) {
            pi += Math.pow(-1, i + 1) / (2 * i - 1);
        }
        pi *= 4;
        System.out.println("當 i = 20000 時, π = " + pi);
        
        // i = 30000 時的 π
        terms = 30000;
        pi = 0.0;
        for (int i = 1; i <= terms; i++) {
            pi += Math.pow(-1, i + 1) / (2 * i - 1);
        }
        pi *= 4;
        System.out.println("當 i = 30000 時, π = " + pi);
        
        // i = 40000 時的 π
        terms = 40000;
        pi = 0.0;
        for (int i = 1; i <= terms; i++) {
            pi += Math.pow(-1, i + 1) / (2 * i - 1);
        }
        pi *= 4;
        System.out.println("當 i = 40000 時, π = " + pi);
        
        // i = 50000 時的 π
        terms = 50000;
        pi = 0.0;
        for (int i = 1; i <= terms; i++) {
            pi += Math.pow(-1, i + 1) / (2 * i - 1);
        }
        pi *= 4;
        System.out.println("當 i = 50000 時, π = " + pi);
        
        // i = 60000 時的 π
        terms = 60000;
        pi = 0.0;
        for (int i = 1; i <= terms; i++) {
            pi += Math.pow(-1, i + 1) / (2 * i - 1);
        }
        pi *= 4;
        System.out.println("當 i = 60000 時, π = " + pi);
        
        // i = 70000 時的 π
        terms = 70000;
        pi = 0.0;
        for (int i = 1; i <= terms; i++) {
            pi += Math.pow(-1, i + 1) / (2 * i - 1);
        }
        pi *= 4;
        System.out.println("當 i = 70000 時, π = " + pi);
 
        // i = 80000 時的 π
        terms = 80000;
        pi = 0.0;
        for (int i = 1; i <= terms; i++) {
            pi += Math.pow(-1, i + 1) / (2 * i - 1);
        }
        pi *= 4;
        System.out.println("當 i = 80000 時, π = " + pi);

        // i = 90000 時的 π
        terms = 90000;
        pi = 0.0;
        for (int i = 1; i <= terms; i++) {
            pi += Math.pow(-1, i + 1) / (2 * i - 1);
        }
        pi *= 4;
        System.out.println("當 i = 90000 時, π = " + pi);

        // i = 100000 時的 π
        terms = 100000;
        pi = 0.0;
        for (int i = 1; i <= terms; i++) {
            pi += Math.pow(-1, i + 1) / (2 * i - 1);
        }
        pi *= 4;
        System.out.println("當 i = 100000 時, π = " + pi);

                   // 找出 pi = 3.14159 
                   double targetPi = 3.141591;
                   pi = 0.0;
                  terms = 0;
                  double tolerance = 0.000001;  // 誤差範圍
        
                  // 繼續增加項直到計算出的 π 值達到 3.14159
                   while (Math.abs(pi * 4 - targetPi) > tolerance)
                   {
                      terms++;
                       pi += Math.pow(-1, terms + 1) / (2 * terms - 1);
                   }
                  pi *= 4;
                 System.out.println("最小 i = " + terms + " 時, π = " + pi);
    }
}
