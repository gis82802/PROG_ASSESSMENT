import java.util.Scanner;
public class Hw3_1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int row,col;
        System.out.printf("請輸入A矩陣大小:");
        row=sc.nextInt();
        col=sc.nextInt();
        int[][] a=new int[row][col];
        System.out.printf("請輸入A矩陣內容:");
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                a[i][j]=sc.nextInt();
            }
        }
        System.out.printf("請輸入B矩陣大小:");
        row=sc.nextInt();
        col=sc.nextInt();
        int[][] b=new int[row][col];
        System.out.printf("請輸入B矩陣內容:");
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[i].length;j++){
                b[i][j]=sc.nextInt();
            }
        }

        int[][] Mult;
        Mult=MatMultiply(a,b);
        if(Mult!=null){
            for(int i=0;i<Mult.length;i++){
                for(int j=0;j<Mult.length;j++){
                    System.out.printf("%2d ",Mult[i][j]);
                }
                System.out.printf("\n");
            }
        }
        else
        System.out.printf("矩陣無法相乘\n");
        float[][] c=new float[2][2];
        System.out.printf("請輸入inv矩陣內容:");
        for(int i=0;i<c.length;i++){
            for(int j=0;j<c[i].length;j++){
                c[i][j]=sc.nextFloat();
            }
        }

        float[][] inv;
        float[][] UMatrix;
        inv=invMatrix(c);
        UMatrix=MatMultiply(inv,c);
        System.out.printf("反矩陣\n");
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                System.out.printf("%.2f ",inv[i][j]);
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
        System.out.printf("單位矩陣\n");
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                System.out.printf("%.2f ",UMatrix[i][j]);
            }
            System.out.printf("\n");
        }
    }

    public static int[][] MatMultiply(int[][] a,int[][] b){
        int[][] c=new int[a.length][b[0].length];
        if(a[0].length!=b.length)
            return null;
        else{
            for(int i=0;i<a.length;i++){
                for(int j=0;j<b.length;j++){
                    c[i][j]=0;
                    for(int k=0;k<b.length;k++){
                        c[i][j]=c[i][j]+a[i][k]*b[k][j];
                    }
                }
            }
            return c;
        } 
    }

    public static float[][] MatMultiply(float[][] a,float[][] b){
        float[][] c=new float[a.length][b[0].length];
        if(a[0].length!=b.length)
            return null;
        else{
            for(int i=0;i<a.length;i++){
                for(int j=0;j<b.length;j++){
                    c[i][j]=0;
                    for(int k=0;k<b.length;k++){
                        c[i][j]=c[i][j]+a[i][k]*b[k][j];
                    }
                }
            }
            return c;
        } 
    }

    public static float[][] invMatrix(float[][] a){
        float[][] b=new float[2][2];
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                   b[i][j]=(1/(a[0][0]*a[1][1]-a[0][1]*a[1][0]))*a[i][j];
            }
        }
        float t;
        t=b[0][0];
        b[0][0]=b[1][1];
        b[1][1]=t;
        b[1][0]*=(-1);
        b[0][1]*=(-1);
        return b;
    }
}