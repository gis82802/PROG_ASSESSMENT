public class round
{
	public static void main(String[] args)throws Exception
	{
		String[] ch={"\\","|","/","一"};
		while(true)
		{
			for(int i=0;i<=3;i++)
			{
				System.out.print(ch[i]+"\r");
				Thread.sleep(500);
			}
		}
	}
}