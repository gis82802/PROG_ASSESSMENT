/*
    Filename: "hwapp02b_1011"
    Function: well-ordered number 1~10000
    Author: SHUN-YE XU
    Version: 23
    date: 2024/10/11
*/

public class hwapp02b_1011 
{
    public static void main(String args[])
    {
        int count = 9; // 紀錄1~10000之間的well-ordered number數量

        for(int i = 10; i < 100000; i++)
        {
            boolean flag = false;
            String snum = Integer.toString(i);

            for(int j = 0; j < snum.length() - 1; j++)
            {
                
                if(snum.charAt(j) >= snum.charAt(j+1))
                {
                    flag = true;
                    break;
                }
            }
            
            if(!flag) count++;
        }
        
        System.out.println("1~10000 well-ordered numbers:"+count);
    }
}
