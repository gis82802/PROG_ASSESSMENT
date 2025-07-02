public class hw1_1
{
    public static void main(String arg[])
    {
        String name = "張品薰國立臺灣虎尾科技大學";
        for (int i = 0; i < name.length(); i++) 
	{
            char c = name.charAt(i);  
            int unicode = (int) c;    
            System.out.println(c + " : " + unicode);
         }
    }
}