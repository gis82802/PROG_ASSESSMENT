/*
filename:app5_1
function:Calaulate pi
author:PoXsun
date:2024/10/11
version:11.0.12
*/
public class app5_1
{
	public static void main(String[] args) {
        	for (int i = 10000; i <= 100000; i += 10000) {
			double pi = 0;
            	for (int n = 1; n <= i; n++) {
               		pi += Math.pow(-1, n + 1) / (2 * n - 1);
            	}
            		pi *= 4;
            		System.out.printf("當 i=%d 時，pi 的值為: %.6f%n", i, pi);
        	}
        
        	// 計算最小使得 pi=3.14159 的 i 值
        	double pi = 0;
        	int n = 1;
       	 	while (Math.abs(pi * 4 - 3.14159) > 0.00001) {
            		pi += Math.pow(-1, n + 1) / (2 * n - 1);
            		n++;
        	}
        	System.out.printf("要得到 pi=3.14159，最小的 i 值為: %d%n", n);
    	}
}