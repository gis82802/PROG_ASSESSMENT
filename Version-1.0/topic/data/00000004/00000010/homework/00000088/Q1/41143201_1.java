import java.util.Scanner;
public class matMultiply {
    //矩陣相乘
    public static double[][] multiply(double[][] mat1, double[][] mat2) {
        int rows1 = mat1.length;
        int cols1 = mat1[0].length;
        int rows2 = mat2.length;
        int cols2 = mat2[0].length;

        if (cols1 != rows2) {
            System.out.println("error");
            return null;
        }

        double[][] result = new double[rows1][cols2];

        // 矩陣相乘運算
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }

        return result;
    }
    //反矩陣
    public static double[][] inv(double[][]arr){
        double num;
        double det=1.0D/(arr[0][0]*arr[1][1]-arr[0][1]*arr[1][0]);
        if(det==0){
            System.out.println("error");
            return null;
        }
        num=arr[0][0];
        arr[0][0]=arr[1][1]*det;
        arr[1][1]=num*det;
        num=arr[0][1];
        arr[0][1]=arr[1][0]*-1*det;
        arr[1][0]=num*-1*det;
        return arr;
    }
    public static void main(String args[]){

        //反矩陣
        double[][] a={{2,3},{4,5}};
        double[][] b=inv(a);
        System.out.println("反矩陣結果:");
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                System.out.print(b[i][j]+"  ");
            }
            System.out.println("\n");
        }
        //矩陣相乘
        double[][] c = multiply(a, b);
        if (c != null) {
            System.out.println("矩陣相乘結果:");
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c[0].length; j++) {
                    System.out.print(c[i][j] + "  ");
                }
                System.out.println("\n");
            }
        }
    }
}
