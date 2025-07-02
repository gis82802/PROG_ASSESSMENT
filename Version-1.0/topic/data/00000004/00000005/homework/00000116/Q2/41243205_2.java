import java.util.Scanner;
public class ex3{
	public static void main(String args[]){
		//取得使用者輸入
		Scanner sc = new Scanner(System.in);
		int A, B, C, x, y;
		System.out.printf("計算點到直線的距離\n");
		System.out.printf("直線方程式Ax + By + C = 0\n");
		System.out.printf("輸入係數A: ");
		A = sc.nextInt();
		System.out.printf("輸入係數B: ");
		B = sc.nextInt();
		System.out.printf("輸入係數C: ");
		C = sc.nextInt();
		System.out.printf("點(x,y)\n");
		System.out.printf("輸入點x: ");
		x = sc.nextInt();
		System.out.printf("輸入點y: ");
		y = sc.nextInt();
		// 使用公式計算距離
		double distance = Math.abs(A * x + B * y + C) / Math.sqrt(A * A + B * B);
		System.out.printf("點到直線的距離: %.2f", distance);
	}
}
