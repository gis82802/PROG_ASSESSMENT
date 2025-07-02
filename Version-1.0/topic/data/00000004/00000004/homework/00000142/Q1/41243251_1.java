public class hw2_0927 {
	public static void main(String[] args)throws Exception{
		for(int i=3;i>0;i--){
			System.out.print('\r'+"|");
			Thread.sleep(500);
			System.out.print('\r'+"/");
			Thread.sleep(500);
			System.out.print('\r'+"一");
			Thread.sleep(500);
			System.out.print('\r'+"\\");
			Thread.sleep(500);	
		}	
	}
}