import java.util.Scanner;

public class homework1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print("請輸入計算到第幾項 (i，輸入n結束): ");
            input = scanner.nextLine();

            if (!input.equalsIgnoreCase("n")) {
                try {
                    int i = Integer.parseInt(input);

                    double pi = 0;
                    for (int n = 1; n <= i; n++) {
                        pi += 4.0 * Math.pow(-1, n + 1) / (2 * n - 1);
                    }

                    System.out.println("計算得到的π值為: " + pi);
                } catch (NumberFormatException e) {
                    System.out.println("輸入錯誤，請輸入整數或n");
                }
            }
        } while (!input.equalsIgnoreCase("n"));

    }
}