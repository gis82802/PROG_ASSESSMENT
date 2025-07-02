public class PI
{
	public static void main(String args[])
	{
		int i,j,f=0,x;
		float pi=0,s=1;
		for(i=10000;i<=100000;i+=10000)
		{
			pi=0;
			if(f==0)
			{
				for(j=2;j<=i;j+=2)
				{
					s=s-((float)1/(2*j-1));
					s=s+((float)1/(2*j+1));
				}
				f=1;
			}
			else
			{
				for(j=i-9998;j<=i;j+=2)
				{
					s=s-((float)1/(2*j-1));
					s=s+((float)1/(2*j+1));
				}
			}
			pi=4*s;
			System.out.println(String.format("i=%d時，pi=%.5f", i, pi));
		}
		float goalpi=3.14159f;	//目標值
		float d=0.000001f;	//誤差範圍	
		i=100002;
		while(Math.abs(pi-goalpi)>d)
		{
			x=0;
			j=i;
			while(x==0)
			{
				s=s-((float)1/(2*j-1));
				s=s+((float)1/(2*j+1));
				x=1;
			}
			pi=4*s;	
			i+=2;
		}
		System.out.println(String.format("pi=%.5f時，i最小值=%d",pi,i));
	}
} 
