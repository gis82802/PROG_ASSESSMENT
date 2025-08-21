import java.util.Scanner;

class RationalNum {
    private int numerator;
    private int denominator;

    // 尋找最大公因數以簡化分數
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // 建構子，並自動化簡分數
    public RationalNum(int num, int den) {
        if (den == 0) {
            throw new IllegalArgumentException("分母不能為零。");
        }
        
        int common = gcd(Math.abs(num), Math.abs(den));
        this.numerator = num / common;
        this.denominator = den / common;

        // 確保分母為正
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    public RationalNum Add(RationalNum other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new RationalNum(newNumerator, newDenominator);
    }

    public RationalNum Sub(RationalNum other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new RationalNum(newNumerator, newDenominator);
    }

    public RationalNum Mul(RationalNum other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new RationalNum(newNumerator, newDenominator);
    }

    public RationalNum Div(RationalNum other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("除數不能為零。");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new RationalNum(newNumerator, newDenominator);
    }

    @Override
    public String toString() {
        // 如果分子為0
        if (this.numerator == 0) {
            return "0";
        }

        // 如果分母為1
        if (this.denominator == 1) {
            return String.valueOf(this.numerator);
        }

        // 處理帶分數
        if (Math.abs(this.numerator) >= this.denominator) {
            int whole = this.numerator / this.denominator;
            int remainingNum = this.numerator % this.denominator;
            if (remainingNum == 0) {
                return String.valueOf(whole);
            }
            return whole + "+" + Math.abs(remainingNum) + "/" + this.denominator;
        }

        // 一般分數
        return this.numerator + "/" + this.denominator;
    }
}

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取第一個分數
        //System.out.print("請輸入分數 a 的分子和分母 (例如：2 3): ");
        int numA = scanner.nextInt();
        int denA = scanner.nextInt();
        
        // 讀取第二個分數
        //System.out.print("請輸入分數 b 的分子和分母 (例如：5 7): ");
        int numB = scanner.nextInt();
        int denB = scanner.nextInt();

        scanner.close();

        try {
            RationalNum a = new RationalNum(numA, denA);
            RationalNum b = new RationalNum(numB, denB);

            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("a+b = " + a.Add(b));
            System.out.println("a-b = " + a.Sub(b));
            System.out.println("a*b = " + a.Mul(b));
            System.out.println("a/b = " + a.Div(b));
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("錯誤：" + e.getMessage());
        }
    }
}