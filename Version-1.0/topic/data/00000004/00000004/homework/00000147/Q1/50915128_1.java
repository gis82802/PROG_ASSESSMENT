public class java3_7 {
    public static void main(String[] args) throws InterruptedException {
        char[] spinner = {'|', '/', '-', '\\'};
        
        while (true) {
            for (char ch : spinner) {
                System.out.print("\r" + ch); 
                Thread.sleep(200); 
            }
        }
    }
}
