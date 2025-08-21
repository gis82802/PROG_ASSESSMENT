import java.util.Scanner;

// 自訂例外類別：處理不合理的輸入
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

// 自訂例外類別：處理無解的情況
class NoSolutionException extends Exception {
    public NoSolutionException(String message) {
        super(message);
    }
}

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            //System.out.print("請輸入和尚總人數 (N)：");
            int n = scanner.nextInt();
            //System.out.print("請輸入饅頭總數 (M)：");
            int m = scanner.nextInt();

            // 檢查輸入是否合理
            if (n <= 0 || m <= 0) {
                throw new InvalidInputException("和尚總人數和饅頭總數必須為正整數。");
            }
            
            findMonks(n, m);
            
        } catch (InvalidInputException e) {
            System.out.println("錯誤：" + e.getMessage());
        } catch (NoSolutionException e) {
            System.out.println("錯誤：" + e.getMessage());
        } catch (Exception e) {
            System.out.println("輸入格式不正確，請輸入整數。");
        } finally {
            scanner.close();
        }
    }
    
    public static void findMonks(int n, int m) throws NoSolutionException {
        boolean foundSolution = false;
        
        // 迴圈遍歷所有大和尚的可能人數
        for (int bigMonks = 0; bigMonks <= n; bigMonks++) {
            // 計算小和尚人數
            int smallMonks = n - bigMonks;
            
            // 檢查小和尚人數是否是3的倍數，因為3人才能分一個饅頭
            if (smallMonks % 3 == 0) {
                // 計算吃掉的饅頭總數
                double totalBuns = (double) bigMonks * 3 + (double) smallMonks / 3;
                
                // 檢查饅頭總數是否吻合
                if (totalBuns == m) {
                    System.out.println("大和尚有 " + bigMonks + " 人，小和尚有 " + smallMonks + " 人");
                    foundSolution = true;
                    // 找到解後即可跳出
                    break;
                }
            }
        }
        
        if (!foundSolution) {
            throw new NoSolutionException("在給定的和尚和饅頭數下，此問題無解。");
        }
    }
}