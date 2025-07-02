import java.util.Scanner;
public class hw4{
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        int n,ans=0;
        int row,col;
        int arr[][],arr1[][];
        int sum[];
        System.out.printf("請輸入矩陣的大小 (n):");
        n=sc.nextInt();
        arr=new int[n][n];
        arr1=new int[n-1][2*n-3];
        sum=new int[2*n];

        // 初始化 sum 陣列
        for(int i=0;i<2*n;i++)sum[i]=1;   
       
        // 讀取矩陣
        System.out.println("請輸入矩陣的元素:");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        // 輸出原始矩陣
        System.out.println("原始矩陣:");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf("%d ",arr[i][j]);
            }
            System.out.printf("\n");
        }

        // 輸入要刪除的行和列
        int a=0,b=0;
        System.out.print("請輸入要刪除的行和列: ");
        row=sc.nextInt();
        col=sc.nextInt();

        // 處理矩陣
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=row&&j!=col){
                    System.out.printf("%d ",arr[i][j]);
                    arr1[a][b]=arr[i][j]; 
                    arr1[a][2*n-4-b]=arr[i][j]; 
                    if(b==n-2){
                        a++;
                        b=0;
                    }
                    else b++;
                }
            }
            if(i!=row) System.out.printf("\n");
        }

        if(n-1==3){
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    arr1[i][j+3]=arr1[i][j];
                }
            }
            // 計算乘積總和
            for(int i=0;i<n-1;i++){
                for(int j=0;j<2*n-3;j++){
                    if(j-i<=n-2&&j>=i){
                        sum[j-i]*=arr1[i][j];
                    }
                    if(j+i>=n-2){
                        sum[i+j+1]*=arr1[i][j];
                    }
                } 
            }

            // 計算最終結果
            for(int i=0;i<6;i++){
                if(i<3) ans+=sum[i];
                 else ans-=sum[i];
            }
        }
	else if(n-1==2){
            for(int i=0;i<n-1;i++){
                for(int j=0;j<n-1;j++){
                    if(i==j){
                        sum[0]*=arr1[i][j];
                    }
                    else if(j+i==1){
                        sum[1]*=arr1[i][j];
                    }
                } 
            }
            // 計算最終結果
            ans=sum[0]-sum[1];
        }
	else if(n-1==1) ans=arr1[0][0];


        // 輸出最終結果
        System.out.printf("最終結果: %d", ans);
    } 

}
    