import java.util.Scanner;//import Scanner head

public class app_3
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);// Create a scanner to read user input

		int a=9,b=6,c=3;// Initialize
		
		// Input
		System.out.print("a:"); a = scanner.nextInt();
		System.out.print("b:"); b = scanner.nextInt();
		System.out.print("c:"); c = scanner.nextInt();

		//many ternary operations
		char max=(a>b)?((a>c)?'a':((b>c)?'b':'c')):(((b>c)?'b':((a>c)?'a':'c')));
		System.out.println("max:"+max);

		char min=(a<b)?((a<c)?'a':((b<c)?'b':'c')):(((b<c)?'b':((a<c)?'a':'c')));
		System.out.println("min:"+min);

		char mid=(a>b)?((b>c)?'b':(a>c)?'c':'a'):((a>c)?'a':(b>c)?'c':'b');
		System.out.println("mid:"+mid);
	}
}