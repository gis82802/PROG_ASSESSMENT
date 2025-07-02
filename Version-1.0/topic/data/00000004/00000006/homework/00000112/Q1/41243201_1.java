public class hw1011_1
{
	public static void main(String[] args)
	{
		double pi=0,n1=0,n2=0;
		int min = -1;

		for(int i=0;i<=150000;i++)
		{
			if (i % 2 == 0)
			{  
                		n1 += (1.0 / (2 * i + 1));
            		} 
			else				{  
               			 n2 -= (1.0 / (2 * i + 1));
            		}
            		
			pi = 4 * (n1 + n2);
			
			if ((int)(pi*100000)==(int)(3.14159*100000)) 
			{
				System.out.println("pi=3.14159時，i最小值為: "+i);
				break;
       	   		}
 
				switch(i)
			{
				case 10000:
					System.out.println("i = "+i+",pi = "+pi);
				break;

				case 20000:
					System.out.println("i = "+i+",pi = "+pi);
				break;
	
				case 30000:
					System.out.println("i = "+i+",pi = "+pi);
				break;

				case 40000:
					System.out.println("i = "+i+",pi = "+pi);
				break;
	
				case 50000:
					System.out.println("i = "+i+",pi = "+pi);
				break;

				case 60000:
					System.out.println("i = "+i+",pi = "+pi);
				break;

				case 70000:
					System.out.println("i = "+i+",pi = "+pi);
				break;
	
				case 80000:
					System.out.println("i = "+i+",pi = "+pi);
				break;
	
				case 90000:
					System.out.println("i = "+i+",pi = "+pi);
				break;
	
				case 100000:
					System.out.println("i = "+i+",pi = "+pi);
				break;
	
			}

				
								
		}	
	}
}