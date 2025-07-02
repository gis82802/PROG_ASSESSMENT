public class app3_H2
{
	public static void main(String args[]) throws InterruptedException
	{
		char[] ch ={'-','/','|','\\','-'};
		for(int i = 0;i < 5;i++)
		{
			System.out.print("\r"+ch[i]);
			Thread.sleep(200);
		}
	}
}