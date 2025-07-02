public class Main {
    public static void main(String[] args)throws Exception{
        String[] frames = {
                "|",
                "/",
                "-",
                "\\"
        };
        while (true) {
            for (String frame : frames) {
                System.out.print("\r" + frame); // \r 会返回到行首
                Thread.sleep(300);
            }
        }
    }
}