import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class test {

    private static final String[] MAPPING = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    private static List<String> combinations = new ArrayList<>();
    private static int printCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("請輸入一個 7 位數的電話號碼 (不含0, 1): ");
        String number = scanner.nextLine();
        scanner.close();

        if (number.length() != 7) {
            System.out.println("輸入的號碼長度必須為 7 位數。");
            return;
        }

        generateCombinations("", number);

        for (String combo : combinations) {
            System.out.print(combo + " ");
            printCount++;
            if (printCount % 10 == 0) {
                System.out.println();
            }
        }
        if (printCount % 10 != 0) {
            System.out.println(); // 確保最後一行換行
        }
    }

    private static void generateCombinations(String prefix, String digits) {
        if (digits.isEmpty()) {
            combinations.add(prefix);
            return;
        }

        int digit = Character.getNumericValue(digits.charAt(0));
        String letters = MAPPING[digit];

        for (char letter : letters.toCharArray()) {
            generateCombinations(prefix + letter, digits.substring(1));
        }
    }
}