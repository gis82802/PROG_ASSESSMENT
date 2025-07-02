/*
資工二甲 41043114 吳俊憲
hw1
ver 1.0.0
*/
class Inventory
{
    int n_size=0;
    int c_size=0;
    int p_size=0;
    String name[]=new String[100];
    int count[]=new int[100];
    int price[]=new int [100];
    void add_product(String n,int c,int p)
    {
        name[n_size++]=n;
        count[c_size++]=c;
        price[p_size++]=p;
    }
    void remove_product(int c)
    {
        String new_name[]=new String[100];
        int new_count[]=new int[100];
        int new_price[]=new int[100];
        System.arraycopy(name, 0, new_name, 0, c);
        System.arraycopy(name, c+1, new_name, c, name.length-c-1);
        System.arraycopy(count, 0, new_count, 0, c);
        System.arraycopy(count, c+1, new_count, c, count.length-c-1);
        System.arraycopy(price, 0, new_price, 0, c);
        System.arraycopy(price, c+1, new_price, c, price.length-c-1);
        name=new_name;
        count=new_count;
        price=new_price;
    }
    void add_count(int i,int c)
    {
        count[i]+=c;
    }
    void reduce_count(int i,int c)
    {
        count[i]-=c;
    }
    int  cal()
    {
        int sum=0;
        for(int i=0;i<n_size;i++)
        {
            sum+=count[i]*price[i];
        }
        return sum;
    }
}

public class hw1 
{
    public static void main(String[] args) 
    {
        Inventory drinks=new Inventory();
        Inventory phone=new Inventory();
        drinks.add_product("Green_tea", 20, 25);
        drinks.add_product("Red_tea", 20, 25);
        System.out.println("飲料店總庫存價值:"+drinks.cal());
        drinks.reduce_count(0, 10);
        System.out.println("飲料店總庫存價值(減少'Green_tea'數量後):"+drinks.cal());
        drinks.add_count(1, 20);
        System.out.println("飲料店總庫存價值(增加'Red_tea'數量後):"+drinks.cal());
        drinks.remove_product(0);
        System.out.println("飲料店總庫存價值(移除'Green_tea'產品後):"+drinks.cal());

        phone.add_product("phone1", 10, 15000);
        phone.add_product("phone2", 10, 20000);
        System.out.println("3C手機店總庫存價值:"+phone.cal());
        phone.reduce_count(0, 5);
        System.out.println("3C手機店總庫存價值(減少'phone1'數量後):"+phone.cal());
        phone.add_count(1, 10);
        System.out.println("3C手機店總庫存價值(增加'phone2'數量後):"+phone.cal());
        phone.remove_product(0);
        System.out.println("3C手機店總庫存價值(移除'phone1'產品後):"+phone.cal());

    }    
}
