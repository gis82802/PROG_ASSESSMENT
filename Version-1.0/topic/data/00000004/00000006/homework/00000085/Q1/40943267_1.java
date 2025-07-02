public class app5_H1
{
	public static void main(String args[])
	{
		int i,j;
		double suma=0,sumb=0,a=0,b=0;
		for(i=0;i<1;i++)
		{
			for(j=2;j<100000;j+=2)
			{
				a=(1.0/(2*j-1));
				b=(1.0/(2*j+1));
				sumb+=-a+b;
			}
			suma=4*(1+sumb);
			System.out.printf("%f",suma);
		}
		
	}
}