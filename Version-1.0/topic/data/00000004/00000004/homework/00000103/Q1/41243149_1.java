public class rotating{
	public static void main(String[] args) throws InterruptedException{
		char[] symbols = {'/','-','\\','|'};
		while(true){
			for(char symbol:symbols){
				System.out.print("\r"+symbol);
				Thread.sleep(200);
			}
		}
	}
}