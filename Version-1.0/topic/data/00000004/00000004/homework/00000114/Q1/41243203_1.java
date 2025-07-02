public class hw2 {
    public static void main(String[] args) throws InterruptedException {
        String[] ch = {"\\", "|", "/", "-"};
        
        for (int i = 0; i < 10; i++) { // 循環 10 次
            for (String s : ch) {
                System.out.print("\r" + s);
                Thread.sleep(500);
            }
        }
        System.out.println("\n動畫結束");
    }
}
