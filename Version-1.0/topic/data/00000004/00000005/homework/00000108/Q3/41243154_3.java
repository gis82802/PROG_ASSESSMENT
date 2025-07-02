import java.util.Scanner;
import java.lang.Math;

public class J_1004_1 {
	public  static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.print("a b c:");
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		
		System.out.println("\n===OUTPUT===");
		int max = (a>b)?a:b;
		max = (max>c)?max:c;
		int mix = (a<b)?a:b;
		mix = (mix<c)?mix:c;
		int mid =0;
		mid = (a!=max && a!=mix)?a:mid;
		mid = (b!=max && b!=mix)?b:mid;
		mid = (c!=max && c!=mix)?c:mid;
		System.out.println("max:"+max);
		System.out.println("mix:"+mix);
		System.out.println("mid:"+mid);
		
	}
}
