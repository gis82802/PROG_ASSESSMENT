import java.util.Scanner;

public class homework3_4 {
    public static void main(String[] args) {
        int[] x = new int[5];
        int a = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入一個數字: ");
        int input = scanner.nextInt();

        while (input % 10 == 0 && input != 0) {
            input /= 10;
        }

        while (input != 0) {
            x[a] = input % 10;
            a++;
            input /= 10;
        }

        for (int b = 0; b < a; b++) {
            System.out.print(x[b]);
        }

        scanner.close();
    }
}

