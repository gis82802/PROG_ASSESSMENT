public class app5_9{
	public static void main(String[] args){
	int [] terms = {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000};
	 for (int n : terms){
	   double pi = calculatePi(n);
	   System.out.printf("當i = %d時,所求得的pi值為 %.15f%n", n, pi);
	}
	}
public static double calculatePi(int n){
	double pi = 0.0;
	for(int i = 0; i < n; i++){
	  pi += Math.pow(-1,i) / (2 * i + 1);
       	}
	return pi * 4;
	}
}