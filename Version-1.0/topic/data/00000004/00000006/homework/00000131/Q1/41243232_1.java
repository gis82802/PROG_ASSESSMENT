/*
filename:hw1011
funtion:π
author:41243232
date:2024/10/11
version:jdk23
*/
public class hw1011{

	public static void main(String[] args){
	double dPi =0;
	int iApp = 0;
	for(int i=1;i<100001;i++)
	{
		if (i % 2 == 0) 
		{
                	dPi -= 4.0f / (2 * i - 1); 
            	}
 		else
 		{
               		dPi += 4.0f / (2 * i - 1);    
         	}
		if(i%10000==0 && i!=100000)
		{
			System.out.println("i =  " + i + ", pi = " + dPi);
		}
		else if(i==100000)
		{
			System.out.println("i = " + i + ", pi = " + dPi);

		}
		
		if (Math.abs(dPi - 3.141590) < 0.00001 && iApp == 0) 
		{
	                iApp = i;  
            	}
	}
	System.out.println("pi = 3.14159,i = " + iApp);

}
}