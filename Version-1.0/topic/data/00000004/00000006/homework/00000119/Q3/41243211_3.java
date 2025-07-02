import java.util.Scanner;//import Scanner

public class app_3 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("num: ");
        int num = scanner.nextInt();//in

        // reverse num
        int reverse = 0;

        while (num != 0) 
	{
            int digit = num % 10; // get last num
            reverse = reversedNum * 10 + digit; // update
            num /= 10; 
        }

        //out
        System.out.println("Reverse: " + reverse);

        scanner.close();
    }
}
