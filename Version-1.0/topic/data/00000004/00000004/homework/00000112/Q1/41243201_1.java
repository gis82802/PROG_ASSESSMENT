public class hw2_2{
	public static void main(String[] args)throws Exception{
		String[] stick={"\\","-","/","|"};
		while(true){
			for(int i=0;i<=3;i++)
			{
				System.out.print(stick[i]+"\r");
				Thread.sleep(1000);
			}
		}
 }
}
