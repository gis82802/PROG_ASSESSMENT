import java.util.Scanner;
public class hw5{
	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);

		double A,B,C,max,min,middle;

		System.out.println("請輸入數字A:");
		A = sc.nextDouble();
		System.out.println("請輸入數字B:");
		B = sc.nextDouble();
		System.out.println("請輸入數字C:");
		C = sc.nextDouble();

		max = Math.max(A, Math.max(B,C));
		min = Math.min(A, Math.min(B,C));
		middle = (A + B + C) - max - min;

		System.out.println("max = " + max);
        	System.out.println("min = " + min);
        	System.out.println("middle = " + middle);
	}
}