import java.util.Scanner;
public class H45
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		long i=0,j=0,n=0,num=0,f=0;
		n=scanner.nextInt();
		while (n != 0)
		{
            		f = n%10;
            		num = num*10+f;
           		n/=10;
        	}
		System.out.printf("%d",num);	
	}
}