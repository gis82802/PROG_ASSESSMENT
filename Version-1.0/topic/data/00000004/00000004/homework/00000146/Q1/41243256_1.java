import java.util.concurrent.TimeUnit;
public class owoblue_java05
{
 public static void main(String args[])
 {
  char[]num;
  int i=0;
  while(true)
  {
   for(i=0;i<4;i++)
   {
    System.out.print("\033[H\033[2J");
    System.out.flush();
    if(i==0){System.out.println("\\");}
    if(i==1){System.out.println("-");}
    if(i==2){System.out.println("/");}
    if(i==3){System.out.println("-");}
	try {TimeUnit.SECONDS.sleep(1);} 
        catch (InterruptedException ie) {Thread.currentThread().interrupt();}
   }
  }
 }
}