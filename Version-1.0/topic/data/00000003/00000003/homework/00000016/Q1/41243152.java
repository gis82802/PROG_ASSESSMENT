import java.util.Scanner;
class hw10253{
	public static int[][] A(int[][] A, int[][] B,int m,int n,int p){
		int[][] matrix = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				matrix[i][j]=0;
			}
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				for(int x=0;x<p;x++){
					matrix[i][j]+=A[i][x]*B[x][j];
				}
			}
		}
		return matrix;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int m, n, m1, n1;
		System.out.print("請輸入矩陣1大小(mxn)：");
		m = sc.nextInt();
		n = sc.nextInt();
		int[][] matrix1 = new int[m][n];
		System.out.println("請輸入矩陣數值：");
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print("Matrix["+i+"]["+j+"]=");
				matrix1[i][j] = sc.nextInt();
			}
		}
		System.out.print("請輸入矩陣2大小(mxn)：");
		m1 = sc.nextInt();
		n1 = sc.nextInt();
		int[][] matrix2 = new int[m1][n1];
		System.out.println("請輸入矩陣數值：");
		for(int i=0;i<m1;i++){
			for(int j=0;j<n1;j++){
				System.out.print("Matrix["+i+"]["+j+"]=");
				matrix2[i][j] = sc.nextInt();
			}
		}
		if(n!=m1) System.out.println("null");
		else{
			int[][] matrix = A(matrix1,matrix2,m,n1,n);
			for(int i=0;i<m;i++){
				for(int j=0;j<n1;j++){
					System.out.print(matrix[i][j]);
					System.out.print(" ");
				}
				System.out.println(" ");
			}
		}
	}
}