public class PiCalculation {
	
    public static void main(String[] args) {
       for(int j=10000;j<=100000;j+=10000)
	{
		double pi = 0.0;
        						// 根據公式: pi = 4(1 - 1/3 + 1/5 - 1/7 + ...)
        for (int i = 0; i < j; i++) {
            if (i % 2 == 0) {
                pi += 1.0 / (2 * i + 1); 		// 偶數位加
            } else {
                pi -= 1.0 / (2 * i + 1); 			// 奇數位減
            }
        }

        pi *= 4;
		System.out.println("當i = "+j+", pi = "+pi);
	}
	



	double targetpi = 0.7853975;
	double pit=0.0;
        int r=1;						
        for (r = 0; pit<=0.7853975 || pit>=0.7854 ; r++) {
            
	    if (r % 2 == 0) {
                pit += 1.0 / (2 * r + 1); 		
            } else {
                pit -= 1.0 / (2 * r + 1); 			
            }
		 
	}
r=r-1;
System.out.println("當pi=3.14159 i最小值為 "+r);			
    }
}
