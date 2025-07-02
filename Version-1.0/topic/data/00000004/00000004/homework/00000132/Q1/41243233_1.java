public class hw2{
	public static void main(String args[]) throws Exception{
		char ch[]={'\\','|','/','一'};
		
		for(int i=0;i<=3;i++){
			for(int j=0;j<=3;j++){
				System.out.print("\r    \r");
				System.out.print(ch[j]);
				Thread.sleep(1000);
			}	
		}
	}
}