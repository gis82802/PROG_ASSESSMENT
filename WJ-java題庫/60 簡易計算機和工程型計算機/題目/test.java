import java.util.Scanner;
import java.lang.Math;

public class test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            //System.out.println("請選擇計算機類型：");
            //System.out.println("1. 簡易計算機");
            //System.out.println("2. 工程型計算機");
            //System.out.println("-1. 結束程式");
            //System.out.print("請輸入您的選擇：");
            
            while (!scanner.hasNextInt()) {
                System.out.println("無效輸入，請輸入一個整數選項。");
                System.out.print("請輸入您的選擇：");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    simpleCalculator(scanner);
                    break;
                case 2:
                    scientificCalculator(scanner);
                    break;
                case -1:
                    System.out.println("程式結束。");
                    break;
                default:
                    System.out.println("無效的選擇，請重新輸入。");
            }
        } while (choice != -1);

        scanner.close();
    }

    public static void simpleCalculator(Scanner scanner) {
        //System.out.println("請輸入兩個數字和一個運算符號 (例如：10 + 20)：");
        try {
            double num1 = scanner.nextDouble();
            String operator = scanner.next();
            double num2 = scanner.nextDouble();
            double result = 0;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("錯誤：除數不能為零。");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("無效的運算符號。");
                    return;
            }
            System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
        } catch (java.util.InputMismatchException e) {
            System.out.println("輸入格式錯誤，請輸入數字和運算符號。");
            scanner.nextLine(); // 清除緩衝區
        }
    }

    public static void scientificCalculator(Scanner scanner) {
        //System.out.println("請輸入一個數字和一個運算符號 (例如：10 sqrt, 10 pow 2)：");
        try {
            double num1 = scanner.nextDouble();
            String operator = scanner.next();
            double result = 0;

            switch (operator) {
                case "sqrt":
                    result = Math.sqrt(num1);
                    System.out.println(num1 + " 的平方根 = " + result);
                    break;
                case "abs":
                    result = Math.abs(num1);
                    System.out.println(num1 + " 的絕對值 = " + result);
                    break;
                case "pow":
                    double num2 = scanner.nextDouble();
                    result = Math.pow(num1, num2);
                    System.out.println(num1 + " 的 " + num2 + " 次方 = " + result);
                    break;
                default:
                    System.out.println("無效的運算符號。");
                    break;
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("輸入格式錯誤，請輸入數字和運算符號。");
            scanner.nextLine();
        }
    }
}