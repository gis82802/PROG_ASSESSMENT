import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("請輸入一個正整數 num: ");
        int num = scanner.nextInt();
        scanner.close();

        if (num <= 0) {
            System.out.println("請輸入一個大於 0 的整數。");
            return;
        }

        // (a) 尋找最大的 m，滿足 m^2 < num
        int m = (int) Math.sqrt(num);
        if (m * m == num) {
            m--;
        }
        
        // (b) 尋找最小的 n，滿足 n^2 > num
        int n = (int) Math.sqrt(num);
        if (n * n < num) {
            n++;
        } else {
            n++;
        }

        System.out.println("m = " + m + ", n = " + n);
    }
}