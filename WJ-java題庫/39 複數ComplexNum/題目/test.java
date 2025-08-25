import java.util.Scanner;

class ComplexNum {
    public double real;
    public double image;

    // 預設建構子
    public ComplexNum() {
        this.real = 0.0;
        this.image = 0.0;
    }

    // 帶參數的建構子
    public ComplexNum(double real, double image) {
        this.real = real;
        this.image = image;
    }

    public ComplexNum Add(ComplexNum other) {
        return new ComplexNum(this.real + other.real, this.image + other.image);
    }

    public ComplexNum Sub(ComplexNum other) {
        return new ComplexNum(this.real - other.real, this.image - other.image);
    }

    public ComplexNum Times(ComplexNum other) {
        double newReal = this.real * other.real - this.image * other.image;
        double newImage = this.real * other.image + this.image * other.real;
        return new ComplexNum(newReal, newImage);
    }

    public ComplexNum Div(ComplexNum other) {
        double denominator = other.real * other.real + other.image * other.image;
        if (denominator == 0) {
            throw new ArithmeticException("除數不能為零。");
        }
        double newReal = (this.real * other.real + this.image * other.image) / denominator;
        double newImage = (this.image * other.real - this.real * other.image) / denominator;
        return new ComplexNum(newReal, newImage);
    }

    @Override
    public String toString() {
        if (image >= 0) {
            return real + "+" + image + "i";
        } else {
            return real + "" + image + "i";
        }
    }
}

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取第一個複數
        //System.out.print("請輸入複數 a 的實數和虛數部分 (以空格分隔): ");
        double realA = scanner.nextDouble();
        double imageA = scanner.nextDouble();

        // 讀取第二個複數
        //System.out.print("請輸入複數 b 的實數和虛數部分 (以空格分隔): ");
        double realB = scanner.nextDouble();
        double imageB = scanner.nextDouble();

        scanner.close();

        ComplexNum a = new ComplexNum(realA, imageA);
        ComplexNum b = new ComplexNum(realB, imageB);

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println("a+b = " + a.Add(b));
        System.out.println("a-b = " + a.Sub(b));
        System.out.println("a*b = " + a.Times(b));
        
        try {
            System.out.println("a/b = " + a.Div(b));
        } catch (ArithmeticException e) {
            System.out.println("錯誤：" + e.getMessage());
        }
    }
}