import java.util.Scanner;

public class hw10183 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("輸入矩陣大小 (n <= 4): ");
		int n=scanner.nextInt();
		int[][] m=new int[n][n];
		System.out.println("輸入矩陣內數值：");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				m[i][j]=scanner.nextInt();
			}
		}
		System.out.print("輸入i=");
		int i=scanner.nextInt();
		System.out.print("輸入j=");
		int j=scanner.nextInt();
		int[][] nm=new int[n - 1][n - 1];
		int r=0,c=0;
		for(int x=0;x<n;x++){
			if(x==i) continue;
			c=0;
			for(int y=0;y<n;y++){
				if(y==j) continue;
				nm[r][c]=m[x][y];
				c++;
			}
			r++;
		}
		System.out.println("刪除行列後陣列：");
		for(int x=0;x<n-1;x++){
			for(int y=0;y<n-1;y++){
				System.out.print(nm[x][y] + " ");
			}
			System.out.println();
		}
		int d=0;
		if(n-1==2){
			d=nm[0][0]*nm[1][1]-nm[0][1]*nm[1][0];
		}
		else if(n-1==3){
			d=nm[0][0]*(nm[1][1]*nm[2][2]-nm[1][2]*nm[2][1])-nm[0][1]*(nm[1][0]*nm[2][2]-nm[1][2]*nm[2][0])+nm[0][2]*(nm[1][0]*nm[2][1]-nm[1][1]*nm[2][0]);
		}
		else if(n-1==4){
			int aa=1;
			for(int x=0;x<4;x++){
				int[][] sm=new int[3][3];
				int srow=0;
				for(int y=1;y<4;y++){
					int scol=0;
					for(int z=0;z<4;z++){
						if(z == x) continue;
						sm[srow][scol]=nm[y][z];
						scol++;
					}
					srow++;
				}
			if(x%2==0) aa=1;
			else if(x%2!=0) aa=-1;
			d+=aa*nm[0][x]*(sm[0][0]*(sm[1][1]*sm[2][2]-sm[1][2]*sm[2][1])-sm[0][1]*(sm[1][0]*sm[2][2]-sm[1][2]*sm[2][0])+sm[0][2]*(sm[1][0]*sm[2][1]-sm[1][1]*sm[2][0]));
			}
		}
		System.out.println("行列式:"+d);
	}
}
