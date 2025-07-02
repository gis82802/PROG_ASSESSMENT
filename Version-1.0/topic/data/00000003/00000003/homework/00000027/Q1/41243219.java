import java.util.Scanner;

public class hw25a{

	public static int[][] MatMuluiply(int mt1[][], int mt2[][], int n1, int m1, int n2, int m2){
		if(m1 != n2)return null;
		int result[][] = new int[n1][m2];
		int tmp = 0;
		for(int i = 0; i < n1; i++){ //2
			for(int j = 0; j < m2; j++){ //2
				tmp = 0;

				for(int q = 0; q < n2; q++){
					tmp += mt1[i][q]*mt2[q][j];
				}
				
				result[i][j] = tmp;
			}
		}
		return result;
	}

	public static double[][] invMatrix(int mt[][]){
		
		double det = mt[0][0]*mt[1][1] - mt[0][1]*mt[1][0];
		if(det == 0)return null;
		double[][] inv = new double[2][2];
		inv[0][0] = mt[1][1] / det;
       	 	inv[0][1] = -mt[0][1] / det;
       		inv[1][0] = -mt[1][0] / det;
        	inv[1][1] = mt[0][0] / det;
		return inv;
	}

	public static void main(String args[]){
		int n, m;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Input Matrix1 n*m: ");
		n = sc.nextInt();
		m = sc.nextInt();
		int[][] mt1 = new int[n][m];
		int mt1_n = n, mt1_m = m, mt2_n, mt2_m;
		for(int i = 0; i < n ; i++)
			for(int j = 0; j < m; j++)
				mt1[i][j] = sc.nextInt();
		System.out.print("Input Matrix2 n*m: ");
		n = sc.nextInt();
		m = sc.nextInt();
		int[][] mt2 = new int[n][m];
		
		mt2_m = m;mt2_n = n;
		for(int i = 0; i < n ; i++)
			for(int j = 0; j < m; j++)
				mt2[i][j] = sc.nextInt();
		int result[][] = MatMuluiply(mt1, mt2, mt1_n, mt1_m, mt2_n, mt2_m);
		int mat[][] = new int[2][2];
		
		for(int i = 0; i < mt1_n; i++){
			for(int j = 0; j < mt2_m; j++){
				System.out.print(result[i][j] + " ");	
			}System.out.println();
		}
		System.out.println("Input 2*2 Matrix");
		for(int i = 0; i < 2; i++)for(int j = 0; j < 2; j++)mat[i][j] = sc.nextInt();
		double inv[][] = invMatrix(mat);
		if(inv != null)
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < 2; j++){
				System.out.print(inv[i][j] + " ");	
			}System.out.println();
		}
	}
}