import java.util.Scanner;

public class hw1018_4
{
	public static void main(String args[])
	{
		Scanner scn=new Scanner(System.in);

		System.out.print("輸入n*n矩陣,n值:");
		int n=scn.nextInt();
		
		if(n<5&&n>0)
		{
			int[][] m=new int[n][n];

			System.out.println("輸入矩陣內容:");
			for(int a=0;a<n;a++)
			{
				for(int b=0;b<n;b++)
					m[a][b]=scn.nextInt();
			}
			System.out.println("矩陣內容為:");
			for(int a=0;a<n;a++)
			{
				for(int b=0;b<n;b++)
					System.out.print(m[a][b]+" ");
				System.out.println();
			}


			System.out.println("輸入要刪除的第i行、第j列, (i,j):");
			int i=scn.nextInt()-1;
			int j=scn.nextInt()-1;
	
			int[][] mD=new int[n-1][n-1];
			for(int a=0,ni=0;a<n;a++)
			{
				if(a==i) continue;
				for(int b=0,nj=0;b<n;b++)
				{
					if(b==j)continue;
					mD[ni][nj]=m[a][b];
					nj++;
				}
				ni++;
			}

			System.out.println("輸入刪除後矩陣內容:");
			for(int a=0;a<n-1;a++)
			{
				for(int b=0;b<n-1;b++)
					System.out.print(mD[a][b]+" ");
				System.out.println();
			}

			int d=0;
			
			if((n-1)==1)
			{
				d=mD[0][0];
			}
			else if((n-1)==2)
			{
				d=mD[0][0]*mD[1][1]-mD[0][1]*mD[1][0];
			}
			else if((n-1)==3)
			{
				d= mD[0][0]*mD[1][1]*mD[2][2]+mD[0][1]*mD[1][2]*mD[2][0]+mD[0][2]*mD[1][0]*mD[2][1]
				  -mD[0][2]*mD[1][1]*mD[2][0]-mD[0][1]*mD[1][0]*mD[2][2]-mD[0][0]*mD[2][1]*mD[1][2];
			}
			System.out.println("行列式d值:"+d);
		}
		else
		{
			System.out.println("輸入錯誤,n範圍為n<=4");
		}
	}
}