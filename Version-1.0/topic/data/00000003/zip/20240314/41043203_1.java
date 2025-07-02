/*
(1)建立一個類別 "Inventory"(庫存) 具有屬性像是：產品名稱、數量、價格，
並且提供成員函式可以讓使用者新增產品、減少產品、新增數量、減少數量、
以及計算整個庫存的價值。
在主程式中建立二個庫存物件，
分別給飲料店、以及3C手機店可以記錄其庫存。
2023/03/14
41043203
 */

class Inventory
{
    private String name;
    private int quantity;
    private double price;
    public Inventory(String name, int quantity, double price)
    {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void add_product(int quantity) 
    {
        this.quantity += quantity;       
    }

    public void sub_product(int quantity) 
    {
        if(this.quantity - quantity > -1)
            this.quantity -= quantity;          
    }

    public void add_quantity(int quantity) 
    {
        this.quantity += quantity;
    }

    public void sub_quantity(int quantity)
    {
        if(this.quantity - quantity >-1)
            this.quantity -= quantity;
    }
    
    public double total()
    {
        return this.quantity * this.price;
    }

//========================================================================================
//main
    public static void main(String[] args) 
    {
        Inventory drink_shop = new Inventory("drink", 100, 10);
        Inventory phone_shop = new Inventory("phone", 200, 20);
        
        System.out.println("drink shop original total = " + drink_shop.total());
        System.out.println("phone shop original total = " + phone_shop.total());

        drink_shop.add_product(30);
        drink_shop.sub_product(40);

        drink_shop.add_quantity(50);
        drink_shop.sub_quantity(60);

        phone_shop.add_product(10);
        phone_shop.sub_product(20);

        phone_shop.add_quantity(30);
        phone_shop.sub_quantity(40);
        System.out.println("====================================================");
        System.out.println("drink shop change total = " + drink_shop.total());
        System.out.println("phone shop change total = " + phone_shop.total());
    }














}



