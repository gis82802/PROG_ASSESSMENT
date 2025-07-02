public class hw1_2 
{
    public static void main(String[] args) throws InterruptedException
	 {
		char[] sChars = {'|', '/', '-', '\\'};
                while (true)
		 {
           		 for (char c : sChars)
			 {
                		System.out.print("\r" + c);
                		Thread.sleep(200);
            }
        }
    }
}