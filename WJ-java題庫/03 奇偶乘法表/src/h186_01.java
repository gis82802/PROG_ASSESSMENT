public class bonny2
{
    public static int j;
    
        public static void main(String args[])
        {
            
            for (int i=1;i<=9;i+=2){
              for ( j = 2;j<=9;j+=2){
                 System.out.print(i+"*"+j+"="+(i*j));
               if(j<=6)  
                 System.out.print("\t");
            }
            System.out.println();
        }
    }
}