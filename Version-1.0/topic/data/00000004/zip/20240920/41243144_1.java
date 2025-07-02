/*
fileName: helloworld.java
function: Use multiple methods to print Hello World
*/ 


// 定義命名空間
package September.sep_20;

public class Helloworld {
    
    public static void main(String[] args) {
        // 1.直接 print helloworld
        System.out.println("Hello, world");
        // 2.利用變數儲存hello & world，並利用format合併
        String hello = "Hello";
        String world = "World";

        System.out.println(String.format("%s, %s", hello, world));

    }
}
