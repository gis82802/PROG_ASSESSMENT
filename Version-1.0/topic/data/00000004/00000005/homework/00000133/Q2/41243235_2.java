import java.lang.Math;
import java.util.Scanner;
public class test2{

    public static void main(String[] args){
        int[] line1= new int[2];
        int[] line2= new int[2];
        int[] pt = new int[2];
        Scanner s = new Scanner(System.in);
        System.out.println("輸入直線兩點座標");
        for(int i=0;i<2;i++){
			line1[i]=s.nextInt();
		}
        for(int i=0;i<2;i++){
			line2[i]=s.nextInt();
		}
        System.out.println("輸入二維點座標");
        for(int i=0;i<2;i++){
			pt[i]=s.nextInt();
		}

        double dot_line = distance(line1,line2,pt);
        System.out.println("點到直線距離為: "+dot_line);
    }
    public static double distance(int[] a, int[] b, int[] c){
        double x = a[0]-b[0];
        double y = b[1]-a[1];
        double h = b[0]*a[1] - a[0]*b[1];
        double ans = Math.abs(x*c[0] + y*c[1]+h)/Math.sqrt(x*x + y*y);
        return ans;
    }

}