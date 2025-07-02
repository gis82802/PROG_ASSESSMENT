/*
filename: app3_2
function: print characters
author: ToBoShu
date: 2024/09/27
version: jdk23
*/
public class app3_2 {
    public static void main(String args[]) throws Exception {
        char[] characters = { '-', '\\', '|', '/' };
	while(true){
           for (char ch : characters) {
            	System.out.print(ch);
            	Thread.sleep(200);
	    	System.out.print('\b');
            }
	}	
    }
}
