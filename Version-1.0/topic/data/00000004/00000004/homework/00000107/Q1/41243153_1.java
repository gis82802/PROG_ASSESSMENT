public class hw2 {
    public static void main(String[] args) throws Exception {
        
        String[] A = {"/", "—", "\\", "|"};
        while (true) {
            for (String B : A) {
                System.out.print("\r" + B);
                Thread.sleep(200);
            }
        }
    }
}
