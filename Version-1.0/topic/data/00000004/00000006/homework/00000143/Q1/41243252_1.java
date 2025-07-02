public class ch5_1_2 {
    public static void main(String args[]) {
        int i = 1;
        float sum = 0;
        float Ans;

        while (true) {
            if (i % 2 == 1) {
                sum += 1.0f / (2 * i - 1);
            } else {
                sum -= 1.0f / (2 * i - 1);
            }
            Ans = sum * 4;

            if (Ans >= 3.14158 && Ans <= 3.14160) {
                break;
            }

            i++;
        }
        System.out.println("所用的次數: " + i);
    }
}
