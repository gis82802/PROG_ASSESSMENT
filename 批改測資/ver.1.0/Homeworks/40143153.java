
/*
Features:   寫程式讓使用者輸入不同原始資料型態的資料(byte, short, int, char, long, float, dobule)
File:       hw2
Author:     40143153許嘉銓
Date:       2020/10/05
*/
import java.util.Scanner;

public class hw2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        byte inputByte;
        short inputShort;
        int inputInt;
        char inputChar;
        long inputLong;
        float inputFloat;
        double inputDouble;

        //System.out.println("byte");
        inputByte = scn.nextByte();
        System.out.println(inputByte);

        //System.out.println("short");
        inputShort = scn.nextShort();
        System.out.println(inputShort);

        //System.out.println("int");
        inputInt = scn.nextInt();
        System.out.println(inputInt);

        //System.out.println("char");
        inputChar = scn.next().charAt(0);
        System.out.println(inputChar);

        //System.out.println("long");
        inputLong = scn.nextLong();
        System.out.println(inputLong);

        //System.out.println("float");
        inputFloat = scn.nextFloat();
        System.out.println(inputFloat);

        //System.out.println("dobule");
        inputDouble = scn.nextDouble();
        System.out.println(inputDouble);
    }
}
