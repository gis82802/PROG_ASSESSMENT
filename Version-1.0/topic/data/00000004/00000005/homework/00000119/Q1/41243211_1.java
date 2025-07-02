import java.util.Scanner;//import Scanner head

public class app_1
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);// Create a scanner to read user input

		int x1=1,y1=2,x2=3,y2=4;// Initialize

		// Input
		System.out.print("point1 x:"); x1 = scanner.nextInt();
		System.out.print("point1 y:"); y1 = scanner.nextInt();
		System.out.print("point2 x:"); x2 = scanner.nextInt();
		System.out.print("point2 y:"); y2 = scanner.nextInt();

		float m=0;//slope

		// Calculate all need numbers and print it out
		if((x2-x1)!=0)
			m=(y2-y1)/(x2-x1);

		System.out.println("2 point function:F:"+"(y2-y1) = "+ m +"(x2-x1)");
		
		System.out.println("Euclidean distance:"+Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2)));
		
		System.out.println("Taxicab geometry:"+(Math.abs(x2-x1)+Math.abs(y2-y1)));
		
		float chess=(Math.abs(x2-x1) >= Math.abs(y2-y1))?Math.abs(x2-x1):Math.abs(y2-y1);
		System.out.println("Chebyshev distance"+chess);
		
		int a=(x1*x2 + y1*y2);
		double b=(Math.pow((x1+y1),2) * Math.pow((x2+y2),2));
		System.out.println("degree:"+Math.toDegrees(Math.acos(Math.toRadians(a/b))));


	}
}