/*
41043241
*/ 
class item{
    String name;
    int num;
    int price;
    item(String a,int b,int c){
        name = a;
        num = b;
        price = c;
    }
    int value(){
        return num * price;
    }
}
class Inventory{
    item[] arr;
    int cnt;
    Inventory(){
        arr = new item[1000];
        cnt = 0;
    }
    void add_product(String a,int b,int c){
        arr[cnt++] = new item(a,b,c);
    }
    void reduce_product(String a){
        boolean b = false;
        int c = 0;
        item[] tmp = new item[1000];
        for(int i = 0 ;i<cnt;i++){
            if(arr[i].name != a){
                tmp[c++] = arr[i];
            }
            else{
                b = true;
            }
        }
        if(b){
            cnt--;
        }
        arr = tmp;
    }
    void add_num(String a){
        for(int i = 0 ;i<cnt;i++){
            if(arr[i].name == a){
                arr[i].num++; 
            }
        }
    }
    void reduce_num(String a){
        for(int i = 0 ;i<cnt;i++){
            if(arr[i].name == a){
                arr[i].num--; 
            }
        }
    }
    int value(){
        int t = 0;
        for(int i = 0; i<cnt;i++){
            t += arr[i].value();
        }
        return t;
    }
}
public class hw{
    public static void main(String args[]){
        Inventory ccc = new Inventory();
        ccc.add_product("AAA",30,10);
        ccc.add_product("BBB",111,10);
        ccc.add_product("CCC",3354,10);
        ccc.add_product("DDD",3543,10);
        ccc.add_product("EEE",3054,10);
        ccc.add_product("FFF",34,10);
        ccc.add_product("GGG",34,10);
        ccc.reduce_num("GGG");
        System.out.println(ccc.value());
    }
}