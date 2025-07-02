import java.util.ArrayList;

class Inventory{
    private class Product{
        String ProductName;
        int NOP,price;
    
        Product(String name,int number,int p){
            ProductName=name;
            price=p;
            NOP=number;
        }
    }

    ArrayList<Product> P;

    Inventory(){
        P=new ArrayList<Product>();
    }

    public void delP(String name){//刪除產品
        for(int a=0;a<P.size();a++){
            if(P.get(a).ProductName.equals(name)){
                P.remove(a);
                break;
            }
        }
    }

    public void newP(String name,int number,int p){//新增產品
        P.add(new Product(name, number, p));
    }

    public void IncP(String name,int n){//增加產品數量
        for(int a=0;a<P.size();a++){
            if(P.get(a).ProductName.equals(name)){
                P.get(a).NOP+=n;
                break;
            }
        }
    }

    public void DecP(String name,int n){//減少產品數量
        for(int a=0;a<P.size();a++){
            if(P.get(a).ProductName.equals(name)){
                P.get(a).NOP-=n;
                break;
            }
        }
    }

    public int POI(){
        int sum=0;
        for(int a=0;a<P.size();a++){
            sum+=P.get(a).NOP*P.get(a).price;
        }
        return sum;
    }
}

public class HW1_3_14{
    public static void main(String[] args){
        Inventory Drink,Phone;
        Drink=new Inventory();
        Phone=new Inventory();

        Drink.newP("BlackTea", 30, 20);//新增產品：紅茶
        Drink.newP("BubbleTea", 10, 50);//新增產品：珍珠奶茶
        Drink.newP("MilkTea", 20, 30);//新增產品：奶茶

        System.out.println("飲料店庫存總價值為："+Drink.POI());

        Drink.DecP("BlackTea",20);//減少產品：紅茶
        Drink.IncP("BubbleTea", 10);//增加產品：珍珠奶茶
        Drink.IncP("MilkTea", 5);//增加產品：奶茶
        System.out.println("紅茶減少20杯，奶茶增加10杯，珍珠奶茶增加5杯後的價值為："+Drink.POI());

        Drink.delP("MilkTea");//刪除奶茶
        System.out.println("刪除奶茶後，飲料店庫存的價值為："+Drink.POI());
    }
}
