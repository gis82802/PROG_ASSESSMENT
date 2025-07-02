/*
Name:蔡承叡
date:2024/9/27
version:jdk23
*/
public class ch3_2 {
    public static void main(String[] args) throws InterruptedException {
        char[] stickStates = {'|', '/', '-', '\\'};
        
        while (true) {
            for (int i = 0; i < stickStates.length; i++) {

                System.out.print("\r" + stickStates[i]);


                Thread.sleep(200);
            }
        }
    }
}
