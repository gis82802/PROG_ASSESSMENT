public class J_0927_2 {
	public static void clearScreen(){
		int i;
		for(i=0;i<50;i++){
			System.out.println("");
		}
		System.out.flush();
	}
	
	public static void main(String[] args) throws Exception{
		char[] ch = {'/','-','\\','|'};
		
		int i=0;
		for(i=0;i<40;i++){
			System.out.print(ch[i%4]);
			Thread.sleep(100);
			clearScreen(); //畫面清除
		}
	}
}
