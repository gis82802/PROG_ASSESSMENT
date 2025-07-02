public class UnicodeExample {
    public static void main(String[] args) {
        String name = "國立虎尾科大資訊工程系林承志";
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
	    int unicode = (int) c;
            System.out.println("第" + (i+1) + "個字'" + c + "' 的Unicode編碼為: " + unicode);
        }
    }
}
