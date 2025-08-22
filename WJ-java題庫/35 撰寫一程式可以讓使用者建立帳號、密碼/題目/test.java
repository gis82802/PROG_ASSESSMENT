import java.util.Scanner;

// (a) 帳號開頭字元不符例外
class InvalidStartCharException extends Exception {
    public InvalidStartCharException(String message) {
        super(message);
    }
}

// (b) 帳號長度過短例外
class TooShortException extends Exception {
    public TooShortException(String message) {
        super(message);
    }
}

// (b) 帳號長度過長例外
class TooLongException extends Exception {
    public TooLongException(String message) {
        super(message);
    }
}

public class test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username;

        while (true) {
            //System.out.println("請設定您的帳號：");
            username = scanner.nextLine();
            
            try {
                validateUsername(username);
                System.out.println("帳號設定成功！");
                break; // 驗證成功，跳出迴圈
            } catch (InvalidStartCharException | TooShortException | TooLongException e) {
                System.out.println("錯誤：" + e.getMessage());
            }
        }
        scanner.close();
    }

    public static void validateUsername(String username) throws InvalidStartCharException, TooShortException, TooLongException {
        // 檢查開頭是否為英文字母
        if (username.isEmpty() || !Character.isLetter(username.charAt(0))) {
            throw new InvalidStartCharException("帳號名稱必須以英文字母開頭。請重新輸入。");
        }

        // 檢查長度是否符合
        if (username.length() < 8) {
            throw new TooShortException("帳號名稱長度小於 8 個字元。請重新輸入。");
        } else if (username.length() > 10) {
            throw new TooLongException("帳號名稱長度超過 10 個字元。請重新輸入。");
        }
    }
}