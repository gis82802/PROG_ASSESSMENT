import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("請輸入一行文字: ");
        String input = scanner.nextLine();
        scanner.close();

        // 建立一個大小為 26 的陣列來儲存 a-z 的次數
        int[] letterCounts = new int[26];

        // 將輸入字串轉換為小寫，並遍歷每個字元
        String lowerCaseInput = input.toLowerCase();
        for (char ch : lowerCaseInput.toCharArray()) {
            // 檢查字元是否為英文字母
            if (ch >= 'a' && ch <= 'z') {
                int index = ch - 'a';
                letterCounts[index]++;
            }
        }

        System.out.println("出現的字母統計:");
        // 遍歷陣列，印出有出現過的字母
        for (int i = 0; i < letterCounts.length; i++) {
            if (letterCounts[i] > 0) {
                char letter = (char) ('a' + i);
                System.out.println(letter + ": " + letterCounts[i]);
            }
        }
    }
}