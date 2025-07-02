public class hw2 {
    public static void main(String[] args) {
        int[] num = new int[6];
        System.out.print("input: [");
        for (int i = 0; i < 6; i++) {
            num[i] = (int) (Math.random() * 20) + 1;
            System.out.print(num[i] + (i == 5 ? "]\n" : ", "));
        }
        for (int i = 0; i < 6; i++) {
            if (i == 5) {
                num[i] = -1;
            } else {
                int maxnum = num[i + 1];
                for (int j = i + 2; j < 6; j++) {
                    if (num[j] > maxnum) {
                        maxnum = num[j];
                    }
                }
                num[i] = maxnum;
            }
        }
        System.out.print("output: [");
        for (int i = 0; i < 6; i++) {
            System.out.print(num[i] + (i == 5 ? "]\n" : ", "));
        }
    }
}
