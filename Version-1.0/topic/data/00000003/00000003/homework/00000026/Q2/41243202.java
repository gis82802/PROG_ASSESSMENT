/*
	資工二乙	41243202	林沛慧
	功能：輸出反矩陣
*/
import java.util.Scanner;
public class hw3_b
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int [][] a = new int [2][2];
		double [][] b;
		System.out.print("請輸入一個2*2二維矩陣的內容：");
		for(int i = 0 ; i < 2 ; i++)
			for(int j = 0 ; j < 2 ; j++)
				a[i][j] = sc.nextInt();
		b = invmatrix(a);
		System.out.println("此矩陣的逆矩陣是：");
           	for (int i = 0; i < 2; i++){ 
                	for (int j = 0; j < 2; j++) 
                    		System.out.printf("%.2f ",b[i][j]);
                	System.out.println();
		}
	}
	public static double [][] invmatrix(int a[][])
	{
		int a1 = a[0][0];
		int a2 = a[0][1];
		int a3 = a[1][0];
		int a4 = a[1][1];
		int s = a1 * a4 - a2 * a3;
		double [][] aa = new double [2][2];
		aa[0][0] = (double)a4/s;
		aa[0][1] = (double)-a2/s;
		aa[1][0] = (double)-a3/s;
		aa[1][1] = (double)a1/s;

		return aa;
	}
}