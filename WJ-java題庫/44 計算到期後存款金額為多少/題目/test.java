import java.util.Scanner;
import java.text.DecimalFormat;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //System.out.print("請輸入每年存入金額 (n): ");
        double n = scanner.nextDouble();

        //System.out.print("請輸入年利率 (rate, 例如 0.05): ");
        double rate = scanner.nextDouble();

        //System.out.print("請輸入儲蓄年數 (years): ");
        int years = scanner.nextInt();

        scanner.close();

        // 使用 Math.pow() 計算 (1 + rate) ^ years
        double finalAmount = n * (Math.pow(1 + rate, years) - 1) / rate * (1 + rate);

        // 使用 DecimalFormat 格式化輸出到小數點後六位
        DecimalFormat df = new DecimalFormat("0.000000");
        System.out.println("到期後的存款總金額為: " + df.format(finalAmount));
    }
}