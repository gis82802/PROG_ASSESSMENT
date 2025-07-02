/* filename:Storage
 * function:倉儲系統
 * author:41043239 蔡今瑞
 * datetime:2023/03/14
 * version:1.0
 */

import java.util.Scanner;
import java.util.LinkedList;
class item{
    public String productName;
    public int count;
    public int price;
    public item(){
        productName=null;
        count=0;
        price=0;
    }
}
class Inventory{
    private LinkedList<item> product;
    public Inventory(){
        product=new LinkedList<item>();
    }
    public void newProduct(item item[],int n){
        item tempItem=new item();
        tempItem.productName=item[n].productName;
        tempItem.count=item[n].count;
        tempItem.price=item[n].price;
        int i;
        for(i=0;i<product.size();i++)
            if(product.get(i).productName.equals(tempItem.productName)==true)
                break;
        if(i==product.size())
            product.add(tempItem);
        else
            product.get(i).productName=tempItem.productName;
    }
    public void removeProduct(item item[],int n){
        String nametemp=item[n].productName;
        int i;
        for(i=0;i<product.size();i++)
            if(product.get(i).productName.equals(nametemp)==true)
                break;
        if(i==product.size())
            System.out.println("not found");
        else
            product.remove(i);
    }
    public void increase(item item[],int n){
        item tempItem=new item();
        tempItem.productName=item[n].productName;
        tempItem.count=item[n].count*20;
        int i;
        for(i=0;i<product.size();i++)
            if(product.get(i).productName.equals(tempItem.productName)==true)
                break;
        if(i==product.size())
            System.out.println("not found");
        else
            product.get(i).count=tempItem.count;
    }
    public void decrease(item item[],int n){
        item tempItem=new item();
        tempItem.productName=item[n].productName;
        tempItem.count=10;
        int i;
        for(i=0;i<product.size();i++)
            if(product.get(i).productName.equals(tempItem.productName)==true)
                break;
        if(i==product.size())
            System.out.println("not found");
        else
            product.get(i).count=tempItem.count;
    }
    public void totalValue(){
        int sum=0;
        for(int i=0;i<product.size();i++){
            sum+=product.get(i).count*product.get(i).price;
        }
        System.out.printf("value of inventory is %d\n",sum);
    }
    public void printContent(){
        System.out.printf("Name\tcount\tprice\n");
        for(int i=0;i<product.size();i++){
            System.out.printf("%s\t%d\t%d\n",product.get(i).productName,product.get(i).count,product.get(i).price);
        }
    }
}
public class Storage{
    public static void main(String[] args){
        item[] ditem=new item[3];
        for(int i=0;i<3;i++)
            ditem[i]=new item();
        ditem[0].productName="cola";     ditem[0].price=100;     ditem[0].count=200;
        ditem[1].productName="cola2";    ditem[1].price=200;     ditem[1].count=400;
        ditem[2].productName="cola3";    ditem[2].price=300;     ditem[2].count=600;

        Inventory drink=new Inventory();
        for(int i=0;i<3;i++)
            drink.newProduct(ditem,i);
        drink.printContent();   System.out.println();

        drink.increase(ditem,1);
        drink.printContent();   System.out.println();

        drink.decrease(ditem,2);
        drink.printContent();   System.out.println();

        drink.removeProduct(ditem,0);
        drink.printContent();   System.out.println();

        drink.totalValue();


        item[] tricitem=new item[3];
        for(int i=0;i<3;i++)
            tricitem[i]=new item();
        tricitem[0].productName="iphone";     tricitem[0].price=100;     tricitem[0].count=200;
        tricitem[1].productName="iphone2";    tricitem[1].price=200;     tricitem[1].count=400;
        tricitem[2].productName="iphone3";    tricitem[2].price=300;     tricitem[2].count=600;
        Inventory tripleC=new Inventory();

        for(int i=0;i<3;i++)
            tripleC.newProduct(tricitem,i);
        tripleC.printContent();     System.out.println();

        tripleC.increase(tricitem,1);
        tripleC.printContent();     System.out.println();

        tripleC.decrease(tricitem,2);
        tripleC.printContent();     System.out.println();

        tripleC.removeProduct(tricitem,0);
        tripleC.printContent();     System.out.println();

        tripleC.totalValue();
    }
}