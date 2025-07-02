import java.util.Scanner;

public class SquareMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("請輸入方形矩陣的大小 ");
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("請輸入矩陣的資料");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int sum = 0;
        System.out.println("矩陣數據為:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("矩陣所有元素的總和是: " + sum);

        sc.close();
    }
}
