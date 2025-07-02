public class app_rotate{
    public static void main(String[] args) throws Exception{
        String[] a= {"-", "\\", "|", "/"};

        while (true) {
            for (String b : a) {
                System.out.print("\r" + b);
                try {
                    Thread.sleep(100); 
                } catch (InterruptedException e) {
                    System.err.println("Sleep interrupted: " + e.getMessage());
                }
            }
        }
    }
}
