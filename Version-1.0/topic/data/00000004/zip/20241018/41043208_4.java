import java.util.Scanner;

public class hw4 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        System.out.print("Input height (max: 20, min: 1): ");
        
        while (sca.hasNext()) {
            int high = sca.nextInt();
            if (high <= 20 && high > 0) {
                char[][] num = new char[high][];

                for (int i = 0; i < high; i++) {
                    num[i] = new char[i + 1];
                }

                for (int i = 0; i < high; i++) {
                    for (int j = 0; j <= i; j++) {
                        num[i][j] = '*';
                    }
                }

                for (int i = 0; i < high; i++) {
                    for (int j = 0; j < num[i].length; j++) {
                        System.out.print(num[i][j]);
                    }
                    System.out.println();
                }
            }
            System.out.print("Input height (max: 20, min: 1): ");
        }
        sca.close();
    }
}
