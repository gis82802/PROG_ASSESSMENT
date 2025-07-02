public class stick
{
	public static void main(String[] args)throws Exception
	{
		char[] cha=new char[]{'|','/','-','\\'};
		int ch=0;
		while(true)
		{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			System.out.println(cha[ch]);
			Thread.sleep(1000);
			ch++;
			if(ch==4)
				{ch=0;}
		}
	}
}