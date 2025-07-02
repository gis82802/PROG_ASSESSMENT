public class stick{
	public static void main(String args[]) throws Exception{
		int n = 0;
		while(true){
			if(n % 4 == 0)System.out.print("\\");
			else if(n % 4 == 1)System.out.print("-");
			else if(n % 4 == 2)System.out.print("|");
			else System.out.print("/");
			Thread.sleep(200);
			System.out.print("\r");
			n++;
		}
	}
}