import java.util.Scanner;
import java.util.Stack;

public class test {

    public static boolean isValid(String s) {
        // 使用 Stack 來儲存左括號
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                // 如果是左括號，推入堆疊
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                // 如果是右括號
                if (stack.isEmpty()) {
                    // 如果堆疊為空，表示沒有對應的左括號
                    return false;
                }
                char top = stack.pop(); // 彈出堆疊頂部的左括號
                
                // 檢查括號類型是否匹配
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }
        
        // 最終堆疊必須為空，表示所有括號都已正確閉合
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        
        while (true) {
            //System.out.println("請輸入一個字串進行檢查 ('exit' 結束):");
            input = scanner.nextLine();
            
            if (input.equals("exit")) {
                System.out.println("程式結束。");
                break;
            }
            
            boolean result = isValid(input);
            System.out.println("結果: " + result);
        }
        
        scanner.close();
    }
}