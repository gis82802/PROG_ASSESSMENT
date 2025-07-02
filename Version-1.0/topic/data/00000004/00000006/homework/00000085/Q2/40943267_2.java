public class app5_H4
{
	public static void main(String args[])
	{
		long i=0,j=0,n=0,u=0,v=0,w=0,x=0,y=0,z=0;
		for(i=1;i<100000;i++)
		{	
			u=i/100000;
			v=i/10000;
			w=i/1000;
			x=i/100;
			y=(i%100)/10;
			z=i%10;
			if(u<=v&&v<=w&&w<=x&&x<=y&&y<=z)
			{
				n++;
			}
		}
		System.out.printf("There are %4d well-ordered numbers for integers less than 100000",n);	
	}
}