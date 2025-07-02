/*建立一個類別 "Inventory"(庫存) 具有屬性像是：
產品名稱、數量、價格，並且提供成員函式可以
讓使用者新增產品、減少產品、新增數量、減少數
量、以及計算整個庫存的價值。在主程式中建立二個庫存
物件，分別給飲料店、以及3C手機店可以記錄其庫存。 */
/**
 * Inventory
 */
public class mInventory {
public static void main(String[] args) {
    Inventory beverage_shop = new Inventory();
    Inventory Smarphone3C = new Inventory();
    System.out.println("beverage_shop --------------------------------------------");
    System.out.println("newproduct:blackea");
    beverage_shop.newproduct("blacktea",20,10);
    System.out.println("addproduct_blacktea:5");
    beverage_shop.addproduct("blacktea",5);
    System.out.println("totalValue:"+beverage_shop.totalValue());
    System.out.println( "totalproduct_blacktea:"+beverage_shop.totalproduct("blacktea"));
    System.out.println("subproduct:1");
    beverage_shop.subproduct("blacktea",1);
    System.out.println("totalValue:"+beverage_shop.totalValue());
    System.out.println( "totalproduct_blacktea:"+beverage_shop.totalproduct("blacktea"));
    beverage_shop.delproduct("blacktea");
    //----------------------------------------------------------------
    System.out.println("Smarphone3C --------------------------------------------");
    System.out.println("newproduct:iphone");
    Smarphone3C.newproduct("iphone",20,10);
    System.out.println("addproduct_iphone:5");
    Smarphone3C.addproduct("iphone",5);
    System.out.println("totalValue:"+Smarphone3C.totalValue());
    System.out.println( "totalproduct_iphone:"+Smarphone3C.totalproduct("iphone"));
    System.out.println("subproduct:1");
    Smarphone3C.subproduct("iphone",1);
    System.out.println("totalValue:"+Smarphone3C.totalValue());
    System.out.println( "totalproduct_iphone:"+Smarphone3C.totalproduct("iphone"));
    Smarphone3C.delproduct("iphone");
}
    
}
class Inventory {
    private int cap;
    public product[] Products;
    public Inventory(){
        cap = 1;
        Products = new product[cap];
        Products[0] = new product("null", 0, 0); 
    }
    public void newproduct(String name,int money,int quantity){
        product[] temp = new product[cap+1];
        for(int i = 0;i<cap;i++) temp[i] = Products[i];
        Products = temp;
        cap++;
        Products[cap-1] = new product(name,money,quantity);
    }
    public int searchproduct(String name){
        int n = 0;
        boolean bol = false;
        for(int i = 0 ;i<cap;i++){
            if(Products[i].name == name){
                bol = true;
                break;
            }
            n++;
        }
        if(bol)return n;
        else return 0;
    }

    public void delproduct(String name){
        int x = searchproduct(name);
        if(x>0){
            product[] temp = new product[cap-1];
            for(int i = 0;i<cap;i++){
                if(i == x) continue;
                else temp[i] = Products[i] ;
            }
            Products = temp;
        }
    }
    public void subproduct(String name,int n){
        Products[searchproduct(name)].subquantity(n);
    }
    public void addproduct(String name,int n){
        Products[searchproduct(name)].addquantity(n);
    }
    public int totalproduct(String name){
        return Products[searchproduct(name)].value();
    } 
    public int totalValue(){
        int x = 0;
        for(int i = 0;i<cap;i++){
            x+=Products[i].value();
        }
        return x;
    }
    class product {
        public String name;
        public int pricing; //定價
        private int quantity;
        public product(String name,int pricing,int quantity){
            this.name = name;
            this.pricing = pricing;
            this.quantity = quantity;
        }
        public int value(){
            return quantity*pricing;
        }
        public void addquantity(int n){
            quantity += n;
        }
        public void subquantity(int n){
            quantity -=n;
        }
    }
}