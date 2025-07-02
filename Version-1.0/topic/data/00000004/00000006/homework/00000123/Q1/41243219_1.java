public class hw1{
	public static void main(String args[]){ //136120
		int N = 10000;
		double i, pi = 0;
		for(; N <= 100000; N += 10000){
			pi = 1;
			for(i = 2; i <= N; i += 2){
				pi = pi + ((1 / (2 * i + 1)) - (1 / (2 * i - 1)));
			}
			System.out.print("i = " + N + ": ");
			System.out.println(4 * pi);	
		}
		
		i = N;
		for(; Math.abs(4 * pi * 100000 - 314159) > 1 ; i += 2){
			pi = pi + ((1 / (2 * i + 1)) - (1 / (2 * i - 1)));	
			//System.out.println(4 * pi * 100000);
		}
		System.out.println(i);
		//System.out.println(4 * pi);
	}
}