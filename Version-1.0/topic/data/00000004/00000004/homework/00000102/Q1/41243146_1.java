public class test2 {
    public static void main(String[] args) throws Exception{
            for (int i = 0; i < 100; i++) {
                System.out.print('|');
                Thread.sleep(100);
                System.out.print(" \r");
                System.out.print('/');
                Thread.sleep(100);
                System.out.print(" \r");
                System.out.print('-');
                Thread.sleep(100);
                System.out.print(" \r");
                System.out.print('\\'); 
                Thread.sleep(100);
                System.out.print(" \r");
            }
    }
}
