/*
作者：徐睿澤
檔名：hw1
功能：建立一個類別 "Inventory"(庫存)
具有屬性像是：產品名稱、數量、價格，
並且提供成員函式可以讓使用者新增產品、
減少產品、新增數量、減少數量、
以及計算整個庫存的價值。
在主程式中建立二個庫存物件，
分別給飲料店、
以及3C手機店可以記錄其庫存。
<本題練習物件導向程式設計觀念>
版本：第一版
*/
import java.util.Scanner;
public class hw1{
    public static void main(String args[]){
        Inventory drink = new Inventory(3);
        int loop = 0;
        while(loop<3){
            drink.NewProduct();
            loop += 1;
        }
        loop = 0;
        while(loop<3){
            drink.PriceOfInventory(loop);
            loop += 1;
        }
    }
    static class Inventory{
        Scanner scn = new Scanner(System.in);
        String[] productName;
        int[] productQuantity;
        int[] productPrice;
        int[] list;
        int counter = 0;
        public Inventory(int number){
            productName = new String[number];
            productQuantity = new int[number];
            productPrice = new int[number];
            list = new int[number];
        }
        public boolean NewProduct(){//l:1032 c:4
            if(counter<list.length){
                int number=0;
                while(number<=counter){
                    int loop = 0;
                    while(loop<counter){
                        if(list[loop]==number)
                            break;
                        loop += 1;
                    }
                    if(loop==counter){
                        list[loop]=number;
                        break;
                    }
                    number += 1;    
                }
                productName[list[counter]] = scn.next();
                productQuantity[list[counter]] = scn.nextInt();
                productPrice[list[counter]] = scn.nextInt();
                counter += 1;
                return(true);
            }
            return(false);
        }
        public boolean DelProduct(int number){//l:1032 c:4
            if(number<counter){
                counter -=1 ;
                while(number<counter){
                    list[number]=list[number+1];
                    number += 1;
                }
                return(true);
            }
            return(false);
        }
        public boolean Increase(int number){//l:1032 c:4
            if(number<counter){
                productQuantity[list[number]] += 1;
                return(true);
            }
            return(false);
        }
        public boolean Decrease(int number){//l:1032 c:4
            if(number<counter){
                if(productQuantity[list[number]]>0){
                    productQuantity[list[number]] -= 1;
                    return(true);
                }
            }
            return(false);
        }
        public boolean PriceOfInventory(int number){//l:1032 c:4
            if(number<counter){
                System.out.println(productName[list[number]] + ":");
                System.out.println("Price:" + productPrice[list[number]]);
                System.out.println("Inventory:" + productQuantity[list[number]]);
                System.out.println("Total price:" + (productQuantity[list[number]]*productPrice[list[number]]));
                return(true);
            }
            return(false);
        }
    }
}