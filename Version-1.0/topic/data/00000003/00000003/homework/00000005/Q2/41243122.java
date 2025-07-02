import java.util.Scanner;
public class q10252{
    public static void main(String[] args) {
        System.out.println("輸入矩陣的四個數:");
        Scanner scr=new Scanner(System.in);
        double[] a=new double [4];
        for(int i=0;i<4;i++){
            a[i]=scr.nextDouble();
        }
        double d=1/(a[0]*a[3]-a[1]*a[2]);
        double[] b=new double[4];
        b[0]=a[3]*d;
        b[1]=-a[1]*d;
        b[2]=-a[2]*d;
        b[3]=a[0]*d;
        System.out.println("反矩陣:");
        for(int i=0;i<4;i++){
            System.out.print(b[i]+" ");
            if(i==1){
                System.out.println();
            }
    }
}
    

}