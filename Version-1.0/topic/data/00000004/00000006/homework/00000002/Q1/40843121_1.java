public class H41
{
	public static void main(String args[])
	{
		int x,y;
		double suma = 0,sumb = 0,a = 0,b = 0;
		for(x=0; x<1; x++)
		{
			for(y=2; y<100000; y+=2)
			{
				a=(1.0/(2*y-1));
				b=(1.0/(2*y+1));
				sumb += -a+b;
			}
			suma = 4*(1+sumb);
			System.out.printf("%f",suma);
		}
		
	}
}