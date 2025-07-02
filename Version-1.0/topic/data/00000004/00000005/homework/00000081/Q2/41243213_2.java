import java.util.Scanner;//import Scanner head

public class app_2
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);// Create a scanner to read user input

		int x=1,y=2,a=3,b=4,c=5;// Initialize
		System.out.println("P(x,y)     L:ax+b+c"); 

		// Input
		System.out.print("point x:"); x = scanner.nextInt();
		System.out.print("point y:"); y = scanner.nextInt();

		System.out.print("line a:"); a = scanner.nextInt();
		System.out.print("line b:"); b = scanner.nextInt();
		System.out.print("line c:"); c = scanner.nextInt();

		// Calculate and print it out
		System.out.println("distance between piont to line :" + Math.abs(a*x+b*y+c)/Math.sqrt(Math.pow(a,2)+Math.pow(b,2)));
		
	}
}