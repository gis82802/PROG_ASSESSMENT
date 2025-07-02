public class app_2_2//import Scanner
{
    	public static void main(String[] args) 
	{
		int t=0;
		for(int num=1;num<=10000;num++)
		{
			int[] n = new int[String.valueOf(num).length()];

			int f=0;
       			for (int i = 1; i <= n.length; i++) 
			{
           	 		n[i - 1] = (num % (int) Math.pow(10, i)) / (int) Math.pow(10, i - 1);//get reserve one num

            			if (i > 1) 
	    			{
                			if (n[i - 2] > n[i - 1]) //check

					{
                    				f=1;
                			}
					else
					{
						f=0;
						break;
					}
            			}	
        		}
           		 if (f == 1) 
			{
                		t++;  //add
                		System.out.println(num);  // out current num
        	    	}
		}
		System.out.print("Have:"+t);//out total

   	}
}
