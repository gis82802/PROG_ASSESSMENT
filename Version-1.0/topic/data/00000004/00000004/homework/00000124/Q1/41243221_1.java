public class app3_6
{
    public static void main(String arg[]) throws Exception
    {
	for(int i=0;i>=0;i++)
	{
	    System.out.print("\r"+"\\");
	    Thread.sleep(100);
	    System.out.print("\r"+"-");
	    Thread.sleep(100);
	    System.out.print("\r"+"/");
	    Thread.sleep(100);
	}
    }
}