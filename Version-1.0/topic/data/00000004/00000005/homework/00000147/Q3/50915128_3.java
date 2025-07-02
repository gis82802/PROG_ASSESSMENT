import java.util.Scanner;
public class java4_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入三個數字");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
         
        //使用運算子計算排序
        double max=(a>b?(a>c?a:c):(b>c?b:c));
        double min=(a<b?(a<c?a:c):(b<c?b:c));
        double mid=a+b+c-max-min;
        //輸出結果
        System.out.println("數字排列順序為: ");
        System.out.println(max +","+mid+","+min);
        scanner.close();
     }
}