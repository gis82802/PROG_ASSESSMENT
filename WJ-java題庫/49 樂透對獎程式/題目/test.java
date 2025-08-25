import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 自訂例外類別
class InvalidLotteryNumberException extends Exception {
    public InvalidLotteryNumberException(String message) {
        super(message);
    }
}

public class test {

    public static void main(String[] args) {
        // 當期中獎號碼（設定為 Set 以便快速查找）
        Set<Integer> winningNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 10, 15));
        
        Scanner scanner = new Scanner(System.in);
        int[] userNumbers = new int[6];

        try {
            //System.out.println("請輸入您的樂透號碼 (六個介於 1~49 的整數):");
            for (int i = 0; i < 6; i++) {
                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();
                    // 檢查數字是否在有效範圍內
                    if (number < 1 || number > 49) {
                        throw new InvalidLotteryNumberException("輸入的數字 " + number + " 超出有效範圍 (1~49)。程式結束。");
                    }
                    userNumbers[i] = number;
                } else {
                    throw new InvalidLotteryNumberException("輸入格式不正確，請輸入整數。程式結束。");
                }
            }
            
            // 驗證通過，開始對獎
            checkPrize(winningNumbers, userNumbers);
            
        } catch (InvalidLotteryNumberException e) {
            System.out.println("錯誤：" + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void checkPrize(Set<Integer> winningNumbers, int[] userNumbers) {
        int matchCount = 0;
        
        // 統計對中號碼個數
        for (int userNumber : userNumbers) {
            if (winningNumbers.contains(userNumber)) {
                matchCount++;
            }
        }
        
        System.out.println("您的號碼：" + Arrays.toString(userNumbers));
        System.out.println("中獎號碼：" + winningNumbers);
        
        // 根據對中個數判斷獎項
        switch (matchCount) {
            case 6:
                System.out.println("恭喜您！對中 6 個號碼，獲得頭獎！");
                break;
            case 5:
                System.out.println("恭喜您！對中 5 個號碼，獲得二獎！");
                break;
            case 4:
                System.out.println("恭喜您！對中 4 個號碼，獲得三獎！");
                break;
            case 3:
                System.out.println("恭喜您！對中 3 個號碼，獲得四獎！");
                break;
            case 2:
                System.out.println("恭喜您！對中 2 個號碼，獲得五獎！");
                break;
            default:
                System.out.println("很抱歉，對中 " + matchCount + " 個號碼，未中獎。");
                break;
        }
    }
}