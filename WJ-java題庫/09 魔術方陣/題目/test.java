import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        if (n % 2 == 0) {
            //System.out.println("請輸入奇數。");
            return;
        }

        int[][] magicSquare = new int[n][n];
        int i = 0;
        int j = n / 2;

        for (int num = 1; num <= n * n; num++) {
            magicSquare[i][j] = num;

            int next_i = (i - 1 + n) % n;
            int next_j = (j + 1) % n;

            if (magicSquare[next_i][next_j] != 0) {
                i = (i + 1) % n;
            } else {
                i = next_i;
                j = next_j;
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(magicSquare[row][col] + " ");
            }
            System.out.println();
        }

        int sum = 0;
        for (int col = 0; col < n; col++) {
            sum += magicSquare[0][col];
        }  
        System.out.println("總和: " + sum);
    }
}