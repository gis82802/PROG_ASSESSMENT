/*
* Filename : j41043152_Ex10_01.java
* Function : 建立一個類別 "Inventory"(庫存) 具有屬性像是：產品名稱、數量、價格，
             並且提供成員函式可以讓使用者新增產品、減少產品、新增數量、減少數量、以及計算整個庫存的價值。在主程式中建立二個庫存物件，分別給飲料店、以及3C手機店可以記錄其庫存。
* Author   : 許書和 41043152
* DateTime : 2023/3/14
* Version  : 1.0
*/
import java.util.Scanner;
public class j41043152_Ex10_01{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        Inventory drinkshop = new Inventory();
        System.out.print("number of add products: 2\n");
        // int n = scanner.nextInt();
        drinkshop.objProduct[0].addProduct("Tea", 10, 10);   //新增產品
        drinkshop.objProduct[1].addProduct("Milk", 20, 30);   //新增產品
        for(int i = 0; i < 2; i++){
            drinkshop.objProduct[i].showProduct();  //計算整個庫存的價值
        }

        System.out.println("Removing Milk");
        drinkshop.objProduct[1].removeProduct();    //減少產品
        for(int i = 0; i < 2; i++){
            drinkshop.objProduct[i].showProduct();
        }

        System.out.println("新增數量+10");
        for(int i = 0; i < 2; i++){
            drinkshop.objProduct[i].changeAmount(10); //新增數量
        }
        for(int i = 0; i < 2; i++){
            drinkshop.objProduct[i].showProduct();
        }

        System.out.println("減少數量-5");
        for(int i = 0; i < 2; i++){
            drinkshop.objProduct[i].changeAmount(-5); //減少數量
        }
        for(int i = 0; i < 2; i++){
            drinkshop.objProduct[i].showProduct();
        }


        Inventory phoneshop = new Inventory();
        System.out.print("number of add products: 2\n");
        // int n = scanner.nextInt();
        phoneshop.objProduct[0].addProduct("iPhone", 100, 20000);   //新增產品
        phoneshop.objProduct[1].addProduct("Sony X", 53, 10000);   //新增產品
        for(int i = 0; i < 2; i++){
            phoneshop.objProduct[i].showProduct();  //計算整個庫存的價值
        }

        System.out.println("Removing iPhone");
        phoneshop.objProduct[0].removeProduct();    //減少產品
        for(int i = 0; i < 2; i++){
            phoneshop.objProduct[i].showProduct();
        }

        System.out.println("新增數量+100");
        for(int i = 0; i < 2; i++){
            phoneshop.objProduct[i].changeAmount(100); //新增數量
        }
        for(int i = 0; i < 2; i++){
            phoneshop.objProduct[i].showProduct();
        }

        System.out.println("減少數量-50");
        for(int i = 0; i < 2; i++){
            phoneshop.objProduct[i].changeAmount(-50); //減少數量
        }
        for(int i = 0; i < 2; i++){
            phoneshop.objProduct[i].showProduct();
        }
    }
}

class Inventory{
    Product objProduct[];
    
    Inventory(){
        objProduct = new Product[10];
        for(int i = 0; i < objProduct.length; i++){
            objProduct[i] = new Product();
        }
    }
}

class Product {
    String name;     // add, remove func
    int amount,         // increace, decreace func
        price;          // calculate price func
    Scanner scanner = new Scanner(System.in);
    Product(){
        //this.addProduct();
    }
    void showProduct(){
        System.out.println("\tProduct: " + this.name + " amount: " + this.amount + " price: " + this.price + " \n\tTotal price: " + this.calculatePrice());
    }
    void addProduct(){
        System.out.print("Input product name:");
        this.name = scanner.nextLine();
        this.changeAmount();
        System.out.print("Input product price:");
        this.price = scanner.nextInt();
    }
    void addProduct(String str, int amount, int pr){
        this.name = str;
        this.amount = amount;
        this.price = pr;
    }
    void removeProduct(){
        this.name = "nan";
        this.amount = 0;
        this.price = 0;
    }
    void changeAmount(){
        if(this.name == "nan") return;
        System.out.print("Input product amount:");
        this.amount = scanner.nextInt();
        this.calculatePrice();
    }
    void changeAmount(int num){
        if(this.name == "nan") return;
        this.amount += num;
        this.calculatePrice();
    }
    int calculatePrice(){
        return(this.amount * this.price);
    }
}