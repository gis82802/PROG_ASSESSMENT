import java.util.Scanner;

public class Java10_25_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter rows and columns of first matrix: ");
        int rowsA = scanner.nextInt();
        int colsA = scanner.nextInt();
        int[][] A = new int[rowsA][colsA];
        
        System.out.println("Enter elements of first matrix:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                A[i][j] = scanner.nextInt();
            }
        }
       
        System.out.print("Enter rows and columns of second matrix: ");
        int rowsB = scanner.nextInt();
        int colsB = scanner.nextInt();
        
        if (colsA != rowsB) {
            System.out.println("Matrix multiplication is not possible.");
            return;
        }
        
        int[][] B = new int[rowsB][colsB];
        System.out.println("Enter elements of second matrix:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                B[i][j] = scanner.nextInt();
            }
        }
        
        int[][] result = MatMultiply(A, B);
        
        System.out.println("Result matrix:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }

    public static int[][] MatMultiply(int[][] arrA, int[][] arrB) {
        int rowsA = arrA.length;
        int colsB = arrB[0].length;
        int colsA = arrA[0].length;

        int[][] arr = new int[rowsA][colsB];
        
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    arr[i][j] += arrA[i][k] * arrB[k][j];
                }
            }
        }
        return arr;
    }
}
