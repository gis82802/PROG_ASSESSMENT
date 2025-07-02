public class hw2
{
   public static void main(String args[]) throws Exception
   {
   	char ch1='-';
        char ch2='\\';
        char ch3='|';
        char ch4='/';
        for(int i=1;i>0;i++)
        {
             System.out.print(ch1+"\r");
             Thread.sleep(200);
             System.out.print(ch2+"\r");
             Thread.sleep(200);
             System.out.print(ch3+"\r");
             Thread.sleep(200);
             System.out.print(ch4+"\r");
             Thread.sleep(200);
        }
  
   }
}