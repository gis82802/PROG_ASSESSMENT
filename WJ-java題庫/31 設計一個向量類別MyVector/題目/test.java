import java.util.Scanner;
import java.util.Arrays;

// MyVector 類別
class MyVector {
    private double[] elements;
    private int dimension;

    public MyVector(double[] elements) {
        this.elements = elements;
        this.dimension = elements.length;
    }

    public int getDimension() {
        return this.dimension;
    }

    // 計算向量範數
    public double getNorm() {
        double sumOfSquares = 0.0;
        for (double element : elements) {
            sumOfSquares += element * element;
        }
        return Math.sqrt(sumOfSquares);
    }

    // 計算向量內積
    public double dotProduct(MyVector other) {
        if (this.dimension != other.getDimension()) {
            throw new IllegalArgumentException("向量維度不匹配，無法計算內積。");
        }
        double dot = 0.0;
        for (int i = 0; i < this.dimension; i++) {
            dot += this.elements[i] * other.elements[i];
        }
        return dot;
    }

    // 計算向量夾角
    public double angle(MyVector other) {
        if (this.dimension != other.getDimension()) {
            throw new IllegalArgumentException("向量維度不匹配，無法計算夾角。");
        }
        double dot = this.dotProduct(other);
        double normProduct = this.getNorm() * other.getNorm();
        if (normProduct == 0) {
             throw new ArithmeticException("向量長度為零，無法計算夾角。");
        }
        double cosTheta = dot / normProduct;
        return Math.acos(cosTheta);
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            //System.out.print("請輸入向量維度: ");
            int dim = scanner.nextInt();

            //System.out.print("請輸入向量 a 的 " + dim + " 個元素 (以空格分隔): ");
            double[] arrA = new double[dim];
            for (int i = 0; i < dim; i++) {
                arrA[i] = scanner.nextDouble();
            }

            //System.out.print("請輸入向量 b 的 " + dim + " 個元素 (以空格分隔): ");
            double[] arrB = new double[dim];
            for (int i = 0; i < dim; i++) {
                arrB[i] = scanner.nextDouble();
            }

            MyVector a = new MyVector(arrA);
            MyVector b = new MyVector(arrB);

            System.out.println("\n向量 a = " + a);
            System.out.println("向量 b = " + b);
            
            System.out.println("\n向量 a 的範數: " + a.getNorm());
            System.out.println("向量 b 的範數: " + b.getNorm());
            
            System.out.println("\na 與 b 的內積: " + a.dotProduct(b));
            System.out.println("a 與 b 的夾角 (弧度): " + a.angle(b));

        } catch (IllegalArgumentException e) {
            System.out.println("錯誤：" + e.getMessage());
        } catch (Exception e) {
            System.out.println("輸入格式不正確。請輸入數字。");
        } finally {
            scanner.close();
        }
    }
}