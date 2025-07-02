public class strick{
public static void main(String[] args) throws Exception {
int n=0;
while(true){
if(n%3 == 1)System.out.print("\\");
else if(n%3 == 2)System.out.print("|");
else System.out.print("/");
System.out.print("\r");
n++;
Thread.sleep(100);
}
}
}