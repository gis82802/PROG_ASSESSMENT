/*
Name:蔡承叡
date:2024/9/27
version:jdk23
*/
public class ch3_1 {
    public static void main(String[] args) {
        String text = "蔡承叡虎尾科技大學";

      
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            int unicodeValue = (int) character;
            System.out.print(character + " ");  
            System.out.println(unicodeValue + " "); 
        }
        System.out.println();
    }
}