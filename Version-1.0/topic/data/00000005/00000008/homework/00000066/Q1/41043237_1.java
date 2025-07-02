import java.util.Scanner;
class Inventory{
    String name;
    int quantity;
    int price;
    public Inventory(String n,int q,int p){
        name=n;
        quantity=q;
        price=p;
    }
    void add_num(int num){
        this.quantity +=num;
        System.out.println("Now "+this.name+" has "+this.quantity+" item");
    }

    void sub_num(int num){
        this.quantity -=num;
        System.out.println("Now "+this.name+" has "+this.quantity+" item");
    }

    int all_price(){

        return this.quantity*this.price;
    }
}

class Drink extends Inventory{
    public Drink(String n,int q,int p){
        super(n,q,p);
    }

}

class Cellphone extends Inventory{
    public Cellphone(String n,int q,int p){
        super(n,q,p);
    }
    
}

public class lab1_0314{
public static void main(String args[]){
    Scanner scn=new Scanner(System.in);
        System.out.println("Please set a item for tea_store");
    String n1=scn.next();
        System.out.println("Please set a quantity for "+n1);
    int q1=scn.nextInt();
        System.out.println("Please set a price for "+n1);
    int p1=scn.nextInt();
    Drink tea_store=new Drink(n1,q1,p1);
        System.out.println("All the price in tea_store of Inventory ="+tea_store.all_price()+" dallors");
        
        System.out.println("Please set a item for cellphone_store");
    String n2=scn.next();
        System.out.println("Please set a quantity for "+n2);
    int q2=scn.nextInt();
        System.out.println("Please set a price for "+n2);
    int p2=scn.nextInt();
    Cellphone phone_store=new Cellphone(n2,q2,p2);
        System.out.println("All the price in cellphone_store of Inventory ="+phone_store.all_price()+" dallors");

        System.out.println("Now please add  quantity for "+n1);
    int n=scn.nextInt();
    tea_store.add_num(n);
        System.out.println("All the price in tea_store of Inventory ="+tea_store.all_price()+" dallors");

        System.out.println("Now please sub  quantity for "+n1);
    n=scn.nextInt();
    tea_store.sub_num(n);
        System.out.println("All the price in tea_store of Inventory ="+tea_store.all_price()+" dallors");
    }
}