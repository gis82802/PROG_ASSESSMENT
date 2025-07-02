public class app3_a {
    public static void main(String args[]) {
        int a[][] = {{1, 2}, {3, 4}};
        int c[][];

        System.out.println("矩陣 A:");
        printMatrix(a);
        
        c = InverseMultiply(a);
        System.out.println("矩陣 C (A 的逆):");
        printMatrix(c);
    }

    public static int[][] InverseMultiply(int a[][]) {
        int determinant = a[0][0] * a[1][1] - a[0][1] * a[1][0];
        if (determinant == 0) {
            System.out.println("矩陣不可逆！");
            return null; 
        }
        
        int c[][] = new int[2][2];
        c[0][0] = a[1][1];
        c[0][1] = -a[0][1];
        c[1][0] = -a[1][0];
        c[1][1] = a[0][0];
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] /= determinant;
            }
        }
        
        return c;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
