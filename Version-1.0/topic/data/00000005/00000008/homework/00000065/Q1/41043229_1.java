/*
 * name:楊峻朋
 * 學號:41043229
 * 班級:資二乙
 */

public class a{
    public static void main(String[] args){
        phone ph = new phone();
        beverageshop be =new beverageshop();

        ph.newitem("samsung", 10, 1000);
        ph.newitem("asus", 5, 100);
        ph.show(0);
        ph.changenum(0, -5);
        ph.show(0);

        be.newitem("black tea", 5, 10);
        be.show(0);
        be.changenum(0, 15);
        be.show(0);
    } 
}

class inventory{

    String name[] = new String[100];
    int num[] = new int[100];
    int price[] = new int[100];
    int i=0;
    public void newitem(String na,int nu,int pr){
        name[i] = na;
        price[i] = pr;
        num[i] = nu;
        i++; 
    }
    public void delitem(){

    }
    public void changenum(int c,int n){
        num[c]=num[c]+n;
    }
    public void show(int c){
        System.out.println("name: "+name[c]+"\nnum:  "+num[c]+"\nprice: "+price[c]);
    }

}
class phone extends inventory{

}
class beverageshop extends inventory{

}