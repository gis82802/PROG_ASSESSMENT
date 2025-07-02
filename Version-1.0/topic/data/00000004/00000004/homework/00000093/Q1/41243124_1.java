public class test0927 
{
	public static void main(String[] args) throws Exception 
	{
        	char[] uni = new char[]{'|', '/', '—', '\\'};  
        	int i = 0;
        
        	while (true) 
		{
            		Thread.sleep(20);
            		System.out.print(uni[i]);
            		i = (i + 1) % uni.length;  
            		Thread.sleep(20);
            		System.out.print("\r");  
   		}
	}
}