/*
 姓名:顏嘉福
 學號:41043251
 功能:倉庫
 */
class app3_14_1
{
    public static void main (String args[])
    {
        inventory a=new inventory();
        inventory b=new inventory();
        a.newproduct("12", 30, 100);
        a.newproduct("13", 20, 150);
        a.newproduct("14", 20, 200);
        
        a.show();
        System.out.println("刪除12");
        a.reduce_product("12");
        a.show();
        System.out.println("減少13數量");
        a.new_amount("13", 10, false);
        a.show();
        System.out.println(a.account());
        b.newproduct("21", 30, 100);
        b.newproduct("22", 30, 100);
        b.newproduct("23", 30, 100);
        b.show();
        System.out.println(b.account());
    }
}
class data  //類別陣列
{
    String name;
    int amount;
    int price;
    data(){}
    void insert(String n,int a,int p)
    {
        name=n;
        amount=a;
        price=p;
    }
}
class inventory
{
    data[] array;
    int capacity=2;
    int heap=0;
    inventory() 
    {
        array=new data[capacity];
    }
    void newproduct(String n,int m,int i)   //新增產品
    {
        if(heap==capacity)
        {
            changeSize();
        }
        array[heap]=new data();
        array[heap].insert(n,m,i);
        heap++;
    }
    void reduce_product(String n)       //刪除產品
    {
        if(heap==0)
        {
            System.out.print("沒有庫存");
            return;
        }
        for(int i=0;i<heap;i++)
            if(array[i].name==n)
            {
                array[i].name=array[heap-1].name;
                array[i].amount=array[heap-1].amount;
                array[i].price=array[heap-1].price;
                break;
            }
        heap--;
    }
    void new_amount(String n,int a,boolean f)   //增加/減少數量
    {
        for(int i=0;i<heap;i++)
            if(array[i].name==n)
            {
                if(f)       //f= 1:加  0:減
                    array[i].amount += a;
                else
                     array[i].amount -=a;
                break;
            }
    }
    int account()   //總數
    {
        int a=0;
        for(int j=0;j<heap;j++)
        {
            a=a+array[j].amount*array[j].price;
        }
        return a;
    }
    void changeSize()   //陣列大小改變
    {
        capacity*=2;
        data[] a=new data[capacity];
        for(int i=0;i<heap;i++)
            a[i]=array[i];
        array=a;
    }
    void show() //顯示
    {
        for(int i=0;i<heap;i++)
            System.out.println("產品名稱: "+array[i].name+"  數量: "+array[i].amount+"  價格:"+array[i].price);
    }
}