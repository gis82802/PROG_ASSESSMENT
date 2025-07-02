/*
    Filename: "hwapp01_1011"
    Function: 計算PI
    Author: SHUN-YE XU
    Version: 23
    date: 2024/10/11
*/

public class hwapp01_1011
{
    public static void main(String args[])
    {
		double pi = 0.0;
		// A
        for(int i = 10000; i <= 100000; i += 10000)
		{
			// 使計算完後的pi可以用於後續計算
			for(int j = i - 10000; j < i; j++)
			{
				// (-1)^n/2n+1
				pi = pi + Math.pow(-1, j) / (2*j+1);
			}
			System.out.println("i="+i+", PI="+pi*4);
		}
		
		// B
        // 不斷累加直到精度達到 3.14159
		int i = 100000;
        while ((int) (pi * 4 * 100000) != 314159) {
            pi = pi + Math.pow(-1, i) / (2*i+1);
            i++;
        }
        System.out.println("pi="+4*pi+", i="+i);
    
    }
}