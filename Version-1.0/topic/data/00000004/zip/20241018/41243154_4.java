import java.util.Scanner;

public class J_1018_04 {
	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		System.out.print("input array[n*n] size(n)(1~4):");
		int n = sn.nextInt();
		int array[][] = new int[n][n];
		
		System.out.print(":");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				array[i][j] = sn.nextInt();
			}
		}
		
		System.out.println("");
		System.out.println("=====print=====");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.printf("%3d",array[i][j]);
				if(j+1 < n)System.out.print(" ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		
		System.out.print("del coord(i j):");
		int x = sn.nextInt();
		int y = sn.nextInt();
		sn.close();
		int ans[][] = new int[n][];
		for(int i=0;i<n;i++){
			if(i == x)ans[i] = new int[n-1];
			else      ans[i] = new int[n];
		}
		
		System.out.println("=====print=====");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i==x && j>=y){
					if(j+1 == n)continue;
					ans[i][j] = array[i][j+1];
				}
				else ans[i][j] = array[i][j];
				System.out.printf("%3d",ans[i][j]);
				if(j+1 < n)System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
}
