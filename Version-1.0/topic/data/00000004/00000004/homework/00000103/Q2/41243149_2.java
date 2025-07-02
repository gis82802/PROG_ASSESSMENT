public class unicode {
    public static void main(String[] args) {
        String text = "虎尾科技大學 廖章竹";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            System.out.printf("%c (unicode)\\u%04x\n", ch, (int) ch);
        }
    }
}
