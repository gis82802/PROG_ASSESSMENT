import java.util.Scanner;

public class hw3{
	public static void main(String args[]){
		Scanner sca =new Scanner(System.in);
		int n0,n,n1=0;;
		int i,j,t;
		n = sca.nextInt();
		do{                      //先把後面的0去掉
			if(n%10==0)
			n=n/10;
			}while(n%10==0); 
		int L=String.valueOf(n).length();   //輸入的大小
		for(i=1;i<=L;i++)
		{
			n0=n;
			t=1;
			for(j=i;j<L;j++)           //找到最大數並提出
				{
					t=t*10;
				}
			n0=n/t;			//紀錄提出的最大數
			n=n-n0*t;		//去掉最大數
			t=1;
			for(j=1;j<i;j++)	//把最大數改為最小
				{
					t=t*10;
				}

			n1=n1+n0*t;		//紀錄
			
		}
		System.out.println(n1); 
	}
}