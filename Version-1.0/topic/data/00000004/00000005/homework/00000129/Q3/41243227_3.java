import java.util.Scanner;
import java.lang.Math;
public class wk3{

	public static void main(String args[]){
		int a,b,c,x,y,z;
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		x = (a>b)?a:b;    //找最大
		x = (x>c)?x:c;
		z = (a<b)?a:b;    //找最小
		z = (z<c)?z:c;
		y = (x==a)?b:a;   //確認是否最大
		y = (y==z)?c:a;   //確認是否最小
		System.out.println(x+ " "+y+" "+z);
		
	}
}