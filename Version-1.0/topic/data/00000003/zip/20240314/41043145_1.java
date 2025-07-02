class inventory{
  int count[]=new int[100];
  int price[]=new int[100];
  int i;
  String name[]=new String[100];
  public void increase (String n,int money){
    name=n;
    price=money;
  }
  public void decrease(String n){
    for(i=0;i<100;i++){
      if(name[i]=n){
        name[i]="";
        price[i]="";
      }
     
    }
  }
  public void add(String n,int c){
    for(i=0;i<100;i++){
      if(name[i]=n)
        count[i]=c;
     
    }
  }
  public void sub(String n,int c){
    for(i=0;i<100;i++){
      if(name[i]=n)
        count[i]-=c;
     
    }
  }
  public void value(){
    int total=0;
    for(i=0;i<100;i++){
      total+=price[i]*count[i];
    }
    System.out.println("總值"+total+"元");
  }
}
import java.util.Scanner; 
public class hw1{
  public static void main(String args[]){
    Scanner sca=new Scanner(System.in);
    inventory drink=new inventory();
    int start=1;
    while(start){
      System.out.println("選擇功能(1)新增產品(2)減少產品(3)新增數量(4)減少數量(5)計算價值(6)結束");
      int n=scn.nextInt();
      if(n=1){
        System.out.println("新增產品和價格");
        String product=scn.next();
        int price=scn.nextInt();
        drink.increase(product,price);
      }
      if(n=2){
        System.out.println("刪除產品名稱");
        String product=scn.next();
        drink.decrease(product);
      }
      if(n=3){
        System.out.println("新增產品數量");
        String product=scn.next();
        int num=scn.nextInt();
        drink.add(product,num);
      }
      if(n=4){
        System.out.println("減少產品數量");
        String product=scn.next();
        int num=scn.nextInt();
        drink.sub(product,num);
      }
      if(n=5){
        
        drink.value(product,num);
      }
      if(n=6){
        start=0;
      }
    }
  }
}