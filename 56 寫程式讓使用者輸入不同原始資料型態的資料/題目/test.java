import java.util.Scanner;
import java.lang.Math;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 任務 1: 讀取不同資料型態的輸入
        System.out.println("請依序輸入 byte, short, int, char, long, float, double 的值：");
        byte byteVal = scanner.nextByte();
        short shortVal = scanner.nextShort();
        int intVal = scanner.nextInt();
        char charVal = scanner.next().charAt(0);
        long longVal = scanner.nextLong();
        float floatVal = scanner.nextFloat();
        double doubleVal = scanner.nextDouble();
        
        System.out.println("輸入的 byte 值：" + byteVal);
        System.out.println("輸入的 short 值：" + shortVal);
        System.out.println("輸入的 int 值：" + intVal);
        System.out.println("輸入的 char 值：" + (int)(charVal));
        System.out.println("輸入的 long 值：" + longVal);
        System.out.println("輸入的 float 值：" + floatVal);
        System.out.println("輸入的 double 值：" + doubleVal);
        
        System.out.println("\n--- 多項式 f(x) = ax^2 + bx + c ---");
        
        // 任務 2: 讀取多項式係數
        //System.out.println("請輸入係數 a, b, c：");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        
        System.out.println("多項式為：f(x) = " + a + "x^2 + " + b + "x + " + c);
        
        // 任務 3a: 計算 f(x) 的值
        //System.out.println("請輸入 x 的值來計算 f(x)：");
        double x = scanner.nextDouble();
        double fx = a * x * x + b * x + c;
        System.out.println("f(" + x + ") = " + fx);
        
        // 任務 3b: 求解 f(x) = 0
        System.out.println("\n--- 求解 f(x) = 0 ---");
        double discriminant = b * b - 4 * a * c; // 判別式
        
        if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("當 f(x)=0 時，x 的解為：");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else if (discriminant == 0) {
            double x1 = -b / (2 * a);
            System.out.println("當 f(x)=0 時，x 只有一個實數解：");
            System.out.println("x = " + x1);
        } else {
            System.out.println("當 f(x)=0 時，沒有實數解。");
        }
        
        scanner.close();
    }
}