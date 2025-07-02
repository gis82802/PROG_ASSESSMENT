// a0927_2
import java.util.concurrent.TimeUnit;
public class a0927_2
{
	public static void main(String arg[])
	{
		for(int i=0;;i++)
		{
			System.out.print("\033[H\033[2J");  
			System.out.flush();  
			if(i%4==0)
				System.out.print("\\");
			else if(i%4==1)
				System.out.print("|");
			else if(i%4==2)
				System.out.print("/");
			else if(i%4==3)
				System.out.print("-");
			try {
		TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt();
			}
			if(i>=16)
				i=0;
		}
	}
}