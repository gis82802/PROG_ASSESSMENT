public class test {

    public static void main(String[] args) {
        int count = 0;
        int perLine = 10;

        for (int i = 100; i <= 999; i++) {
            int hundreds = i / 100;
            int tens = (i % 100) / 10;
            int ones = i % 10;

            if (hundreds < tens && tens < ones) {
                System.out.print(i + " ");
                count++;
                
                if (count % perLine == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println();
    }
}