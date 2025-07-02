public class hw40643149_240927_2
{
   public static void main(String args[])throws Exception
   {
        String animeT = "/-\\";
        int i  = 0;
        while (true) {
            System.out.print(animeT.charAt(i % 3));
            Thread.sleep(200);
            System.out.print("\r");
            i++;
        }
   }
}
