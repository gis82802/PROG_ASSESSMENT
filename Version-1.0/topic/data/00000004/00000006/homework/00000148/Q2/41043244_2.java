import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int ans=0;
        for(int i=0;i<=100000;i++){
            if(isWellOrdered(i)) ans++;
        }
        System.out.println("0到100000共有"+ans+"個 well-ordered number.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("輸入正整數: ");
        int number = scanner.nextInt();
        if (isWellOrdered(number)) {
            System.out.println(number + "是well-ordered number.");
        } else {
            System.out.println(number + "不是well-ordered number.");
        }
    }

    public static boolean isWellOrdered(int n) {
        int p = 10;
        while (n > 0) {
            int c = n % 10;
            if (c >= p) {
                return false;
            }
            p = c;
            n /= 10;
        }
        return true;
    }
}
