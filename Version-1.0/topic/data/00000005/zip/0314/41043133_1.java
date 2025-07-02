/*
filename:inv
function:inventory
author:41043133
datetime:20230314
version:
*/
public class inv{
    public static void main(String[] args){
        inventory drink=new inventory();
        inventory cellphone=new inventory();

        drink.insert("bubbletea", 10, 60);
        drink.insert("blacktea", 18, 30);
        drink.insert("greentea", 13, 30);
        drink.display();

        drink.decide("greentea");
        drink.display();

        drink.ocset("bubbletea", 17);
        drink.display();

        drink.invalue();

        cellphone.insert("monitor", 14, 228);
        cellphone.insert("battery", 26, 320);
        cellphone.insert("charging", 8, 105);
        cellphone.display();

        cellphone.decide("charging");
        cellphone.display();

        cellphone.ocset("monitor", 6);
        cellphone.display();

        cellphone.invalue();
    }
}

class inventory{
    String[] name;
    int[] oc;
    int[] price;
    int incnt;
    int capacity;

    inventory(){
        capacity=5; incnt=0;
        name=new String[capacity];
        oc=new int[capacity];
        price=new int[capacity];
    }

    void insert(String com, int coc, int p){
        if(incnt==capacity) limitextend();

        name[incnt]=com; oc[incnt]=coc; price[incnt]=p;
        incnt++;
    }

    void decide(String com){
        int target=-1;
        for(int i=0;i<=incnt;i++){
            if(com==name[i]) target=i;
        }

        if(target!=-1){
            if(target==incnt){
                name[target]="";
                oc[target]=0;
                price[target]=0;
            }
            else{
                for(int i=target;i<incnt;i++){
                    name[i]=name[i+1];
                    oc[i]=oc[i+1];
                    price[i]=price[i+1];
                }
            }
            incnt--;
        }
    }

    void ocset(String com, int coc){
        int target=-1;
        for(int i=0;i<=incnt;i++){
            if(com==name[i]) target=i;
        }
        if(target!=-1) oc[target]=coc;
    }

    void invalue(){
        int sum=0;
        for(int i=0;i<=incnt;i++){
            sum=sum+(oc[i]*price[i]);
        }
        System.out.println("all inventory value is "+ sum);
        System.out.println("");
    }

    void display(){
        for(int i=0;i<incnt;i++){
            System.out.println(name[i]+" have "+ oc[i] +", and "+price[i]+"/pcs");
        }
        System.out.println("");
    }

    void limitextend(){
        String[] temp=new String[capacity];
        int[] temp2=new int[capacity];
        int[] temp3=new int[capacity];

        temp=name; temp2=oc; temp3=price;
        //delete[] name; delete[] oc; delete[] price;

        capacity*=2;
        name=new String[capacity];
        oc=new int[capacity];
        price=new int[capacity];

        name=temp; oc=temp2; price=temp3;
        //delete[] temp; delete[] temp2; delete[] temp3;
    }
}
