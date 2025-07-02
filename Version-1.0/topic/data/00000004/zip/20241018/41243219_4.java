import java.util.Arrays;
import java.util.Scanner;
public class hw184{

    public static int[][] del(int r, int c, int n, int arr[][], boolean mark[][]){
        int mat[][] = new int [n - 1][n - 1];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == r || j == c){
                    mark[i][j] = true;
                }
            }
        }

        int k = 0, l = 0;
        for(int i = 0; i < n && k < n - 1; i++){
            for(int j = 0; j < n; j++){
                if(!mark[i][j]){
                    mat[k][l++] = arr[i][j];
                    if(l == n - 1){l = 0; k++;}
                }
            }
        }
        return mat;
    }

    public static void print(int matrix[][], int n){
        int tmp = 0, sumA = 0, sumB = 0;

        for(int i = 0, j = 0; j < n; j++){
            int t = 0, x = i, y = j; tmp = 0;

            while(t < n){
                if(t == 0){
                    ++t;
                    tmp = matrix[x][y];
                    continue;
                }
                ++t;
                --x; --y;
                if(x < 0)x = n - 1;
                if(y < 0)y = n - 1;
                tmp *= matrix[x][y];
            }
            sumA += tmp;
        }
        //System.out.println("A");
        //System.out.println(sumA);

        for(int i = 0, j = 0; j < n; j++){
            int t = 0, x = i, y = j; tmp = 0;

            while(t < n){
                if(t == 0){
                    ++t;
                    tmp = matrix[x][y];
                    continue;
                }
                ++t;
                --x; ++y;
                if(x < 0)x = n - 1;
                if(y >= n)y = 0;
                tmp *= matrix[x][y];
            }
            sumB += tmp;
        }
        //System.out.println("B");
        //System.out.println(sumB);
        System.out.print(n + " * " + n + " Determinant: ");
        System.out.println(sumA - sumB);
    }

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input Matrix Size: ");
        int size = sc.nextInt();
        int matrix[][] = new int[size][size];
        boolean mark[][] = new boolean[size][size];
        
        System.out.println("Input Matrix " + size + " * " + size + ":");
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                matrix[i][j] = sc.nextInt();
                mark[i][j] = false;
            }
        }

        System.out.println("Print Matrix " + size + " * " + size + ":");
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        
        int r, c, t = 0;
        int tmpmatrix[][] = matrix;

        while(t < size){
            System.out.println("Input R and C to delete No.R rows and No.C rows");
            System.out.println("Input R :");
            r = sc.nextInt() - 1;
            System.out.println("Input C :");
            c = sc.nextInt() - 1;
            if(r < 0 || r >= size - t|| c < 0 || c >= size - t){
                System.out.println("Out of Range!!!");
                continue;
            }
            boolean tmpmark[][] = new boolean[size - t][size - t];


            for(int i = 0; i < size - t; i++){
                for(int j = 0; j < size - t; j++){
                    tmpmark[i][j] = false;
                }
            }


            int[][] mat = del(r, c, size - t, tmpmatrix, tmpmark); //matrix, mark error;
            tmpmatrix = mat;
            ++t;

            System.out.println("New Matrix: ");
            for(int i = 0; i < size - t; i++){
                for(int j = 0; j < size - t; j++){
                    System.out.print(tmpmatrix[i][j] + " ");
                }System.out.println();
            }

            if(size - t > 2)
                print(mat, size - t); //determine
            else{
                if(size - t == 0){
                    System.out.println("Empty!");
                }
                else if(size - t == 1){
                    System.out.print((size - t) + " * " + (size - t) + " Determinant: ");
                    System.out.println(mat[0][0]);
                }
                else{
                    System.out.print((size - t) + " * " + (size - t) + " Determinant: ");
                    System.out.println(mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0]);
                }
            }
        }
    }
}