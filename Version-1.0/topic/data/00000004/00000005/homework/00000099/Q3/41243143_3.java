import java.util.Scanner;

public class app2
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int a,b,c;
		System.out.print("��J�T��a�Bb�Bc(�Ů�j�})�G");
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();

		System.out.println("�̤j�ȡG"+((((a>b)? a:b) > c)? ((a>b)? a:b):c));
		System.out.println("�����ȡG"+((((a>b)? a:b) < c)? ((a>b)? a:b):c));
		System.out.println("�̤p�ȡG"+((((a<b)? a:b) < c)? ((a<b)? a:b):c));
	}
}