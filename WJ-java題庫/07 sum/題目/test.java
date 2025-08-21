public class test {
public static void main(String[] args) {
    double sum = 0.0;
    // 分子從1開始，每次增加2，直到97
    for (int numerator = 1; numerator <= 97; numerator += 2) {
    // 分母從3開始，每次增加2
        int denominator = numerator + 2;
    // 進行浮點數除法並累加
    sum += (double) numerator / denominator;
    }
    System.out.printf("%.6f", sum);
    }
}