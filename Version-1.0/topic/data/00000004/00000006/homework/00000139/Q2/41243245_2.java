import java.util.Scanner;

public class WellOrderedNumber {

    public static boolean isWellOrdered(int number) {
        int prevDigit = 10; 

        while (number > 0) {
            int currentDigit = number % 10;
            number /= 10;
            
            if (currentDigit >= prevDigit) {
                return false;
            }
            prevDigit = currentDigit;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

	int number = 1;
	int i = 0;

	while (number <= 100000){
        	if (isWellOrdered(number)) {
		i++;
        	}
		number++;
	}
	System.out.println("well-ordered number count:");
	System.out.println(i);
        scanner.close();
    }
}



