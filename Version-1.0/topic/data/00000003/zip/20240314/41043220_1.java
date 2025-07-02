/*(1)建立一個類別 "Inventory"(庫存) 具有屬性像是：產品名稱、數量、價格，
並且提供成員函式可以讓使用者新增產品、減少產品、新增數量、減少數量、以及計算整個庫存的價值。
在主程式中建立二個庫存物件，分別給料店飲、以及3C手機店可以記錄其庫存。 */
class Inventory
{
    class product
    {
        String name;
        int price,quantity;
        product(String name,int quantity,int price)
        {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }
    }
    product arr[];
    int capacity = 5;
    int num = 0;
    Inventory()
    {
        arr = new product[capacity];
    }
    void resize()
    {
        capacity*=2;
        product newarr[]=new product[capacity];
        for(int x=0;x<capacity/2;x++)
            newarr[x] = arr[x];
        arr = newarr;
    }
    void new_product(String n,int q,int p)
    {
        if(num>=capacity)
            resize();
        arr[num++] = new product(n, q, p);
    }
    void delete_prduct(String n)
    {
        product newarr[]=new product[capacity];
        for(int x=0;x<num;x++)
        {
            if(arr[x].name==n)
                continue;
            else
                newarr[x] = arr[x];
        }
        arr = newarr;
        num--;
    }
    void add_quantity(String n,int num)
    {
        for(int x=0;x<this.num;x++)
            if(arr[x].name==n)
                arr[x].quantity+=num;
    }
    void reduce_quantity(String n,int num)
    {
        for(int x=0;x<this.num;x++)
            if(arr[x].name==n)
                arr[x].quantity-=num;
    }
    long totol_value()
    {
        long val = 0;
        for(int x=0;x<num;x++)
            val += arr[x].price * arr[x].quantity;
        return val;
    }
}

public class no1
{
    public static void main(String args[])
    {
        Inventory beverage_shop = new Inventory(),mobile_phone_shop = new Inventory();
        beverage_shop.new_product("珍珠奶茶", 50, 60);
        beverage_shop.new_product("奶茶", 100, 35);
        beverage_shop.new_product("紅茶", 120, 30);
        System.out.println("飲料店庫存價值:"+beverage_shop.totol_value());
        beverage_shop.delete_prduct("紅茶");
        beverage_shop.add_quantity("珍珠奶茶", 10);
        beverage_shop.reduce_quantity("奶茶",10);
        System.out.println("飲料店庫存價值:"+beverage_shop.totol_value());

        mobile_phone_shop.new_product("iPhone 14", 30, 30000);
        mobile_phone_shop.new_product("Samgsumg S23", 20, 33000);
        mobile_phone_shop.new_product("Samgsumg S6 Lite", 15, 16000);
        System.out.println("3C店庫存價值 :"+mobile_phone_shop.totol_value());
        mobile_phone_shop.delete_prduct("Samgsumg S6 Lite");
        mobile_phone_shop.add_quantity("Samgsumg S23", 10);
        mobile_phone_shop.reduce_quantity("iPhone", 10);
    
        System.out.println("3C店庫存價值 :"+mobile_phone_shop.totol_value());
    }
}