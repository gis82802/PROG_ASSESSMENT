import java.util.Scanner;

public class app
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int a,b,x,y;
		System.out.print("��JP1(�ΪŮ�j�}):");
		a=sc.nextInt();
		b=sc.nextInt();
		System.out.print("��JP2(�ΪŮ�j�}):");
		x=sc.nextInt();
		y=sc.nextInt();
		double sqrtab=Math.sqrt((double)Math.pow(a,2)+(double)Math.pow(b,2)),sqrtxy=Math.sqrt((double)Math.pow(x,2)+(double)Math.pow(y,2));

		//(1)
		System.out.println("(1)y="+((double)(b-y))/(a-x)+"x+"+(y-((double)(b-y))/(a-x)*x));
		//(2)
		System.out.println("�ڦ��Z���G"+Math.sqrt(Math.pow((double)a-x,2)+Math.pow((double)b-y,2)));
		System.out.println("�ҫ��y�Z���G"+(Math.abs(a-x)+Math.abs(b-y)));
		System.out.println("Minkoski�Z���G"+Math.sqrt(Math.pow(a-b,2)+Math.pow(x-y,2)));
		//(3)
		System.out.println("(3)arccos="+Math.toDegrees(Math.acos(((double)a*x+b*y)/(sqrtab*sqrtxy))));
	}
}