public class RotatingCylinder {
    public static void main(String[] args) throws InterruptedException {
        char[] chars = {'|', '/', '-', '\\'};
        int index = 0;

        while (true) {
            System.out.print("\r" + chars[index]);
            index = (index + 1) % chars.length;
            Thread.sleep(200); 
        }
    }
}