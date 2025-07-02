/*
 * name: CHEN YUN YAO
 * studentID: 41043207
 * Functions : Inventory
 * Date : 2023/03/14
 * filename : HW1.java
 */

public class HW1 {
    public static void main(String[] args){
        System.out.println("飲料店");
        Inventory A = new Inventory();
        A.listID();
        A.add("珍珠奶茶", 10 ,55);
        A.listID();
        A.add("綠茶", 5, 30);
        A.AllPrice();
        A.listID();
        A.remove(1);
        A.listID();
        A.AllPrice();

        System.out.println("3C手機店");
        Inventory B = new Inventory();
        B.listID();
        B.add("iPhone 14 Pro 256G", 10, 35000);
        B.listID();
        B.add("iPad Pro", 5, 25000);
        B.AllPrice();
        B.listID();
        B.remove(1);
        B.listID();
        B.AllPrice();
    }
}

class Inventory{
    Commodity[] a;
    int c;

    Inventory(){
        a = new Commodity[100];
        c = 0;
    }

    public void listID(){
        if (c == 0){
            System.out.println("目前沒有任何產品!!");
        }else{
            for (int i = 0; i < c; i++) {
                System.out.println("ID:" + a[i].ID + " 名稱:" + a[i].name + " 數量:" + a[i].quantity + " 價格:" + a[i].price);
            }
        }
    }

    public void add(String name, int quantity, int price){
        a[c] = new Commodity(name, quantity, price, c + 1);
        c++;
        System.out.println("商品成功增加,ID:" + a.length);
    }

    public void remove(int ID){
        for (int i = 0 ; i < a.length; i++){
            if (a[i].ID == ID){
                for (int j = i+1 ; j < c; j++){
                    a[i] = a[j];
                }
                c--;
                break;
            }
        }
        System.out.println("商品移除成功!!"); 
    }

    public void addQuantity(int ID, int i){
        for (int j = 0 ; j < c; j++){
            if (a[j].ID == ID){
                a[j].quantity += i;
            }
        }
    }

    public void reduce(int ID, int quantity){
        for (int i = 0 ; i < c ; i++){
            if(a[i].ID == ID){
                if (a[i].quantity < quantity) {
                    System.out.println("數量不夠!!");
                } else {
                    a[i].quantity -= quantity;
                    System.out.println("已減少數量,目前剩下" + a[i].quantity + "個");
                }
            }
        }
    }

    public void AllPrice(){
        int sum = 0;
        for (int i = 0; i < c ; i++){
            sum += a[i].quantity * a[i].price;
        }
        System.out.println("總價值為" + sum + "元");
    }
} 

class Commodity{
    String name;
    int price;
    int quantity;
    int ID;
    Commodity(String name, int quantity, int price, int ID){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.ID = ID;
    }
}