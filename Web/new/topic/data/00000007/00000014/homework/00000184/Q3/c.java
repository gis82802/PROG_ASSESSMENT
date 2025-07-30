//import java.util.*;
public class c extends Thread {
    
    public static void main(String[] args) throws Exception{
        for(int i=0;i<100;i++){
        sleep(500);
        System.out.print('\b');
        System.out.print("/");
        sleep(500);
        System.err.print('\b');
        System.out.print("-");
        sleep(500);
        System.out.print('\b');
        System.out.print("|");
        sleep(500);
        System.out.print('\b');
        System.out.print("\\");
        sleep(500);
        System.out.print('\b');
        System.out.print("|");

        }
    }



    
}
