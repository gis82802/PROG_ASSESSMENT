public class hw {
    public static void main(String[] args) {
        int[] num = new int[6];

        System.out.print("Generated numbers: ");
        for (int i = 0; i < 6; i++) {
            int n = (int) (Math.random() * 100) + 1;
            num[i] = n;
            System.out.print(num[i] + " ");
        }
        System.out.println("");
        
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (num[i] > num[j]) {
                    int tmp = num[i];
                    num[i] = num[j];
                    num[j] = tmp;
                }
            }
        }

        System.out.print("Sorted numbers: ");
        for (int i = 0; i < 6; i++) {
            System.out.print(num[i] + " ");
        }
    }
}
