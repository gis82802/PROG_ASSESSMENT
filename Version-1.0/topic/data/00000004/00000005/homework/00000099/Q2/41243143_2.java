import java.util.Scanner;

public class app1
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int a,b,A,B,C;
		System.out.print("輸入點座標(用空格隔開):");
		a=sc.nextInt();
		b=sc.nextInt();
		System.out.print("輸入線座標(Ax+By+C,輸入A、B、C)：");
		A=sc.nextInt();
		B=sc.nextInt();
		C=sc.nextInt();
		
		System.out.println("點到線距離："+Math.abs((double)A*a+B*b+C)/(Math.sqrt((double)Math.pow(a,2)+(double)Math.pow(b,2))));
	}
}