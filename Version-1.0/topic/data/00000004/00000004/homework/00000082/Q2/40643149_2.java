public class hw40643149_240927
{
   public static void main(String args[])throws Exception
   {
        String name = "雷務馨";
        String school = "國立虎尾科技大學";
        Printunicode(name);
        Printunicode(school);
   }
   public static void Printunicode(String W){
    for(int i = 0; i < W.length(); i++){
        int unicode = W.charAt(i);
        System.out.println(W.charAt(i) + "(" + unicode + ")");
    }
   }
}
