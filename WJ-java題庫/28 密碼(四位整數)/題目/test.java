import java.util.Scanner;

// 自訂例外類別：處理密碼錯誤次數過多
class IncorrectPasswordException extends Exception {
    public IncorrectPasswordException(String message) {
        super(message);
    }
}

public class test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = "";

        // 第一次輸入密碼
        while (true) {
            //System.out.println("請設定您的四位數密碼：");
            if (scanner.hasNextInt()) {
                int tempPassword = scanner.nextInt();
                if (String.valueOf(tempPassword).length() == 4) {
                    password = String.valueOf(tempPassword);
                    break;
                }
            }
            System.out.println("密碼格式不正確，請輸入四位數整數。");
            scanner.nextLine(); // 清除緩衝區
        }

        int attempts = 3;
        try {
            while (attempts > 0) {
                System.out.println("請再次輸入密碼進行確認：");
                String confirmPassword = "";

                if (scanner.hasNextInt()) {
                    int tempConfirm = scanner.nextInt();
                    if (String.valueOf(tempConfirm).length() == 4) {
                        confirmPassword = String.valueOf(tempConfirm);
                    } else {
                        System.out.println("密碼格式不正確，請輸入四位數整數。");
                        scanner.nextLine(); // 清除緩衝區
                        continue; // 不計入錯誤次數
                    }
                } else {
                    System.out.println("密碼格式不正確，請輸入四位數整數。");
                    scanner.nextLine(); // 清除緩衝區
                    continue; // 不計入錯誤次數
                }

                if (password.equals(confirmPassword)) {
                    System.out.println("密碼設定成功！");
                    break;
                } else {
                    attempts--;
                    if (attempts > 0) {
                        System.out.println("密碼不符，請重新輸入。 (您還有 " + attempts + " 次機會)");
                    } else {
                        throw new IncorrectPasswordException("密碼錯誤次數已達上限，程式終止。");
                    }
                }
            }
        } catch (IncorrectPasswordException e) {
            System.out.println("錯誤：" + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}