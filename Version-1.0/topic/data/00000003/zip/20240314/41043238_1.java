/*
   Author:資工二乙 41043238 劉章佑
   datetime: 2023/03/14
   version:1.0
   程式功能:建立一個類別 "Inventory"(庫存) 具有屬性像是：產品名稱、數量、價格，並且提供成員函式可以讓使用者新增產品、減少產品、新增數量、減少數量、以及計算整個庫存的價值。在主程式中建立二個庫存物件，分別給飲料店、以及3C手機店可以記錄其庫存。
*/
class Product
{
    private String Product_name;
    private int count;
    private int price;
    Product(String Product_name,int count,int price)
    {
        this.Product_name = Product_name;
        this.count = count;
        this.price = price;
    }
    public int getCount(){return count;}
    public void setCount(int count){this.count = count;}
    public int getPrice(){return price;}
    public String getName(){return Product_name;}
    
}
class Inventory
{
    private Product[] products; 
    Inventory()
    {
        products = new Product[0];
    }
    void Increase_Product(Product product)
    {
        Product[] NewProduct = new Product[products.length + 1]; // 建立新的產品陣列
        for(int i=0;i<products.length;i++) 
        {
            NewProduct[i] = products[i];
        }
        NewProduct[products.length] = product;
        products = NewProduct;
    }
    void Decrease_Product(Product product)
    {   
        Product[] NewProduct = new Product[products.length - 1]; // 建立新的產品陣列
        int index = 0;
        for(int i=0;i<products.length-1;i++)
        {
            if(products[i] != product)
            {
                NewProduct[index++] = products[i];
            }
        }
        products = NewProduct;
    }
    void Increase_Count(String Product_name,int count)
    {
        for(int i=0;i<products.length;i++)
        {
            if(products[i].getName() == Product_name) // 如果產品名稱和傳入的產品名稱相同，則將對應的位置，新增產品數量
            {
                products[i].setCount(products[i].getCount() + count);
                break;
            }
        }
    }
    void Decrease_Count(String Product_name,int count)
    {
        for(int i=0;i<products.length;i++)
        {
            if(products[i].getName() == Product_name) // 如果產品名稱和傳入的產品名稱相同，則將對應的位置，減少產品數量
            {
                int NewCount = products[i].getCount() - count;
                if(NewCount >= 0) // 如果減少過後的產品數量，有大於等於0 才將數量放回對應的位置
                {
                    products[i].setCount(NewCount);
                }
                else
                {
                    System.out.println("減少的產品數量不可以小於 0");
                }
                break;
            }
        }
    }
    int Inventory_Value()
    {
        int value = 0;
        for(int i = 0;i<products.length;i++)
        {
            value += products[i].getCount() * products[i].getPrice();
        }
        return value;
    }
    public void print()
    {
        for(int i=0;i<products.length;i++)
        {
            if(products[i].getCount() < 0)
            {
                continue;
            }
            System.out.println("   產品名稱:"+products[i].getName()+"，"+"產品數量:"+products[i].getCount()+"，"+"產品價值:"+products[i].getPrice());
        }
    }
}
public class HomeWork1
{
    public static void main(String args[])
    {
        Inventory beverage_Shop = new Inventory(); 
        beverage_Shop.Increase_Product(new Product("Coca-cola",100,10));
        beverage_Shop.Increase_Product(new Product("紅茶",20,5));
        beverage_Shop.Decrease_Product(new Product("紅茶",20,5));
        beverage_Shop.Increase_Count("Coca-cola",5);
        //beverage_Shop.Decrease_Count("Coca-cola",106); // 執行例外條件:減少的產品數量不可以小於 0
        int beverage_Shop_Value = beverage_Shop.Inventory_Value();
        System.out.println("飲料店的產品項目");
        beverage_Shop.print();
        System.out.println("整個庫存價值:"+beverage_Shop_Value);
        System.out.println();
        Inventory Phone_Shop = new Inventory();
        Phone_Shop.Increase_Product(new Product("Apple",20,1000));
        Phone_Shop.Increase_Product(new Product("三星",10,500));
        Phone_Shop.Increase_Count("三星",5);
        Phone_Shop.Decrease_Product(new Product("Apple",20,1000));
        int Phone_Shop_Value = Phone_Shop.Inventory_Value();
        System.out.println("3C手機店的產品項目");
        Phone_Shop.print();
        System.out.println("整個庫存價值:"+Phone_Shop_Value);

    }
}