public class H22
{
   public static void main(String args[]) throws Exception{

      char[] ch = {'-','/','-','\\'};

      while(true)
      {
	for(int i=0;i<4;i++)
        {
	  System.out.print(ch[i]);
	  Thread.sleep(1000);
	  System.out.print("\b");
        }
      }
   }
}