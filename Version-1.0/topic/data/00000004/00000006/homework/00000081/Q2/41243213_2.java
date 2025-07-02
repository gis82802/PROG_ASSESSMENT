
public class WellNumberChecker 
{
    public static void main(String[] args) 
    {
        int i,j;
        int flag = 0;
        for(int x = 1;x<100000;x++)
        {
            while(true)
            {
                if(x<10)
                {
                    flag+=1;
                    break;
                }
                j = x % 10;
                x /= 10;
                i = x % 10;
                x /= 10;
                if (j <= i)
                {
                    break;
                }
                else if (x <= 0)
                {
                    flag += 1;
                    break;
                }
            }
            System.out.print(flag);
        }
    }
}