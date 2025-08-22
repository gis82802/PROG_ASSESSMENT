// 父類別 Caaa
class Caaa {
    // 類別成員，可選
}

// 子類別 Cbbb，繼承 Caaa
class Cbbb extends Caaa {
    // 類別成員，可選
}

public class test {
    public static void main(String[] args) {
        // 宣告一個 Caaa 型別的參考變數 aRef
        // 但將其指向一個 Cbbb 的實例
        Caaa aRef = new Cbbb();

        // 使用 getClass() 方法來獲取 aRef 實際參考的物件類別
        // 由於多型特性，aRef 的編譯時型別是 Caaa，
        // 但其執行時型別是 Cbbb。
        // getClass() 會回傳執行時的實際類別。
        Class<?> actualClass = aRef.getClass();
        
        System.out.println("aRef 變數所參考的實際類別是：" + actualClass);
    }
}