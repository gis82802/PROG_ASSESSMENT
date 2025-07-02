public class J_1011_01 {
	public  static void main(String[] args){
		int i;
		double val;
		double pi;
		System.out.println("pi = 4(1-1/3+1/5-1/7+1/9-1/11+1/13-...-1/2i-1)");
		System.out.print("\n");
		
		val = 0;
		for(i=1;i<=100000;i++){
			if(i%2 == 1)      val += 1/(double)(2*i-1);
			else if(i%2 == 0) val -= 1/(double)(2*i-1);
			pi = 4*val;
			if(i%10000 == 0)
				System.out.printf("i=%6d, pi=%.6f\n",i,pi);
		}
		
		System.out.print("\n");
		i   = 1;
		val = 0;
		while(true){
			if(i%2 == 1)      val += 1/(double)(2*i-1);
			else if(i%2 == 0) val -= 1/(double)(2*i-1);
			pi = 4*val;
			if(pi >= 3.14159 && i%2 == 0)break;
			i++;
		}
		System.out.printf("若要得到 pi=%.5f, i值最小值為%d\n",pi,i);
		
	}
}
