import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score;

        while (true) {
            //System.out.print("請輸入一個 0 到 100 之間的分數：");
            
            // 檢查輸入是否為整數
            if (scanner.hasNextInt()) {
                score = scanner.nextInt();
                
                // 判斷分數範圍
                if (score >= 60 && score <= 100) {
                    System.out.println("及格。");
                    break;
                } else if (score >= 50 && score <= 59) {
                    System.out.println("須補考。");
                    break;
                } else if (score >= 0 && score <= 49) {
                    System.out.println("不及格。");
                    break;
                } else {
                    System.out.println("分數不合理，請重新輸入。");
                }
            } else {
                System.out.println("輸入不正確，請輸入一個整數。");
                scanner.next(); // 讀取並丟棄不合法的輸入
            }
        }
        scanner.close();
    }
}