import java.util.Scanner;
public class hw4{
	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);

		double A,B,C,x,y,d;

		// 輸入直線方程的係數 A, B, C
        	System.out.println("請輸入直線方程的係數 (Ax + By + C = 0)：");
        	System.out.print("A: ");
        	A = sc.nextDouble();
        	System.out.print("B: ");
        	B = sc.nextDouble();
        	System.out.print("C: ");
        	C = sc.nextDouble();

        	// 輸入點的座標
        	System.out.println("請輸入點的座標：");
        	System.out.print("x: ");
        	x = sc.nextDouble();
        	System.out.print("y: ");
        	y = sc.nextDouble();

		//計算點到直線的距離 => d=|A*x+B*y+c|/√(A^2+B^2)
		d=(Math.abs(A*x+B*y+C))/(Math.sqrt(A*A+B*B));
		System.out.println("點("+x+","+y+")到直線的距離為: "+d);
	}
}