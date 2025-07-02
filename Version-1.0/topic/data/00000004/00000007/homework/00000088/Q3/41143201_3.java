import java.util.Scanner;
public class trangleArray {
    public static void main(String args[]){
        Scanner snc=new Scanner(System.in);
        System.out.println("輸入三角形高度(0~20)");
        int n=snc.nextInt();
//a
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
//b
       
        System.out.println("輸入尋找數字(0~100000)");
        int a=snc.nextInt();
        int[][] triangle=new int[447][];//因為<100000的最小陣列高度為447
        boolean ans=false;
        int num=1;
        for(int i=0;i<100;i++){
            triangle[i]=new int[i+1];
            for(int j=0;j<=i;j++){
                triangle[i][j]=num;
                if(num==a){
                    System.out.println(a+"現在位置為:"+i+" "+j);
                    ans=true;
                }
                num++;
            }
        }
        if(ans=false){
            System.out.println("未找到該數字位置");
        }

    }
    }

