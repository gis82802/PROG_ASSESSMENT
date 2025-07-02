/*
 * Filename: ClassInventory
 * Function: Inventory 類別
 * Author: 41043247
 * Date: 2023/3/14
 */
import java.util.LinkedList;

public class ClassInventory {
    public static void main(String[] args) {
        Inventory BeverageShop = new Inventory();
        Inventory CCCShop = new Inventory();
        BeverageShop.addProducts("Black Tea", 20, 100);
        BeverageShop.addProducts("Green Tea", 30, 100);
        BeverageShop.addProducts("Milk Tea", 40, 200);
        BeverageShop.MarketValue();

        BeverageShop.addQuantity("Black Tea", 50);
        BeverageShop.addQuantity("Green Tea", 50);
        BeverageShop.reduceQuantity("Milk Tea", 50);
        BeverageShop.MarketValue();

        BeverageShop.reduceProducts("Black Tea");
        BeverageShop.MarketValue();

        System.out.println();
        CCCShop.addProducts("S23 Ultra", 40900, 5);
        CCCShop.addProducts("iPhone 14", 38900, 15);
        CCCShop.MarketValue();

        CCCShop.addQuantity("S23 Ultra", 5);
        CCCShop.reduceQuantity("iPhone 14", 5);
        CCCShop.MarketValue();

        CCCShop.reduceProducts("iPhone 14");
        CCCShop.MarketValue();
    }
}

class Inventory {
    LinkedList<Products> ProductList;
    class Products {
        String name;
        int price;
        int quantity;
        Products(String name, int price, int quantity)  {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }
        void Print() {
            System.out.println(name + "\t" + price + "\t" + quantity);
        }
        int MarketValue() {
            return price*quantity;
        }
    }
    Inventory() {
        ProductList = new LinkedList<Products>();
    }

    private int CheckStock(String name) {
        if(ProductList.size()==0) return -1;
        int index = 0;
        while((index < ProductList.size())) {
            if(index == ProductList.size()-1 && !(name.equals(ProductList.get(index).name))) return -1;
            if(!(name.equals(ProductList.get(index).name))) index++;
            else break;
        }
        return index;
    }

    boolean addProducts (String name, int price, int quantity) {
        if(CheckStock(name) != -1) {
            System.out.println("add Error");
            return false;
        }
        ProductList.add(new Products(name, price, quantity));
        return true;
    }

    boolean reduceProducts (String name) {
        int index = CheckStock(name);
        if(index == -1) {
            System.out.println("reduce Error");
            return false;
        }
        ProductList.remove(index);
        return true;
    }

    boolean addQuantity (String name, int quantity) {
        int index = CheckStock(name);
        if(index == -1) {
            System.out.println("add Error");
            return false;
        }
        ProductList.get(index).quantity+=quantity;
        return true;
    }

    boolean reduceQuantity (String name, int quantity) {
        int index = CheckStock(name);
        if(index == -1) {
            System.out.println("reduce Error");
            return false;
        }

        ProductList.get(index).quantity-=quantity;
        return true;
    }

    private void InStock () {
        System.out.println();
        System.out.println("Name\t\tPrice\tQuantity");
        for(int i=0; i<ProductList.size(); i++)
            ProductList.get(i).Print();
    }

    void MarketValue() {
        int sum = 0;
        for(int i=0; i<ProductList.size(); i++)
            sum += ProductList.get(i).MarketValue();
        InStock();
        System.out.println("MarketValue: $" + sum);
    }
}