import java.util.HashMap;
import java.util.Map;

public class hw2 {
    public static void main(String[] args) {
        String[] characters = {"國", "立", "虎", "尾", "科", "技", "大", "學", "林", "映", "辰"};
        
        for (String ch : characters) {
            int unicodeValue = ch.codePointAt(0);
            System.out.println(ch + " (" + unicodeValue + ")");
        }
    }
}
