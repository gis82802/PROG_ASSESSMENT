import java.util.HashMap;
import java.util.Map;

public class hw2 {
    public static void main(String[] args) {
        String[] characters = {"��", "��", "��", "��", "��", "��", "�j", "��", "�L", "�M", "��"};
        
        for (String ch : characters) {
            int unicodeValue = ch.codePointAt(0);
            System.out.println(ch + " (" + unicodeValue + ")");
        }
    }
}
