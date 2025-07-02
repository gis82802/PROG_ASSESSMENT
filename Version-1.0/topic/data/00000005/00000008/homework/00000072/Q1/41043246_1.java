/*
    fileName:h1.java
    function:as following
    author:41043246賴昱銘
    date:2023/03/14
    version:1.0

    (1)建立一個類別 "Inventory"(庫存) 具有屬性像是：產品名稱、數量、價格，並且提供成員函式可以讓使用者新增產品、
    減少產品、新增數量、減少數量、以及計算整個庫存的價值。在主程式中建立二個庫存物件，分別給飲料店、以及3C手機店可以記錄其庫存。
*/
import java.util.*;
class h1{    
    public static void main(String args[]){

        Inventory ship_3c=new Inventory();           
        ship_3c.add_product("apple", 10, 10);
        ship_3c.add_product("apple", 20, 10);//error
        ship_3c.add_product("banana", 20, 10);
        ship_3c.add_quantity("apple",  20);       
        System.out.println("total price: "+ship_3c.total_price());

        Inventory ship_drink=new Inventory(); 
        ship_drink.add_product("apple", 10, 10);
        ship_drink.reduce_product("banana", 20, 10);//error
        ship_drink.add_product("banana", 20, 10);
        ship_drink.reduce_quantity("banana", 50);//error
        ship_drink.reduce_quantity("banana", 2);
        System.out.println("total price: "+ship_drink.total_price());
     }
 }
 class product{
    public String name;
    public int price;
    public int quantity;
    
    product(String n,int p,int q){
        name=n;
        price=p;
        quantity=q;
    }
}
 class Inventory{

    product products[];
    int products_len;
    Inventory(){
        products=new product[100];
        products_len=0;
    }
    int product_exist(String name){
        for(int i=0;i<products_len;i++)
            if(products[i].name==name)
                return i;//find return index
        return -1;//not exist
    }
    void add_product(String name,int price,int quantity){
        if(product_exist(name)!=-1){
            System.out.println("Error: product was existed.");
        }
        else{
            products[products_len++]=new product(name, price, quantity);
            System.out.println("add product: "+name+" / price: "+price +" / quantity: "+quantity );
        }
    }
    void reduce_product(String name,int price,int quantity){
        if(product_exist(name)==-1){
            System.out.println("Error: product was not existed.");
        }
        else{
            for(int i=product_exist(name);i<products_len-1;i++){
                products[i]=products[i+1];
            }
            --products_len;
            System.out.println("reduce product: "+name+" / price: "+price +" / quantity: "+quantity );
        }
    }
    void add_quantity(String name,int quantity){
        int index=product_exist(name);
        if(index==-1){
            System.out.println("Error: product was not existed.");
        }
        else{
            products[product_exist(name)].quantity+=quantity;
            System.out.println("add quantity: prdocut "+name+" / price: "+products[index]. price +" / quantity: "+products[index]. quantity );
        }
    }
    void reduce_quantity(String name,int quantity){
        int index=product_exist(name);
        if(index==-1){
            System.out.println("Error: product was not existed.");
        }
        else if(products[index].quantity-quantity<0){
            System.out.println("Error: new quantity will be bigger than zero.");
        }
        else{
            products[index].quantity-=quantity;
            System.out.println("reduce quantity: prdocut "+name+" / price: "+products[index]. price +" / quantity: "+products[index]. quantity );
        }
    }
    int total_price(){
        int total_price=0;
        for(int i=0;i<products_len;i++){
            total_price+=products[i].price*products[i].quantity;
        }
        return total_price;
    }
}
