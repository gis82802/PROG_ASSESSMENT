import java.util.Scanner;

public class app1
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int a,b,A,B,C;
		System.out.print("��J�I�y��(�ΪŮ�j�}):");
		a=sc.nextInt();
		b=sc.nextInt();
		System.out.print("��J�u�y��(Ax+By+C,��JA�BB�BC)�G");
		A=sc.nextInt();
		B=sc.nextInt();
		C=sc.nextInt();
		
		System.out.println("�I��u�Z���G"+Math.abs((double)A*a+B*b+C)/(Math.sqrt((double)Math.pow(a,2)+(double)Math.pow(b,2))));
	}
}