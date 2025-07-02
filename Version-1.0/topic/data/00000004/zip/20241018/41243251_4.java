import java.util.Scanner;

public class hw4_1018 {
    public static void main(String[] args){
	Scanner scn=new Scanner(System.in);
	int n,a,b,sum=0,mult;
     	do{
	    System.out.print("輸入矩陣大小 : ");
	    n = scn.nextInt();
	    if(n>4||n<0)
	      System.out.println("重新輸入");
	}while(n>4||n<0);
	int num1[][] = new int [n][n];		//存取初始陣列
	int num2[][] = new int [n-1][n-1];	//存取刪減行列後的陣列
	System.out.println("輸入陣列內容 :");
	for(int i=0;i<n;i++){
	   for(int j=0;j<n;j++)
 	      num1[i][j]=scn.nextInt();
	}
	System.out.println("初始陣列內容 :");
 	for(int i=0;i<n;i++){
	   for(int j=0;j<n;j++)
 	      System.out.print(num1[i][j]+", ");
	   System.out.print("\n");
	}
	do{
	    System.out.print("去除哪一行(輸入數字1到"+n+"): ");
	    a = scn.nextInt();
	    System.out.print("去除哪一列(輸入數字1到"+n+"): ");
	    b = scn.nextInt();
	    if((n<a||a<0)||(n<b||n<0))
	      System.out.println("重新輸入");
	}while((n<a||a<0)||(n<b||n<0));

					/*存入去除後的陣列數值*/
	for(int i=0;i<n-1;i++){
	   int ix = i;
	   int iy = 0;
	   for(int j=0;j<n-1;j++){
	      if(ix==a-1)
		ix++;
	      if(iy==b-1)
		iy++;
		num2[i][j]=num1[ix][iy++];
	   }
	 
	}

					/*輸出去除後的陣列*/
	System.out.println("目前陣列內容 :");
	for(int i=0;i<n-1;i++){
	   for(int j=0;j<n-1;j++)
 	      System.out.print(num2[i][j]+", ");
	   System.out.print("\n");
	}


	if((n-1)>2){
					/*計算行列式正的部分*/
	    for(int i=0;i<n-1;i++){
	       int ix = i;
	       mult=1;
	       for(int j=0;j<n-1;){
	          for(int k=0;k<n-1;k++){
		      mult*=num2[j++][ix++];
		      if(ix>=n-1){
		        ix=0;
		      }
	          }	
	       }
	       sum+=mult;
	    }

					/*計算行列式負的部分*/
	    for(int i=0;i<n-1;i++){
	       int ix = i;
	       mult=1;
	       for(int j=0;j<n-1;){
	          for(int k=0;k<n-1;k++){
		      mult*=num2[j++][ix--];
		      if(ix<0){
		        ix=n-2;
		      }
	          }	 
	       }
	       sum-=mult;
	    }
	}
	if((n-1)==2){
	    sum=num2[0][0]*num2[1][1]-num2[0][1]*num2[1][0];
	}
	if((n-1)==1){
	    sum=num2[0][0];
	}
	System.out.println("行列式答案 : "+sum);

    }
}
