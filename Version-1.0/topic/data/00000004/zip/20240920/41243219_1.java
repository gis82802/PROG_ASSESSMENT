
public class test{
   public static void main(String args[]){
	
	System.out.println("Hello World!");
	String str = "";
	for(int i = 0; i < args.length; i++){
	   str += args[i];
	}
	System.out.println(str);
   }
}