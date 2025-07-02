/**
 * Project Name: Simulation
 * Author: 41243144 温博鈞
 * Description:
 *      This project simulates the icon animation during system execution.
 * Functionality:
 *      Displays the information using print().
 *      Thread.sleep(): let the system wait for the delay
 *      ProcessBuilder(): operating system commands
 * Last Edit Date: 2024-09-27
 */

package September.sep_27;

public class Simulation {
    public static void main(String[] args) throws Exception{
        String str = "/|—\\|—";
        for(int i=0; i < 12; i++){  
            // cycle
            System.out.print(str.charAt(i % 6));
            Thread.sleep(200);
            // clear cmd
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
    }
}
