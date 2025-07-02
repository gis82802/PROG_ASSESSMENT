public class app3_3 {
    public static void main(String[] args) {
        
        String name = "黃順駿";
        String school = "虎尾科技大學";
        
        
        String fullName = name + school;
        
        
        for (int i = 0; i < fullName.length(); i++) {
            char c = fullName.charAt(i);
            int unicode = (int) c;
            System.out.println("Character: " + c + " Unicode: " + unicode);
        }
    }
}
