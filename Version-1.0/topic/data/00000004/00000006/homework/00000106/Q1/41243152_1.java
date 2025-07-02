class hw1011b{
	public static void main(String[] args){
		int i=1;
		double targetPi = 3.14159;
        	double tolerance = 0.00001;
		while(true){
			int y=2;
			double pi=1,x=3;
			while(x<=2*i+1){
				if(y%2==0) pi-=1/x;
				if(y%2!=0) pi+=1/x;
				x+=2;
				y+=1;
			}
			pi=pi*4;
			if (Math.abs(pi - targetPi) < tolerance) {
                		System.out.println("最小的 i 值為: " + i);
                		break;
           		 }
			System.out.println("正在計算 i = " + i + ", π = " + pi);
			i++;
		}
	}
}