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
    System.out.println("�`��"+total+"��");
  }
}
import java.util.Scanner; 
public class hw1{
  public static void main(String args[]){
    Scanner sca=new Scanner(System.in);
    inventory drink=new inventory();
    int start=1;
    while(start){
      System.out.println("��ܥ\��(1)�s�W���~(2)��ֲ��~(3)�s�W�ƶq(4)��ּƶq(5)�p�����(6)����");
      int n=scn.nextInt();
      if(n=1){
        System.out.println("�s�W���~�M����");
        String product=scn.next();
        int price=scn.nextInt();
        drink.increase(product,price);
      }
      if(n=2){
        System.out.println("�R�����~�W��");
        String product=scn.next();
        drink.decrease(product);
      }
      if(n=3){
        System.out.println("�s�W���~�ƶq");
        String product=scn.next();
        int num=scn.nextInt();
        drink.add(product,num);
      }
      if(n=4){
        System.out.println("��ֲ��~�ƶq");
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