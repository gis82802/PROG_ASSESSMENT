import java.lang.Math;

public class Test1 {
    public static void main(String args[]) {
        
        int counter, maxCounter;
        double piValue;  

        for (maxCounter = 10000; maxCounter <= 100000; maxCounter += 10000) {
            piValue = 0;
            
            for (counter = 1; counter <= maxCounter; counter++) {   
                if (counter % 2 != 0) {
                    piValue += 1.0 / (2 * counter - 1);  // 加
                } else {
                    piValue -= 1.0 / (2 * counter - 1);  // 減
                }
            }

            System.out.printf("當 counter 值到達 %-7d 時 pi = %.10f\n", maxCounter, 4 * piValue);
        }
        
        
        piValue = 0;  
        counter = 1;  

        while (true) {

            if (counter % 2 != 0) {
                piValue += 1.0 / (2 * counter - 1);  // 加
            } else {
                piValue -= 1.0 / (2 * counter - 1);  // 減
            }
            
            counter++;
            
            if (Math.abs(4 * piValue - 3.14159) < 0.000001) {
                break;
            }
        }
       
        System.out.printf("\n當 counter 值到達 %d 時可得到 pi = %.5f\n", counter, 4 * piValue);
    }
}
