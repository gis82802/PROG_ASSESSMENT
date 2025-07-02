public class homework {
    public static void main(String[] args)throws Exception {
        String[] spinner = {"\\", "|", "/", "-"};
            while (true) { 
                for (String s : spinner) {
                    System.out.print("\r" + s);
                    Thread.sleep(200);
                }
            }
  
    }
}
