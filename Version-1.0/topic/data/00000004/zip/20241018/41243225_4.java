import java.util.Scanner;

public class t4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("input matrix size(nxn): n=");
        int n = input.nextInt();
        int arr[][] = new int[n][n];
        System.out.print("input matrix(' 'split): ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        for (int i[] : arr) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.print("input remove row: ");
        int x_remove = input.nextInt();
        System.out.print("input remove col: ");
        int y_remove = input.nextInt();
        input.close();
        int newarr[][] = new int[arr.length - 1][arr[0].length - 1];
        int ii = 0, jj = 0;
        for (int i = 0; i < newarr.length; i++) {
            if (ii == x_remove)
                ii++;
            if (ii >= arr.length)
                continue;
            jj = 0;
            for (int j = 0; j < newarr[0].length; j++) {
                if (jj == y_remove)
                    jj++;
                if (jj >= arr.length)
                    continue;
                newarr[i][j] = arr[ii][jj];
                jj++;
            }
            ii++;
        }
        for (int i[] : newarr) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        int iii = 0, jjj = 0;
        int calcarr[][] = new int[newarr.length][newarr.length * 2];
        for (int[] i : newarr) {
            jjj = 0;
            for (int j : i) {
                calcarr[iii][jjj] = j;
                calcarr[iii][jjj + calcarr.length] = j;
                jjj++;
            }
            iii++;
        }
        int total = 0;
        for (int k = 0; k < calcarr.length; k++) {
            int i = k, j = 0, tmp = 1;
            while (j < calcarr.length) {
                tmp *= calcarr[j][i];
                i++;
                j++;
            }
            total += tmp;
        }
        for (int k = calcarr.length - 1; k < calcarr.length * 2 - 1; k++) {
            int i = k, j = 0, tmp = 1;
            while (j < calcarr.length) {
                tmp *= calcarr[j][i];
                i--;
                j++;
            }
            total -= tmp;
        }
        System.out.println("total=" + total);
    }
}
