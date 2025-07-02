public class ejp4
{
	public static void main(String[] args)throws Exception
	{
		char[] charr=new char[]{'\\','-','/','|'};		
		while(true)
		{
			for(int i=0;i<4;i++)
			{
				new ProcessBuilder("cmd","/c","cls")
				.inheritIO()
				.start()
				.waitFor();
				System.out.println(charr[i]);
				Thread.sleep(300);
			}
		}
	}
}