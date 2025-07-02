import java.util.Scanner;

public class J_1018_03 {
	public static void displayMatrix(int matrix[][]){
		System.out.println();
		if(matrix == null){
			System.out.println("null");
			return;
		}
		for(int row[] : matrix){
			for(int value : row){
				System.out.printf("%4d ",value);
			}
			System.out.println();
		}
	}
	
	public static int[][] MatMultiply(int a[][], int b[][], int an,int am,int bn,int bm){
		if(am != bn) return null;
		
		int ans[][] = new int[an][bm];
		for(int i=0;i<an;i++){
			for(int j=0;j<bm;j++){
				ans[i][j] = 0;
				for(int k=0;k<am;k++){
					ans[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return ans;
	}
	
	public static int[][] invMatrix(int matrix[][]){
		if(matrix.length != 2 || matrix.length != 2){
			System.out.println("error in invMatrix.");
			return null;
		}
		
		int a = matrix[0][0]; int b = matrix[0][1];
		int c = matrix[1][0]; int d = matrix[1][1];
		int det = (a*d) - (b*c);
		
		if(det == 0){
			System.out.println("This matrix not have inverse matrix.");
			return null;
		}
		int inv[][] = {
			{d / det, -b / det},
			{-c / det, a / det}
		};
		return inv;
	}
	
	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		System.out.print("input matrixA size (n m):");
		int An = sn.nextInt();
		int Am = sn.nextInt();
		System.out.print("input matrixB size (n m):");
		int Bn = sn.nextInt();
		int Bm = sn.nextInt();
		//System.out.println("A:"+An+" "+Am+" B:"+Bn+" "+Bm);
		int mA[][] = new int[An][Am];
		int mB[][] = new int[Bn][Bm];
		System.out.print("input matrixA:");
		for(int i=0;i<An;i++){
			for(int j=0;j<Am;j++){
				mA[i][j] = sn.nextInt();
			}
		}
		System.out.print("input matrixB:");
		for(int i=0;i<Bn;i++){
			for(int j=0;j<Bm;j++){
				mB[i][j] = sn.nextInt();
			}
		}
		sn.close();
		
		//(a)
		int result[][] = MatMultiply(mA,mB,An,Am,Bn,Bm);
		displayMatrix(result);
		
		//(b)
		if(An == 2 && Am == 2){
			int invA[][] = invMatrix(mA);
			System.out.println("\nmatrixA's invMatrix:");
			displayMatrix(invA);
			
			System.out.println("\nCheck calculation:");
			int check[][] = MatMultiply(mA, invA, 2, 2, 2, 2);
			displayMatrix(check);
			
		}
		
		
		/* print matrixA and matrixB.
		for(int i=0;i<An;i++){
			for(int j=0;j<Am;j++){
				System.out.print(mA[i][j]);
				if(j+1 < Am)System.out.print(" ");
			}
			System.out.print("\n");
		}
		for(int i=0;i<Bn;i++){
			for(int j=0;j<Bm;j++){
				System.out.print(mB[i][j]);
				if(j+1 < Bm)System.out.print(" ");
			}
			System.out.print("\n");
		}*/
	}
}
