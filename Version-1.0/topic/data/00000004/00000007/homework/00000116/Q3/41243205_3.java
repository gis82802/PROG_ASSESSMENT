import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("input n, and 0 < n <= 20: ");
        int n = sc.nextInt();
        star(n);
        System.out.print("input a number, and number < 100000: ");
        int num = sc.nextInt();
        int[] result = num(num); 
        if (result != null) { 
            System.out.printf("number %d at %d row %d col\n", num, result[0], result[1]);         }
    }

    public static void star(int n){
        if (n <= 0 || n > 20) {
            System.out.println("The input is not within the range, please re-enter!");
            return; 
        }

        for (int i = 0; i < n; i++) { 
            for (int j = 0; j <= i; j++) { 
                System.out.print("*");
            }
            System.out.println(); 
        }

        System.out.println();
        
        for (int i = n; i > 0; i--) { 
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) { 
                System.out.print("*");
            }
            System.out.println(); 
        }
    }

    public static int[] num(int num){
        if(num >= 100000) {
            System.out.println("The input is not within the range, please re-enter!");
            return null; 
        }

        int arr[][] = new int[20][20];
        int inum = 1;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j <= i; j++) { 
                arr[i][j] = inum;
                if (inum == num) {
                    return new int[]{i + 1, j + 1};                 }
                inum++;
            }
        }
        return null;
    }
}
