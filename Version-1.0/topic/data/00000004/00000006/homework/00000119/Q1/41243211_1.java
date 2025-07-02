public class app_1_2
{
	public static void main(String[] args)
	{
		double pi=0;
		int j=10000;
		for(;;)//do not know what time stop
		{
			pi=0;
			for(int i=0;i<j;i++)
				pi+=(Math.pow(-1,i))/(2*i+1);//pi function
			System.out.println("i="+j+" ,PI="+4*pi);
			if (pi>(3.14159/4)) 
               			break; //stop

			if(pi<(3.1415899/4))//run fast
				j+=10000;
			else
				j+=2;
            
		}
		System.out.println("i="+j);//out
	}
		
}