import java.util.Scanner;

public class Java10_25_1 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter rows and columns of first matrix: ");
        int rowsA = scanner.nextInt();
        int colsA = scanner.nextInt();
        int[][] A = new int[rowsA][colsA];
        
        System.out.println("Enter elements of first matrix:");
        for (int i = 0; i < rowsA; i++) 
        {
            for (int j = 0; j < colsA; j++) 
            {
                A[i][j] = scanner.nextInt();
            }
        }
        
        int[][] result = invMatrix(A);
        
        System.out.println("Result matrix:");
        for (int i = 0; i < result.length; i++) 
        {
            for (int j = 0; j < result[i].length; j++) 
            {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
    public static int[][] invMatrix(int[][] arrA) 
    {
        int rowsA = arrA.length;
        int colsA = arrA[0].length;

        int[][] arr = new int[rowsA][colsA];
        
        for (int i = 0; i < rowsA; i++) 
        {
            for (int j = 0; j < colsA; j++) 
            {
                arr[i][j] = arrA[j][i];
            }
        }
        return arr;
    }
}