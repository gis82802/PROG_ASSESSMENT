public class test {
    public static void main(String[] args) {
        String university = "國立虎尾科技大學";
        
        for (char ch : university.toCharArray()) {
            System.out.printf("%c: %x%n", ch, (int) ch);
        }
    }
}