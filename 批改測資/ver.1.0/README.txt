main_v1.java
於2025.06.28.11:55完成開發。
可以完整的檢查標準輸出，但是無法使用輸入測資。
程式碼需放置於以下類別:
class main{
(your code)
}

以下為錯誤示範:
class HW1{
(...)
}

public class main{
(...)
}



main_v2.java
可不強制class命名為"main"，允許令其與檔名同名(但仍建議命名為main，僅作為備援方案)。
新增分母進度條


main_v3.java
預計製作標準輸入功能。
已新增，但是無正常功能，純輸出可使用
需進行相關出錯 by.0629.0318
功能均正常，但使用傳統的javac進行編譯
如果遇到主class與檔名不相同
尤其是使用public class name，且name與檔名不相同
將遇到無法順利編譯的情況
下一版本將改用java11的新功能
$java name.java，進行直接編譯，且不會產生.class檔案


main_v4
改用java11的直接執行功能，而不是javac
能解決以下問題:
public class hw2 {
    public static void main(String[] args) {
    System.out.println("Hello World!");
    }
}

此段程式碼，在javac中無法正常編譯，且會產生hw2.class檔案
(如在javac中想成功編譯，則不可使用public class hw2，需改用 class hw2)
在直接編譯的功能中，可以正常編譯，且不會產生.class的檔案
